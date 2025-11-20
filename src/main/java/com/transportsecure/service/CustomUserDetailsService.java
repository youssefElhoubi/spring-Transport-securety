package com.transportsecure.service;

import com.transportsecure.entity.User;
import com.transportsecure.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException(id));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole())));
    }
}
