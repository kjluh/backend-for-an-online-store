package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.RegisterReq;
import ru.skypro.homework.entity.UserEntity;
import ru.skypro.homework.dto.User;

@Mapper()
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "email", target = "username")
    UserEntity toEntity(User user);

    UserEntity toEntity(RegisterReq req);

    @Mapping(source = "username", target = "email")
    User toDTO(UserEntity userEntity);
}
