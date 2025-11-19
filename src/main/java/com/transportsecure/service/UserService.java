package com.transportsecure.service;

import com.transportsecure.dto.CreateUserDTO;
import com.transportsecure.dto.UpdateUserDTO;
import com.transportsecure.entity.User;
import com.transportsecure.mapper.UserMapper;
import com.transportsecure.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(CreateUserDTO dto) {
        User user = userMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(UpdateUserDTO dto) {
        User user = userRepository.findById(dto.getId()).orElseThrow(() -> {
            new RuntimeException("user not found");
            return null;
        });
        if (!passwordEncoder.matches(dto.getOldPassword(), user.getPassword())) {
            throw new RuntimeException("invalid old password");
        }
        if (!dto.getNewPassword().equals(dto.getConfirmPassword())) {
            throw new RuntimeException("Password confirmation does not match");
        }
        user.setPassword(passwordEncoder.encode(dto.getNewPassword()));

        user.setActive(dto.isActive());
        user.setSpecialty(dto.getSpecialty());

        return userRepository.save(user);
    }

    public String DeleteUserById(String id) {
        userRepository.deleteById(id);
        return "user has been deleted";
    }
    public User findUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> {
            new RuntimeException("user not found");
            return null;
        });
    }
}
