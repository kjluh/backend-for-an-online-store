package ru.skypro.homework.service;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.Ads;
import ru.skypro.homework.dto.CreateAds;
import ru.skypro.homework.dto.FullAds;
import ru.skypro.homework.repositories.AdsRepository;

@Service
public class AdsService {

    private AdsRepository adsRepository;

    public AdsService(AdsRepository adsRepository) {
        this.adsRepository = adsRepository;
    }


    public FullAds save(Ads ads, String s) {
        return null;
    }

    public FullAds findById(Long id) {
        return null;
    }

    public void delete(Long id) {

    }

    public void updateCover(Long id, String s) {

    }

    public FullAds updateAsd(Long id, CreateAds createAds) {
        return null;
    }
}
