package ru.skypro.homework.service;

import ru.skypro.homework.dto.InfoForAds;

import java.util.Collection;

public interface AdsService {
    Collection<InfoForAds> findAll();
    InfoForAds save(String name);
    InfoForAds findById(Long id);
    InfoForAds findByName(String name);
    InfoForAds delete(Long id);
}
