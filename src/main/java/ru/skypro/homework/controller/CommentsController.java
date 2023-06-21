package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.Comment;
import ru.skypro.homework.dto.CreateComment;
import ru.skypro.homework.dto.ResponseWrapperComment;
import ru.skypro.homework.service.CommentService;

@RestController
@RequestMapping("/ads")
@CrossOrigin(value = "http://localhost:3000")
public class CommentsController {

    private final CommentService commentService;

    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("{id}/comments")
    public ResponseEntity<ResponseWrapperComment> getCom(@PathVariable int id, @AuthenticationPrincipal User author) {
        return ResponseEntity.ok(commentService.getAllCommentsByAdsId(id, author));
    }

    @PostMapping("{id}/comments")
    public ResponseEntity<Comment> saveCom(@PathVariable int id, @RequestBody CreateComment text, @AuthenticationPrincipal User author) {
        return ResponseEntity.ok(commentService.createNewAdsComment(id, text, author));
    }

    @DeleteMapping("{adId}/comments/{commentId}")
    public ResponseEntity<?> deleteCom(@PathVariable int adId, @PathVariable int commentId) {
        commentService.deleteCommentByAdsIdAndCommentEntityId(adId, commentId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("{adId}/comments/{commentId}")
    public ResponseEntity<Comment> updateCom(@PathVariable int adId, @PathVariable int commentId, @RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.patchCommentByAdsIdAndCommentEntityId(adId, commentId, comment));
    }
}
