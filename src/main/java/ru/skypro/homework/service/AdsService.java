package ru.skypro.homework.service;

import ru.skypro.homework.entities.InfoForAds;

import java.util.Collection;

public interface AdsService {
    Collection<InfoForAds> findAll();
    InfoForAds save(InfoForAds infoForAds);
    InfoForAds findById(Long id);
    InfoForAds findByName(String name);
    void delete(Long id);
}
