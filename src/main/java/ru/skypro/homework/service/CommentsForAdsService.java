package ru.skypro.homework.service;

import ru.skypro.homework.entities.CommentsForAds;


public interface CommentsForAdsService {
    CommentsForAds save(CommentsForAds comments);
    CommentsForAds get(Long id);
    void delete(Long id);

}
