package ru.skypro.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.Comment;
import ru.skypro.homework.dto.CreateComment;
import ru.skypro.homework.repositories.AdsRepository;
import ru.skypro.homework.repositories.CommentsForAdsRepository;

@Service
@RequiredArgsConstructor
public class CommentsForAdsService {

    private final CommentsForAdsRepository commentsForAdsRepository;
    private final AdsRepository adsRepository;

    public Comment save(CreateComment comment) {

       return null;//commentsForAdsRepository.save(comment); //Временное решение, нужно сохранять уже нашу сущность, не ДТО
    }

    public Comment get(Long id) {
        return commentsForAdsRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        commentsForAdsRepository.deleteById(id);
    }

    public Comment update(Long adId, Long commentsId, Comment comment) {
        return null;
    }
}