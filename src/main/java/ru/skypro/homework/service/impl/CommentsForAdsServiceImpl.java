package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.Comment;
import ru.skypro.homework.repositories.CommentsForAdsRepository;
import ru.skypro.homework.service.CommentsForAdsService;
@Service
@RequiredArgsConstructor
public class CommentsForAdsServiceImpl implements CommentsForAdsService {

    private final CommentsForAdsRepository commentsForAdsRepository;
    @Override
    public Comment save(Comment comments) {
       return commentsForAdsRepository.save(comments);
    }

    @Override
    public Comment get(Long id) {
        return commentsForAdsRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        commentsForAdsRepository.deleteById(id);
    }
}
