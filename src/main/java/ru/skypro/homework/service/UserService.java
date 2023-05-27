package ru.skypro.homework.service;

import ru.skypro.homework.entities.AvatarUser;
import ru.skypro.homework.entities.User;

import java.util.Collection;

public interface UserService {

    void updatePassword(String curPass, String newPass);
    User getUser();

    User updateUser(Long id, String email, String firstName, String lastName, int phone, AvatarUser avatarUser);

    AvatarUser updateAvatar(AvatarUser avatarUser);




}
