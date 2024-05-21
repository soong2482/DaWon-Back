package hello.hellospring.loginInfo.service;

import hello.hellospring.loginInfo.CustomUser.CustomUserDetails;
import hello.hellospring.loginInfo.domain.LoginRequest;
import hello.hellospring.loginInfo.mapper.UserMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public LoginService(AuthenticationManager authenticationManager, UserMapper userMapper) {
        this.authenticationManager = authenticationManager;
        this.userMapper = userMapper;
    }

    public void Login(LoginRequest loginRequest, HttpServletResponse response, HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            Authentication authenticationRequest =
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
            Authentication authenticationResponse =
                    this.authenticationManager.authenticate(authenticationRequest);
            SecurityContextHolder.getContext().setAuthentication(authenticationResponse);

            CustomUserDetails userDetails = (CustomUserDetails) authenticationResponse.getPrincipal();
            session = request.getSession(true);
            session.setAttribute("user", userDetails);
            session.setAttribute("role", userDetails.getAuthorities());
            session.setMaxInactiveInterval(60*30);
            String sessionId = request.getSession().getId();
            Cookie cookie = new Cookie("JSESSIONID" , sessionId);
            cookie.setHttpOnly(true);
            cookie.setSecure(true);
            response.addCookie(cookie);
        }



    }
}
