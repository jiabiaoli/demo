package com.example.security.userdetails;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SecurityUserDetailsService implements UserDetailsService{
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws
                                                           UsernameNotFoundException{
        log.info("login:{}", username);
        UserDetail user = userService.loadUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("用户未找到");
        }

        return user;
    }

}
