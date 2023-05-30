package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.service.AdsService;

import java.util.Collection;

@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:3000")
public class AdsController {

    private final AdsService adsService;

    @GetMapping
    public ResponseEntity<ResponseWrapperAds> getAllAds() {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<FullAds> saveNewAd(@RequestPart("properties") CreateAds ads,
                                             @RequestPart("image") MultipartFile image) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<FullAds> findAdsById(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteAds(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @PatchMapping("{id}")
    public ResponseEntity<FullAds> updateAds(@PathVariable Long id, @RequestBody CreateAds createAds) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("me")
    public ResponseEntity<Collection<FullAds>> getInfoForAds() {
        return ResponseEntity.ok().build();
    }

    @PatchMapping(value = "/{id}/image")
    public ResponseEntity<?> updateAvatar(@PathVariable Long id, @RequestPart("image") MultipartFile image) {
        // Обновление аватарки
        return ResponseEntity.ok().build();
    }

}
