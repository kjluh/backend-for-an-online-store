package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.entities.AvatarUser;
import ru.skypro.homework.entities.User;
import ru.skypro.homework.repositories.UserRepository;
import ru.skypro.homework.service.UserService;

import java.util.Collection;
@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User getUser() {
        return new User(); // Временное решение пока не реализована "авторизация"
    }

    @Override
    public User updateUser(Long id, String email, String firstName, String lastName, int phone, AvatarUser avatarUser) {
        User temp = new User(); // Временное решение пока не реализована "авторизация"

        temp.setId(id);
        temp.setEmail(email);
        temp.setFirstName(firstName);
        temp.setLastName(lastName);
        temp.setPhone(phone);
        temp.setAvatarReq(avatarUser);

        return temp;
    }

    @Override
    public void updatePassword(String curPass, String newPass) {
        User temp = new User(); // Временное решение пока не реализована "авторизация"

        if(curPass.equals(temp.getPassword())){
            temp.setPassword(newPass);
        }
    }

    @Override
    public AvatarUser updateAvatar(AvatarUser avatarUser) {
        User temp = new User(); // Временное решение пока не реализована "авторизация"

        temp.setAvatarReq(avatarUser);

        return avatarUser;
    }
}
