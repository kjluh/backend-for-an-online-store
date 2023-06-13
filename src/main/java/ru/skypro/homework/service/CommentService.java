package ru.skypro.homework.service;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.Comment;
import ru.skypro.homework.dto.CreateComment;
import ru.skypro.homework.dto.ResponseWrapperComment;
import ru.skypro.homework.entity.CommentEntity;
import ru.skypro.homework.mapper.CommentMapper;
import ru.skypro.homework.repositories.CommentRepository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final AdsService adsService;


    public CommentService(CommentRepository commentsForAdsRepository, UserService userService, AdsService adsService) {
        this.commentRepository = commentsForAdsRepository;
        this.userService = userService;
        this.adsService = adsService;
    }

    public ResponseWrapperComment getAllCommentsByAdsId(int adId) {
        List<CommentEntity> commentEntityList = new ArrayList<>();
        commentEntityList.addAll(commentRepository.findCommentEntitiesByAdsEntity_Id(adId));

        List<Comment> commentDtoList = new ArrayList<>();

        for (CommentEntity commentEntity: commentEntityList) {
            Comment thisComment = CommentMapper.INSTANCE.commentEntityToComment(commentEntity);
            commentDtoList.add(thisComment);
        }

        ResponseWrapperComment responseWrapperComment = new ResponseWrapperComment();
        responseWrapperComment.setCount(commentDtoList.size());
        responseWrapperComment.setResults(commentDtoList);
        return responseWrapperComment;
    }

    public Comment createNewAdsComment(int adId, CreateComment commentText) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setCommentText(commentText.toString());
        commentEntity.setCreateTime(LocalDateTime.now());
        commentEntity.setAuthor(userService.getUserEntity("user@gmail.com"));
        commentEntity.setAdsEntity(adsService.findById(adId));
        commentRepository.save(commentEntity);

        Comment newComment = CommentMapper.INSTANCE.commentEntityToComment(commentEntity);
        newComment.setCreatedAt(LocalDateTime.now(ZoneOffset.UTC).toInstant(ZoneOffset.UTC).toEpochMilli());
        return newComment;
    }
    public void deleteCommentByAdsIdAndCommentEntityId(int adId, int id) {
        commentRepository.deleteCommentEntityByIdAndAdsEntity_Id(adId, id);
    }

    public Comment patchCommentByAdsIdAndCommentEntityId(int adId, int id, Comment comment) {
        comment.setPk(id);
        comment.setCreatedAt(LocalDateTime.now(ZoneOffset.UTC).toInstant(ZoneOffset.UTC).toEpochMilli());
        System.out.println("1 - " + comment);

        CommentEntity commentEntity = CommentMapper.INSTANCE.commentToCommentEntity(comment);
        commentEntity.setCreateTime(Instant.ofEpochMilli(comment.getCreatedAt()).atZone(ZoneId.systemDefault()).toLocalDateTime());
        System.out.println("2 - " + commentEntity);

        commentEntity.setAdsEntity(adsService.findById(adId));

        commentRepository.save(commentEntity);

        return comment;
    }

}


