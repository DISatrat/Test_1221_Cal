package com.example.test_1221_cal.mapper;

import com.example.test_1221_cal.dto.UserDTO;
import com.example.test_1221_cal.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toEntity(UserDTO dto);
}
