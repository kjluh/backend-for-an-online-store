package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.Ads;
import ru.skypro.homework.dto.CreateAds;
import ru.skypro.homework.dto.FullAds;

import java.util.Collection;

public interface AdsService {
    FullAds save(Ads ads, String s);
    FullAds findById(Long id);
    void delete(Long id);
    void updateCover(Long id, String s);
    FullAds updateAsd(Long id, CreateAds createAds);
}
