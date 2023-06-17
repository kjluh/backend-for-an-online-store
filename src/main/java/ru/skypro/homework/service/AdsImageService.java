package ru.skypro.homework.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.CreateAds;
import ru.skypro.homework.entity.AdsEntity;
import ru.skypro.homework.entity.AdsImage;
import ru.skypro.homework.repositories.AdsImageRepository;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
public class AdsImageService {
    @Value("adsImages")
    private String adsImageDir;

    private final AdsImageRepository adsImageRepository;

    AdsImageService(AdsImageRepository adsImageRepository) {
        this.adsImageRepository = adsImageRepository;
    }

    @Transactional
    public AdsImage save(AdsEntity adsEntity, MultipartFile image) throws IOException {
        Path filePath = Path.of(adsImageDir, Math.random() + "." + Objects.requireNonNull(image.getOriginalFilename()));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);

        AdsImage adsImage = saveToFolder(filePath, image);

        adsImage.setAds(adsEntity);

        return adsImageRepository.save(adsImage);
    }
    @Transactional
    public AdsImage findByAdsId(int adsId) {
        return adsImageRepository.findAdsImagesByAds_Id(adsId);
    }

    @Transactional(readOnly = true)
    public byte[] getAdsImage(int id) throws IOException {
        AdsImage adsImage;
        byte [] data = null;
        if (adsImageRepository.findById(id).isPresent()) {
            adsImage = adsImageRepository.findById(id).get();
        } else {
            adsImage = new AdsImage();
        }
        try {
                InputStream is = Files.newInputStream(Path.of(adsImage.getFilePath()));//открываем поток из файла
                ByteArrayOutputStream os = new ByteArrayOutputStream();//создаем выходной поток
                byte[] buffer = new byte[1024];//устанавливаем размер буфера для потока
                int n = 0;
                while (-1 != (n = is.read(buffer))) { //пока во входящем потоке есть данные
                    os.write(buffer, 0, n); // записываем их в выходной поток
                }
                is.close(); // закрываем поток
                data = os.toByteArray(); // перегоняем байты в переменную
                return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Transactional
    public ArrayList<String> updateCover(int id, MultipartFile image) {
        AdsImage adsImage;
        if (adsImageRepository.findById(id).isEmpty()) {
            adsImage = new AdsImage();
            try {
                Path filePath = Path.of(adsImageDir, Math.random() + "." + Objects.requireNonNull(image.getOriginalFilename()));
                Files.createDirectories(filePath.getParent());
                Files.deleteIfExists(filePath);
                adsImage.setFilePath(filePath.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            adsImage = adsImageRepository.findById(id).get();
        }
        try {
            AdsImage newAdsImage = saveToFolder(Path.of(adsImageDir, Math.random() + "." + Objects.requireNonNull(image.getOriginalFilename())), image);
            //adsImage.setData(newAdsImage.getData());
            adsImage.setContentType(newAdsImage.getContentType());
            adsImage.setFileSize(newAdsImage.getFileSize());
            adsImage.setFilePath(newAdsImage.getFilePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("/ads/image/" + adsImage.getFilePath());
        return stringArrayList;
    }

    @Transactional
    public void deleteByAdsId(int adsId) {
        adsImageRepository.deleteAdsImagesByAds_Id(adsId);
    }

    private AdsImage saveToFolder(Path filePath, MultipartFile image) throws IOException {
        try (
                InputStream is = image.getInputStream();
                OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
                BufferedInputStream bis = new BufferedInputStream(is, 1024);
                BufferedOutputStream bos = new BufferedOutputStream(os, 1024)
        ) {
            bis.transferTo(bos);
        }

        AdsImage adsImage = new AdsImage();
        adsImage.setFilePath(filePath.toString());
        adsImage.setFileSize(image.getSize());
        adsImage.setContentType(image.getContentType());
        //adsImage.setData(image.getBytes());
        return  adsImage;
    }
}
