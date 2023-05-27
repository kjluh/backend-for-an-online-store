package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.entities.AvatarUser;
import ru.skypro.homework.service.UserService;
import ru.skypro.homework.entities.User;

import java.util.Collection;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/set_password")
    public ResponseEntity updatePassword(String curPass, String newPass) {
       userService.updatePassword(curPass, newPass);

       return ResponseEntity.ok().build();
    }

    @GetMapping("/me")
    public ResponseEntity<User> getUser() {
        return ResponseEntity.ok(userService.getUser());
    }

    @PatchMapping("/me")
    public ResponseEntity<User> updateUser(Long id, String email, String firstName, String lastName, int phone, AvatarUser avatarUser) {
        return ResponseEntity.ok(userService.updateUser(id, email, firstName, lastName, phone, avatarUser));
    }

    @PatchMapping("/me/image")
    public ResponseEntity<AvatarUser> updateAvatar(AvatarUser avatarUser) {
        return ResponseEntity.ok(userService.updateAvatar(avatarUser));
    }




}
