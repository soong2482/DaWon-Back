package hello.hellospring.loginInfo.domain;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
