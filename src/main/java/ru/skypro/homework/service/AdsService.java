package ru.skypro.homework.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.Ads;
import ru.skypro.homework.dto.CreateAds;
import ru.skypro.homework.entity.AdsEntity;
import ru.skypro.homework.entity.UserEntity;
import ru.skypro.homework.mapper.AdsMapper;
import ru.skypro.homework.repositories.AdsRepository;

@Service
public class AdsService {

    private AdsRepository adsRepository;
    private UserService userService;

    public AdsService(AdsRepository adsRepository) {
        this.adsRepository = adsRepository;
    }

    public AdsEntity saveNewAd(CreateAds NewAds, MultipartFile image) {
        AdsEntity adsEntity = AdsMapper.INSTANCE.CreateAdsToAdsEntity();
        //UserEntity author = userService.
        return null;
    }

    public AdsEntity findById(Long id) {
        return null;
    }

    public void delete(Long id) {
    }

    public void updateCover(Long id, String s) {
    }

    public AdsEntity updateAsd(Long id, CreateAds createAds) {
        return null;
    }
}
