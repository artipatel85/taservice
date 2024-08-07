package com.tekanthem.finance.service.impl;

import com.tekanthem.finance.entity.UserD;
import com.tekanthem.finance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) {
        UserD entity = userRepository.findByUserName(username);
        return new User(entity.getUserName(), encoder.encode(entity.getPassword()),
                List.of(new SimpleGrantedAuthority(entity.getRole())));
    }

    public UserD findByUserName(String username) {
        return userRepository.findByUserName(username);
    }
}
