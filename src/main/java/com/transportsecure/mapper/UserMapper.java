package com.transportsecure.mapper;

import com.transportsecure.dto.CreateUserDTO;
import com.transportsecure.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(CreateUserDTO user);
    CreateUserDTO toDTO(User user);
}
