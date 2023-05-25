package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.InfoForAds;
import ru.skypro.homework.entities.Ads;
import ru.skypro.homework.repositories.InfoForAdsRepository;
import ru.skypro.homework.service.AdsService;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class AdsServiceImpl implements AdsService {

    private InfoForAdsRepository infoForAdsRepository;

    public AdsServiceImpl(InfoForAdsRepository infoForAdsRepository) {
        this.infoForAdsRepository = infoForAdsRepository;
    }

    @Override
    public Collection<InfoForAds> findAll() {
        return infoForAdsRepository.findAll();
    }

    @Override
    public InfoForAds save(String name) {
        return null;
    }

    @Override
    public InfoForAds findById(Long id) {
        return null;
    }

    @Override
    public InfoForAds findByName(String name) {
        return null;
    }

    @Override
    public InfoForAds delete(Long id) {
        return null;
    }


}
