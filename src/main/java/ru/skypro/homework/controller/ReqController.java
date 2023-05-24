package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/userMenu")
public class ReqController {

@PostMapping("u_p")
    public void updatePassword(){
}
}
