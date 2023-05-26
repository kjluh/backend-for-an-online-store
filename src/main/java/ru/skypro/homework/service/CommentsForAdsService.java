package ru.skypro.homework.service;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.CommentsForAds;


public interface CommentsForAdsService {
    CommentsForAds save(CommentsForAds comments);
    CommentsForAds get(Long id);
    void delete(Long id);

}
