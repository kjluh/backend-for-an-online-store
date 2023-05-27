package ru.skypro.homework.service;

import ru.skypro.homework.dto.FullAds;

import java.util.Collection;

public interface AdsService {
    Collection<FullAds> findAll();
    FullAds save(FullAds infoForAds);
    FullAds findById(Long id);
    FullAds findByName(String name);
    void delete(Long id);
}
