package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.homework.entities.CommentsForAds;
import ru.skypro.homework.repositories.CommentsForAdsRepository;
import ru.skypro.homework.service.CommentsForAdsService;
@Service
@RequiredArgsConstructor
public class CommentsForAdsServiceImpl implements CommentsForAdsService {

    private final CommentsForAdsRepository commentsForAdsRepository;
    @Override
    public CommentsForAds save(CommentsForAds comments) {
       return commentsForAdsRepository.save(comments);
    }

    @Override
    public CommentsForAds get(Long id) {
        return commentsForAdsRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        commentsForAdsRepository.deleteById(id);
    }
}
