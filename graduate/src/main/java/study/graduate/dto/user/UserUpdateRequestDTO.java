package study.graduate.dto.user;

import lombok.Getter;

@Getter
public class UserUpdateRequestDTO {

    private Long userId;
    private String userName;
    private String password;
}
