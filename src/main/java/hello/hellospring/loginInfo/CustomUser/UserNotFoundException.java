package hello.hellospring.loginInfo.CustomUser;

public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String message) {
        super(message);
    }
}
