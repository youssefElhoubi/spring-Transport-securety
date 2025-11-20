package com.transportsecure.MapperImplementation;

import com.transportsecure.dto.CreateUserDTO;
import com.transportsecure.entity.User;
import com.transportsecure.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperIplem implements UserMapper {
    @Override
    public User toEntity(CreateUserDTO dto) {
        if (dto == null) {
            return null;
        }

        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        user.setSpecialty(dto.getSpecialty());
        user.setActive(dto.isActive());

        return user;
    }

    @Override
    public CreateUserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }

        CreateUserDTO dto = new CreateUserDTO();
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        dto.setSpecialty(user.getSpecialty());
        dto.setActive(user.isActive());

        return dto;
    }
}
