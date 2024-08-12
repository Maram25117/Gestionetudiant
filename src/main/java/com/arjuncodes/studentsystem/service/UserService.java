package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {
    void save(User user);
    User findByUsername(String username);

}



