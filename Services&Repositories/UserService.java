package ru.skypro.homework.service;


import ru.skypro.homework.dto.User;

public interface UserService {

//    void updatePassword(String curPass, String newPass);
    User getUser();

    User updateUser(int id, String email, String firstName, String lastName, String phone, String avatarUser);






}
