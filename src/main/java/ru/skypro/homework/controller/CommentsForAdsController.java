package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.Comment;
import ru.skypro.homework.dto.CreateComment;
import ru.skypro.homework.service.CommentsForAdsService;

@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
public class CommentsForAdsController {

    private final CommentsForAdsService commentsForAdsService;

    @GetMapping("{id}/comments")
    public ResponseEntity<Comment> getCom(@PathVariable Long id) {
        return ResponseEntity.ok(commentsForAdsService.get(id));
    }

    @PostMapping("{id}/comments")
    public ResponseEntity<Comment> saveCom(@PathVariable Long id, @RequestParam CreateComment createComment) {
        return ResponseEntity.ok(commentsForAdsService.save(id, createComment));
    }

    @DeleteMapping("{adId}/comments/{commentsId}")
    public void deleteCom(@PathVariable Long adId, @PathVariable Long commentsId) {
        commentsForAdsService.delete(adId, commentsId);
    }

    @PatchMapping("{adId}/comments/{commentsId}")
    public ResponseEntity<Comment> updateCom(@PathVariable Long adId, @PathVariable Long commentsId, @RequestBody Comment comment) {
        return ResponseEntity.ok(commentsForAdsService.update(adId, commentsId ,comment));
    }
}
