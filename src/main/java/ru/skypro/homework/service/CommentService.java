package ru.skypro.homework.service;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.Comment;
import ru.skypro.homework.entity.CommentEntity;
import ru.skypro.homework.mapper.CommentMapper;
import ru.skypro.homework.repositories.CommentRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;


    public CommentService(CommentRepository commentsForAdsRepository) {
        this.commentRepository = commentsForAdsRepository;
    }

    public List<Comment> getAllCommentsByAdsId(int adId) {
        List<CommentEntity> commentEntityList = new ArrayList<>();
        commentEntityList.addAll(commentRepository.findCommentEntitiesByAdsEntity_Id(adId));

        List<Comment> commentDtoList = new ArrayList<>();

        for (int i = 0; i < commentEntityList.size()+1; i++) {
            Comment thisComment = CommentMapper.INSTANCE.commentEntityToComment(commentEntityList.get(i));
            commentDtoList.add(thisComment);
        }

        return commentDtoList;
    }

    public Comment createNewAdsComment(int adId, String commentText) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setText(commentText);
        commentEntity.setCreateTime(LocalDateTime.now());
        commentRepository.save(commentEntity);

        Comment newComment = CommentMapper.INSTANCE.commentEntityToComment(commentEntity);
//        newComment.setCreatedAt(LocalDateTime.now(ZoneOffset.UTC).toInstant(ZoneOffset.UTC).toEpochMilli());
        return newComment;
    }
    public void deleteCommentByAdsIdAndCommentEntityId(int adId, int id) {
        commentRepository.deleteCommentEntityByIdAndAdsEntity_Id(adId, id);
    }

    public void patchCommentByAdsIdAndCommentEntityId(int adId, int id) {
        commentRepository.deleteCommentEntityByIdAndAdsEntity_Id(adId, id);
    }

}


