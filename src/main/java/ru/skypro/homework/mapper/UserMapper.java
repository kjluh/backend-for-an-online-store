package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.RegisterReq;
import ru.skypro.homework.entity.UserEntity;
import ru.skypro.homework.dto.User;

@Mapper()
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity toEntity(User user);

    UserEntity toEntity(RegisterReq req);

    User toDTO(UserEntity userEntity);
}
