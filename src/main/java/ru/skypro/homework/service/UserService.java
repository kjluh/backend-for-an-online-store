package ru.skypro.homework.service;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.User;
import ru.skypro.homework.repositories.UserRepository;

@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser() {
        return new User(); // Временное решение пока не реализована "авторизация"
    }

    public User updateUser(int id, String email, String firstName, String lastName, String phone, String avatarUser) {
        User temp = new User(); // Временное решение пока не реализована "авторизация"

        temp.setId(id);
        temp.setEmail(email);
        temp.setFirstName(firstName);
        temp.setLastName(lastName);
        temp.setPhone(phone);
        temp.setImage(avatarUser);

        return temp;
    }

//    public void updatePassword(String curPass, String newPass) {
//        User temp = new User(); // Временное решение пока не реализована "авторизация"
//
//        if(curPass.equals(temp.getPassword())){
//            temp.setPassword(newPass);
//        }
//    }

//    public String updateAvatar(String avatarUser) {
//        User temp = new User(); // Временное решение пока не реализована "авторизация"
//
//        temp.setImage(avatarUser);
//
//        return avatarUser;
//    }
}
