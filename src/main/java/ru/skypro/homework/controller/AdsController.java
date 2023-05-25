package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.entities.Ads;
import ru.skypro.homework.service.AdsService;

import java.util.Collection;

@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
public class AdsController {

    private final AdsService adsService;

    @GetMapping
    public ResponseEntity<Collection<Ads>> getAllAds() {
        return ResponseEntity.ok(adsService.findAll());
    }

    @PostMapping
    public ResponseEntity<Ads> saveNewAds(@RequestParam String name) {
        return ResponseEntity.ok(adsService.save(name));
    }

    @GetMapping("{id}")
    public ResponseEntity<Ads> findAdsById(@PathVariable Long id) {
        return ResponseEntity.ok(adsService.findById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteAds(@PathVariable Long id) {
        adsService.delete(id);
        return ResponseEntity.ok().build();
    }
}
