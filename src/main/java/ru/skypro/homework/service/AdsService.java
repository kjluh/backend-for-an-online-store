package ru.skypro.homework.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.CreateAds;
import ru.skypro.homework.entity.AdsEntity;
import ru.skypro.homework.entity.AdsImage;
import ru.skypro.homework.entity.UserEntity;
import ru.skypro.homework.mapper.AdsMapper;
import ru.skypro.homework.repositories.AdsRepository;

import java.io.IOException;

@Service
public class AdsService {

    private AdsRepository adsRepository;
    private AdsImageService adsImageService;

    public AdsService(AdsRepository adsRepository, AdsImageService adsImageService) {
        this.adsRepository = adsRepository;
        this.adsImageService = adsImageService;
    }

    public AdsEntity saveNewAd(CreateAds newAds, MultipartFile image, UserEntity author) {
        AdsEntity adsEntity = AdsMapper.INSTANCE.CreateAdsToAdsEntity(newAds);
        adsRepository.save(adsEntity);
        try {
            adsImageService.save(adsEntity, image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        adsEntity.setAuthor(author);
        return adsEntity;
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
