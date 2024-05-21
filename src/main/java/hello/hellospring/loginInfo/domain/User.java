package hello.hellospring.loginInfo.domain;

import lombok.Data;

@Data
public class User{
    private String username;
    private String password;
    private boolean enabled;
    private String authority;
}
