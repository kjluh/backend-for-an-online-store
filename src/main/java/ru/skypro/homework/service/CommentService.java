package ru.skypro.homework.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.skypro.homework.dto.Comment;
import ru.skypro.homework.dto.CreateComment;
import ru.skypro.homework.dto.ResponseWrapperComment;
import ru.skypro.homework.entity.CommentEntity;
import ru.skypro.homework.mapper.CommentMapper;
import ru.skypro.homework.repositories.CommentRepository;
import ru.skypro.homework.security.MyUserDetails;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final AdsService adsService;
    private final MyUserDetails myUserDetails; // спринг секьюрити сюда положит авторизированного пользователя


    public CommentService(CommentRepository commentsForAdsRepository, UserService userService, AdsService adsService, MyUserDetails myUserDetails) {
        this.commentRepository = commentsForAdsRepository;
        this.userService = userService;
        this.adsService = adsService;
        this.myUserDetails = myUserDetails;
    }

    @Transactional(readOnly = true)
    public ResponseWrapperComment getAllCommentsByAdsId(int adId) {
        List<CommentEntity> commentEntityList = new ArrayList<>();
        commentEntityList.addAll(commentRepository.findCommentEntitiesByAdsEntity_Id(adId));

        List<Comment> commentDtoList = new ArrayList<>();

        for (CommentEntity commentEntity : commentEntityList) {
            Comment thisComment = CommentMapper.INSTANCE.commentEntityToComment(commentEntity);
//            если аватарки нет ссылку не сетим
            if (commentEntity.getAuthor().getAvatarUserEntity() != null) {
                thisComment.setAuthorImage("/users/avatar/" + userService.getUserEntity(commentEntity.getAuthor().getUsername()).getId() + "/db");
            }
            //При мапинге время не переделывалось строку.
            thisComment.setCreatedAt(commentEntity.getCreateTime().toInstant(ZoneOffset.UTC).toEpochMilli());

            commentDtoList.add(thisComment);
        }

        ResponseWrapperComment responseWrapperComment = new ResponseWrapperComment();
        responseWrapperComment.setCount(commentDtoList.size());
        responseWrapperComment.setResults(commentDtoList);
        return responseWrapperComment;
    }

    @Transactional
    public Comment createNewAdsComment(int adId, CreateComment commentText) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setCommentText(commentText.toString());
        commentEntity.setCreateTime(LocalDateTime.now(ZoneOffset.UTC));
        commentEntity.setAuthor(userService.getUserEntity(myUserDetails.getUsername())); // чуть переделал авторизацию
        commentEntity.setAdsEntity(adsService.findById(adId));
        commentRepository.save(commentEntity);

        Comment newComment = CommentMapper.INSTANCE.commentEntityToComment(commentEntity);
        newComment.setCreatedAt(commentEntity.getCreateTime().toInstant(ZoneOffset.UTC).toEpochMilli());
        return newComment;
    }

    @Transactional
    public boolean deleteCommentByAdsIdAndCommentEntityId(int adId, int id) {
        if (isChoiceRole(id)) {
            commentRepository.deleteCommentEntityByAdsEntity_IdAndId(adId, id);
            return true;
        }
        return false;
    }

    @Transactional
    public Comment patchCommentByAdsIdAndCommentEntityId(int adId, int id, Comment comment) {
        if (isChoiceRole(id)) {
            comment.setPk(id);
            comment.setCreatedAt(LocalDateTime.now(ZoneOffset.UTC).toInstant(ZoneOffset.UTC).toEpochMilli());
            comment.setAuthor(userService.getUserEntity(myUserDetails.getUsername()).getId());
            comment.setAuthorFirstName(userService.getUserEntity(myUserDetails.getUsername()).getFirstName());
            comment.setAuthorImage("/users/avatar/" + userService.getUserEntity(myUserDetails.getUsername()).getId() + "/db");

            CommentEntity commentEntity = CommentMapper.INSTANCE.commentToCommentEntity(comment);

            commentEntity.setCreateTime(Instant.ofEpochMilli(comment.getCreatedAt()).atZone(ZoneOffset.UTC).toLocalDateTime());

            commentEntity.setAdsEntity(adsService.findById(adId));

            commentRepository.save(commentEntity);

            return comment;
        }
        return null; //тут нужно вернуть, 403 дима пишет
    }

    private boolean isChoiceRole(int id) {
        return (myUserDetails.getUsername().equals(commentRepository.findById(id).orElseThrow().getAuthor().getUsername())
                || myUserDetails.getAuthorities().contains("ADMIN"));
    }

}


