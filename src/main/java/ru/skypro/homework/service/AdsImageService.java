package ru.skypro.homework.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.CreateAds;
import ru.skypro.homework.entity.AdsEntity;
import ru.skypro.homework.entity.AdsImage;
import ru.skypro.homework.repositories.AdsImageRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
public class AdsImageService {
    @Value("adsImages")
    private String adsImageDir;

    AdsImageRepository adsImageRepository;

    AdsImageService(AdsImageRepository adsImageRepository) {
        this.adsImageRepository = adsImageRepository;
    }

    public AdsImage save(AdsEntity adsEntity, MultipartFile image) throws IOException {
        Path filePath = Path.of(adsImageDir, adsEntity.getId() + "." + Objects.requireNonNull(image.getOriginalFilename()));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);

        try (
                InputStream is = image.getInputStream();
                OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
                BufferedInputStream bis = new BufferedInputStream(is, 1024);
                BufferedOutputStream bos = new BufferedOutputStream(os, 1024)
        ) {
            bis.transferTo(bos);
        }

        AdsImage adsImage = new AdsImage();
        adsImage.setAds(adsEntity);
        adsImage.setFilePath(filePath.toString());
        adsImage.setFileSize(image.getSize());
        adsImage.setContentType(image.getContentType());
        adsImage.setData(image.getBytes());

        return adsImageRepository.save(adsImage);
    }

    public AdsImage findByAdsId(int adsId) {
        return adsImageRepository.findAdsImagesByAds_Id(adsId);
    }

    private String getExtensions(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}
