package hello.hellospring.loginInfo.CustomUser;


import hello.hellospring.loginInfo.domain.User;
import hello.hellospring.loginInfo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        throw new UsernameNotFoundException("User not found with username: " + username);
    }

    public boolean findyById(String username) {
        try {
            if (userMapper.FindById(username) != null) {
                return true;
            } else {
                log.error("Failed to FindById:{}", username);
                return false;
            }
        } catch (Exception e) {
            log.error("Error while finding user by id: {}", e.getMessage());
            return false;
        }
    }
    public CustomUserDetails findByPassword(String username) {
        try {
            User user = userMapper.FindByPassword(username);

            if (user != null) {
                CustomUserDetails customUserDetails = new CustomUserDetails();
                customUserDetails.setUsers(user.getUsername());
                customUserDetails.setName(user.getUsername());
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(user.getAuthority()));
                customUserDetails.setAuthorities(authorities);
                customUserDetails.setEnabled(user.isEnabled());
                customUserDetails.setPassword(user.getPassword());
                return customUserDetails;
            }
        } catch (Exception e) {
            log.error("Error while finding user by password: {}", e.getMessage());
        }
        return null;
    }
}
