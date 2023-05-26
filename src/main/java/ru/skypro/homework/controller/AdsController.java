package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.entities.InfoForAds;
import ru.skypro.homework.dto.RegisterReq;
import ru.skypro.homework.entities.User;
import ru.skypro.homework.service.AdsService;

import java.util.Collection;

@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
public class AdsController {

    private final AdsService adsService;

    @GetMapping
    public ResponseEntity<Collection<InfoForAds>> getAllAds() {
        return ResponseEntity.ok(adsService.findAll());
    }

    @PostMapping
    public ResponseEntity<InfoForAds> saveNewAds(@RequestParam InfoForAds infoForAds) {
        return ResponseEntity.ok(adsService.save(infoForAds));
    }

    @GetMapping("{id}")
    public ResponseEntity<InfoForAds> findAdsById(@PathVariable Long id) {
        return ResponseEntity.ok(adsService.findById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteAds(@PathVariable Long id) {
        adsService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<InfoForAds> updateAds(@RequestBody InfoForAds infoForAds){
        return ResponseEntity.ok(adsService.save(infoForAds));
    }

    @GetMapping("find_by_name")
    public ResponseEntity<Collection<InfoForAds>> getInfoForAds(@RequestParam String name){
        InfoForAds infoForAds = adsService.findByName(name);
        User user = infoForAds.getUser();
        Collection<InfoForAds> infoForAdsCollection = user.getInfoForAds();
        return ResponseEntity.ok(infoForAdsCollection);
    }

    @PostMapping(value = "ava/{id}",  consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void setAvatar(@PathVariable Long id, @RequestParam MultipartFile avatar){

    }

}
