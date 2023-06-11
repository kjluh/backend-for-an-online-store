package ru.skypro.homework.service;

import org.springframework.stereotype.Service;
import ru.skypro.homework.repositories.AdsRepository;
import ru.skypro.homework.repositories.CommentRepository;

@Service
public class CommentService {

    private final CommentRepository commentsForAdsRepository;

    private final AdsRepository adsRepository;

    public CommentService(AdsRepository adsRepository, CommentRepository commentsForAdsRepository) {
        this.adsRepository = adsRepository;
        this.commentsForAdsRepository = commentsForAdsRepository;
    }


}


