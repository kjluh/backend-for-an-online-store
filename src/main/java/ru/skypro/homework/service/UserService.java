package ru.skypro.homework.service;

import ru.skypro.homework.dto.User;

import java.util.Collection;

public interface UserService {

    Collection<User> findAll();
    User save(User user);
    User findById(Long id);
    User findByName(String name);
    void deleteById(Long id);

}
