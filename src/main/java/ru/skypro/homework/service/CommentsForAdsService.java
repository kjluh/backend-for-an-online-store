package ru.skypro.homework.service;

import ru.skypro.homework.dto.Comment;


public interface CommentsForAdsService {
    Comment save(Comment comments);
    Comment get(Long id);
    void delete(Long id);

}
