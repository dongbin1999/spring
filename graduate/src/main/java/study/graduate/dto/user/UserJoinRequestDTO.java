package study.graduate.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import study.graduate.domain.user.UserEntity;

//기본 생성자. 아무 생성자도 안만들면 기본생성자는 자동으로 만들어진다.
//@NoArgsConstructor
@Getter
public class UserJoinRequestDTO {

    private String userName;
    private String userEmail;
    private String loginId;
    private String password;

    public UserEntity toUserEntity(){
        return UserEntity.builder()
                .userName(userName)
                .userEmail(userEmail)
                .loginId(loginId)
                .password(password)
                .build();
    }
}