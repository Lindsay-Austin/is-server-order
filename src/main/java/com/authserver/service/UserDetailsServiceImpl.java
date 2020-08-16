package com.authserver.service;


import com.authserver.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = new User();
        user.setId(1L);
        user.setUsername("username");

        return user;
    }
}
