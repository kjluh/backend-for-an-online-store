package ru.skypro.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.skypro.homework.repositories.UserEntityRepository;

@Service
public class UserService {

    @Autowired
    private final UserEntityRepository userEntityRepository;

    public UserService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }
//    @Autowired
//    private final UserMapper userMapper;


}
