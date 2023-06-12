package ru.skypro.homework.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.Ads;
import ru.skypro.homework.dto.CreateAds;
import ru.skypro.homework.entity.AdsEntity;
import ru.skypro.homework.mapper.AdsMapper;
import ru.skypro.homework.repositories.AdsRepository;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class AdsService {

    private AdsRepository adsRepository;
    private AdsImageService adsImageService;
    private UserService userService;

    public AdsService(AdsRepository adsRepository, AdsImageService adsImageService, UserService userService) {
        this.adsRepository = adsRepository;
        this.adsImageService = adsImageService;
        this.userService = userService;
    }

    public Ads saveNewAd(CreateAds newAds, MultipartFile image, User author) {
        AdsEntity adsEntity = AdsMapper.INSTANCE.CreateAdsToAdsEntity(newAds);
        //раскомментировать когда заработает нормальная авторизация
        //adsEntity.setAuthor(userService.getUserEntity(author.getUsername()));
        adsEntity.setAuthor(userService.getUserEntity("user@gmail.com"));
        adsEntity.setCreatedAt(LocalDateTime.now());
        adsRepository.save(adsEntity);
        try {
            adsImageService.save(adsEntity, image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Ads ads = AdsMapper.INSTANCE.adsEntityToAds(adsEntity, adsEntity.getAuthor());
        ads.setImage(adsImageService.findByAdsId(adsEntity.getId()).getFilePath());
        return ads;
    }

    public AdsEntity findById(int id) {
        return adsRepository.findById(id).get();
    }

    public void delete(Long id) {
    }

    public void updateCover(Long id, String s) {
    }

    public AdsEntity updateAsd(Long id, CreateAds createAds) {
        return null;
    }


}
