package ru.skypro.homework.service;

import ru.skypro.homework.dto.Comment;
import ru.skypro.homework.dto.CreateComment;


public interface CommentsForAdsService {
    Comment save(CreateComment comments);
    Comment get(Long id);
    void delete(Long id);
    Comment update(Long adId, Long commentsId, Comment comment);
}
