package hello.hellospring.SpringSecurity.CustomHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.getWriter().println("Authentication failed: " + exception.getMessage());

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // HTTP 302 Found
        response.setHeader("Location", "/adminpage");
    }
}
