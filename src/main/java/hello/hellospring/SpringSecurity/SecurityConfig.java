package hello.hellospring.SpringSecurity;

import hello.hellospring.SpringSecurity.AuthenticationProvider.CustomAuthenticationProvider;
import hello.hellospring.SpringSecurity.CustomAuthenticationFilter.CustomAuthenticationFilter;
import hello.hellospring.SpringSecurity.CustomHandler.CustomAuthenticationFailureHandler;
import hello.hellospring.SpringSecurity.CustomHandler.CustomAuthenticationSuccessHandler;
import hello.hellospring.loginInfo.CustomUser.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter(customAuthenticationSuccessHandler(), customAuthenticationFailureHandler());
        filter.setAuthenticationManager(authenticationManager(null, customAuthenticationProvider(null)));
        return filter;
    }

    @Bean
    public CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }

    @Bean
    public CustomAuthenticationFailureHandler customAuthenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

    @Bean
    public CustomAuthenticationProvider customAuthenticationProvider(CustomUserDetailsService customUserDetailsService) {
        return new CustomAuthenticationProvider(customUserDetailsService);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration, CustomAuthenticationProvider customAuthenticationProvider) throws Exception {
        ProviderManager authenticationManager = (ProviderManager) authenticationConfiguration.getAuthenticationManager();
        authenticationManager.getProviders().add(customAuthenticationProvider);
        return authenticationManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(HttpMethod.POST,"/DaWonCar/Admin/**").hasRole("ADMIN")
                        .anyRequest().permitAll()
                )
                .httpBasic(withDefaults())
                .formLogin(formLogin -> formLogin.disable())
                .sessionManagement(sessionManagement -> sessionManagement
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                        .sessionFixation().changeSessionId()
                        .maximumSessions(1).maxSessionsPreventsLogin(false)

                ) .exceptionHandling(exceptionHandling -> exceptionHandling
                        .accessDeniedHandler(new AccessDeniedHandlerImpl())
                );

        http.addFilterBefore(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
