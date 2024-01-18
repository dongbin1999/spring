package user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
//simple logging facade for java.
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
}