package hello.hellospring.SpringSecurity.AuthenticationProvider;

import hello.hellospring.loginInfo.CustomUser.CustomUserDetails;
import hello.hellospring.loginInfo.CustomUser.CustomUserDetailsService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;


@Component
public class CustomAuthenticationProvider  implements AuthenticationProvider {

    private final CustomUserDetailsService customUserDetailsService;

    public CustomAuthenticationProvider(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication.getCredentials() == null) {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
        } else {

            String username = authentication.getName();
            String password = authentication.getCredentials().toString();

            if (customUserDetailsService.findyById(username)) {
                CustomUserDetails customUserDetails = customUserDetailsService.findByPassword(username);
                if (customUserDetails != null && customUserDetails.getPassword().equals(password)) {
                    return new UsernamePasswordAuthenticationToken(customUserDetails, password, customUserDetails.getAuthorities());
                }
            }
            throw new BadCredentialsException("Invalid username or password");
        }
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
