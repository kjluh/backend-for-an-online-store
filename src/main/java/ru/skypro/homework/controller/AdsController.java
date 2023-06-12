package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entity.UserEntity;
import ru.skypro.homework.service.AdsService;

import java.io.IOException;

@RestController
@RequestMapping("/ads")
@CrossOrigin(value = "http://localhost:3000")
public class AdsController {

    @Autowired
    private AdsService adsService;

    @GetMapping
    public ResponseEntity<ResponseWrapperAds> getAllAds(@AuthenticationPrincipal User authUser) {
        return ResponseEntity.ok(adsService.findAllAds(authUser));
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Ads> saveNewAd(@RequestPart CreateAds properties,
                                         @RequestPart MultipartFile image,
                                         @AuthenticationPrincipal User authUser) {

        return ResponseEntity.ok(adsService.saveNewAd(properties, image, authUser));
    }

    @GetMapping("{id}")
    public ResponseEntity<FullAds> findAdsById(@PathVariable int id) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAds(@PathVariable int id) {
        return ResponseEntity.ok().build();
    }

    @PatchMapping("{id}")
    public ResponseEntity<Ads> updateAds(@PathVariable int id, @RequestBody CreateAds createAds) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("me")
    public ResponseEntity<ResponseWrapperAds> getInfoForAds() {
        return ResponseEntity.ok(new ResponseWrapperAds());
    }

    @PatchMapping(value = "/{id}/image",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateAvatar(@PathVariable int id, @RequestPart MultipartFile image) {
        // Обновление аватарки
        return ResponseEntity.ok().build();
    }

}
