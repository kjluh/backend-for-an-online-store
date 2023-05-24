package ru.skypro.homework.service;

import ru.skypro.homework.entities.Ads;

import java.util.Collection;

public interface AdsService {
    Collection<Ads> findAll();
    Ads save(String name);
    Ads findById(Long id);
    Ads delete(Long id);
}
