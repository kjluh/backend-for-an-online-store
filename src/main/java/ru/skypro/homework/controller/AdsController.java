package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.InfoForAds;
import ru.skypro.homework.dto.RegisterReq;
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
    public ResponseEntity<InfoForAds> saveNewAds(@RequestParam String name) {
        return ResponseEntity.ok(adsService.save(name));
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
    public ResponseEntity<InfoForAds> updateAds(@RequestBody InfoForAds ads){
        adsService.save(ads.getUser().getFirstName());
        return ResponseEntity.ok(ads);
    }

    @GetMapping("find_by_name")
    public ResponseEntity<Collection<InfoForAds>> getInfoForAds(@RequestParam String name){
        InfoForAds infoForAds = adsService.findByName(name);
        RegisterReq req = infoForAds.getUser();
        Collection<InfoForAds> infoForAdsCollection = req.getInfoForAds();
        return ResponseEntity.ok(infoForAdsCollection);
    }

    @PostMapping(value = "ava/{id}",  consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void setAvatar(@PathVariable Long id, @RequestParam MultipartFile avatar){

    }

}
