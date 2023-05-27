package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.service.UserService;
import ru.skypro.homework.dto.User;

import java.util.Collection;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<Collection<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping
    public ResponseEntity<User> findUserByName(@RequestBody String name) {
        return ResponseEntity.ok(userService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<User> saveUser(User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
