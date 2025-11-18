package com.transportsecure.mapper;

import com.transportsecure.dto.CreateUserDTO;
import com.transportsecure.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User toEntity(CreateUserDTO user);
    CreateUserDTO toDTO(User user);
}
