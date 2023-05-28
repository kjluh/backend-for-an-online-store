package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.service.AdsService;

import java.util.Collection;

@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
public class AdsController {

    private final AdsService adsService;

    @GetMapping
    public ResponseEntity<ResponseWrapperAds> getAllAds() {
        return ResponseEntity.ok(new ResponseWrapperAds());
    }

    @PostMapping
    public ResponseEntity<FullAds> saveNewAds(@RequestParam Ads ads, @RequestParam String avatarPath) {
        return ResponseEntity.ok(adsService.save(ads, avatarPath));
    }

    @GetMapping("{id}")
    public ResponseEntity<FullAds> findAdsById(@PathVariable Long id) {
        return ResponseEntity.ok(adsService.findById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteAds(@PathVariable Long id) {
        adsService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("{id}")
    public ResponseEntity<FullAds> updateAds(@PathVariable Long id, @RequestBody CreateAds createAds) {
        return ResponseEntity.ok(adsService.updateAsd(id, createAds));
    }

    @GetMapping("me")
    public ResponseEntity<Collection<FullAds>> getInfoForAds() {
        return null;
    }

    @PatchMapping(value = "ava/{id}/image")
    public void updateAvatar(@PathVariable Long id, @RequestParam String avatarPath) {
        adsService.updateCover(id, avatarPath);
    }

}
