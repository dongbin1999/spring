package study.graduate.domain.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.graduate.domain.post.PostEntity;
import study.graduate.dto.user.UserUpdateRequestDTO;

import java.util.List;

@Getter
@Entity
//지연로딩..알아보자.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {

    @Id
    //이게 ID 자동으로 부여하는거다.
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    //nullable 써야되는데 굳이 안쓸이유가 없다. null값 들어가도되면 말고. 근데? db에서 null값을 허용하는게 안좋다.
    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @Column(name = "login_id", nullable = false)
    private String loginId;

    @Column(name = "password", nullable = false)
    private String password;

    @Builder
    //생성자는 클래스이름이랑 똑같이..
    //ID속성은 자동으로 부여되는거라서 우리가 임의로 세팅하면 안된다.
    public UserEntity(String userName, String userEmail, String loginId, String password){
        this.userName=userName;
        this.userEmail=userEmail;
        this.loginId=loginId;
        this.password=password;
    }

    public void updateUser(UserUpdateRequestDTO userUpdateRequestDTO){
        this.userName=userUpdateRequestDTO.getUserName();
        this.password=userUpdateRequestDTO.getPassword();
    }

    //영속성 전이는 OneToMany에서밖에 안되는데, 일대다 단방향은 별로 안좋아.. 양방향이면 ok. 수동으로 전이하는 방법도 생각해보자.
    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.PERSIST, orphanRemoval = true)
    //new ArrayList 할 이유가..??
    private List<PostEntity> posts;
}
