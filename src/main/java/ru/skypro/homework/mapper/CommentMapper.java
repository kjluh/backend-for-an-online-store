package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.Comment;
import ru.skypro.homework.entity.CommentEntity;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(source = "id", target = "pk")
    @Mapping(source = "user", target = "author")
    @Mapping(source = "user", target = "authorImage")
    @Mapping(source = "user", target = "authorFirstName")
    @Mapping(source = "createTime", target = "createdAt")
    Comment commentEntityToComment(CommentEntity commentEntity);


}
