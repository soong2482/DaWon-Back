package hello.hellospring.SpringSecurity.CustomAuthenticationFilter;

import hello.hellospring.SpringSecurity.CustomHandler.CustomAuthenticationFailureHandler;
import hello.hellospring.SpringSecurity.CustomHandler.CustomAuthenticationSuccessHandler;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class CustomAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final CustomAuthenticationSuccessHandler successHandler;
    private final CustomAuthenticationFailureHandler failureHandler;

    public CustomAuthenticationFilter(CustomAuthenticationSuccessHandler successHandler, CustomAuthenticationFailureHandler failureHandler) {
        super(new AntPathRequestMatcher("/DaWonCar/Admin/**"));
        this.successHandler = successHandler;
        this.failureHandler = failureHandler;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            throw new AuthenticationException("Session not found or user not authenticated") {};
        }
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) session.getAttribute("role");
        boolean isAdmin = false;
        for (GrantedAuthority authority : authorities) {
            if ("ROLE_ADMIN".equals(authority.getAuthority())) {
                isAdmin = true;
                break;
            }
        }
        if (!isAdmin) {
            throw new AuthenticationException("User does not have ADMIN privileges") {};
        }
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                session.getAttribute("user"),
                null,
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"))
        );
        return this.getAuthenticationManager().authenticate(authRequest);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        successHandler.onAuthenticationSuccess(request, response, authResult);
        chain.doFilter(request, response);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        failureHandler.onAuthenticationFailure(request, response, failed);
    }
}
