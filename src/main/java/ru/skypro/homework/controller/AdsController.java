package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.FullAds;
import ru.skypro.homework.dto.User;
import ru.skypro.homework.service.AdsService;

import java.util.Collection;

@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
public class AdsController {

    private final AdsService adsService;

    @GetMapping
    public ResponseEntity<Collection<FullAds>> getAllAds() {
        return ResponseEntity.ok(adsService.findAll());
    }

    @PostMapping
    public ResponseEntity<FullAds> saveNewAds(@RequestParam FullAds infoForAds) {
        return ResponseEntity.ok(adsService.save(infoForAds));
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

    @PutMapping("{id}")
    public ResponseEntity<FullAds> updateAds(@PathVariable Long id){
        return ResponseEntity.ok(new FullAds());
    }

    @GetMapping("find_by_name")
    public ResponseEntity<Collection<FullAds>> getInfoForAds(@RequestParam String name){
        return null;
    }

    @PostMapping(value = "ava/{id}",  consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void setAvatar(@PathVariable Long id, @RequestParam MultipartFile avatar){

    }

}
