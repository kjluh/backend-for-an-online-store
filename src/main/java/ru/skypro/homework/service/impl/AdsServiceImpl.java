package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.FullAds;
import ru.skypro.homework.repositories.InfoForAdsRepository;
import ru.skypro.homework.service.AdsService;

import java.util.Collection;

@Service
public class AdsServiceImpl implements AdsService {

    private InfoForAdsRepository infoForAdsRepository;

    public AdsServiceImpl(InfoForAdsRepository infoForAdsRepository) {
        this.infoForAdsRepository = infoForAdsRepository;
    }

    @Override
    public Collection<FullAds> findAll() {
        return infoForAdsRepository.findAll();
    }

    @Override
    public FullAds save(FullAds infoForAds) {
        return infoForAdsRepository.save(infoForAds);
    }

    @Override
    public FullAds findById(Long id) {
        return infoForAdsRepository.findById(id).orElse(null);
    }

    @Override
    public FullAds findByName(String name) {
        return infoForAdsRepository.findByUserName(name);
    }

    @Override
    public void delete(Long id) {
        infoForAdsRepository.deleteById(id);
    }


}
