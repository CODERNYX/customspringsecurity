package com.example.springsecurityolderversionsecond.security;

import com.example.springsecurityolderversionsecond.model.User;
import com.example.springsecurityolderversionsecond.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }
}
