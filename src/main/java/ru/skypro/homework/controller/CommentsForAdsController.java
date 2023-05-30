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
@CrossOrigin(value = "http://localhost:3000")
public class CommentsForAdsController {

    private final CommentsForAdsService commentsForAdsService;

    @GetMapping("{id}/comments")
    public ResponseEntity<Comment> getCom(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("{id}/comments")
    public ResponseEntity<Comment> saveCom(@PathVariable Long id, @RequestBody CreateComment createComment) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{adId}/comments/{commentId}")
    public ResponseEntity deleteCom(@PathVariable Long adId, @PathVariable Long commentId) {
        return ResponseEntity.ok().build();
    }

    @PatchMapping("{adId}/comments/{commentId}")
    public ResponseEntity<Comment> updateCom(@PathVariable Long adId, @PathVariable Long commentId, @RequestBody Comment comment) {
        return ResponseEntity.ok().build();
    }
}
