package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.Comment;
import ru.skypro.homework.service.CommentsForAdsService;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentsForAdsController {

    private final CommentsForAdsService commentsForAdsService;

    @GetMapping("{id}")
    public ResponseEntity<Comment> getCom(@PathVariable Long id){
       return ResponseEntity.ok(commentsForAdsService.get(id));
    }

    @PostMapping()
    public ResponseEntity<Comment> saveCom(@RequestBody Comment comment){
        return ResponseEntity.ok(commentsForAdsService.save(comment));
    }

    @PutMapping("{id}")
    public ResponseEntity<Comment> updateCom(@RequestBody Comment comments){
        return ResponseEntity.ok(commentsForAdsService.save(comments));
    }
    @DeleteMapping("{id}")
    public void deleteCom(@PathVariable Long id){
        commentsForAdsService.delete(id);
    }
}
