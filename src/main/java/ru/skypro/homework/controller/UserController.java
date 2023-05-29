package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.User;
import ru.skypro.homework.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    @PostMapping("/set_password")
    public ResponseEntity updatePassword(@RequestBody NewPassword newPass) {
       return ResponseEntity.ok().build();
    }

    @GetMapping("/me")
    public ResponseEntity<User> getUser() {
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/me")
    public ResponseEntity<User> updateUser(User user) {
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/me/image")
    public ResponseEntity updateAvatar(@RequestParam String avatarUser) {
        return ResponseEntity.ok().build();
    }




}
