package com.we2seek.webgreetings.server.auth;

import com.we2seek.webgreetings.shared.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetails implements UserDetailsService {

    private static final Set<User> hardcodedUsers = new HashSet<>();

    static {
        hardcodedUsers.add(new User("adm", "adm"));
        hardcodedUsers.add(new User("usr", "usr"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findUser(username);
        Set<GrantedAuthority> userAuthorities = new HashSet<>();
        userAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                userAuthorities
        );

        return userDetails;
    }

    private User findUser(String username) {
        if (username == null) {
            throw new NullPointerException("User name is null");
        }

        for (User user : hardcodedUsers) {
            if (username.equalsIgnoreCase(user.getUsername())) {
                return user;
            }
        }

        throw new UsernameNotFoundException("Not found: \'" + username + "\'");
    }

}
