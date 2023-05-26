package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.CommentsForAds;
import ru.skypro.homework.service.CommentsForAdsService;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentsForAdsController {

    private final CommentsForAdsService commentsForAdsService;

    @GetMapping("{id}")
    public ResponseEntity<CommentsForAds> getCom(@PathVariable Long id){
       return ResponseEntity.ok(commentsForAdsService.get(id));
    }

    @PostMapping()
    public ResponseEntity<CommentsForAds> saveCom(@RequestBody CommentsForAds comments){
        return ResponseEntity.ok(commentsForAdsService.save(comments));
    }

    @PutMapping("{id}")
    public ResponseEntity<CommentsForAds> updateCom(@RequestBody CommentsForAds comments){
        return ResponseEntity.ok(commentsForAdsService.save(comments));
    }
    @DeleteMapping("{id}")
    public void deleteCom(@PathVariable Long id){
        commentsForAdsService.delete(id);
    }
}
