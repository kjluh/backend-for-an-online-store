package ru.skypro.homework.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.User;
import ru.skypro.homework.entity.AvatarUserEntity;
import ru.skypro.homework.entity.UserEntity;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repositories.AvatarUserEntityRepository;
import ru.skypro.homework.repositories.UserEntityRepository;
import java.io.*;

@Service
public class UserService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private AvatarUserEntityRepository avatarUserEntityRepository;


    public void updatePassword(NewPassword newPass, String userName) {
       UserEntity userEntity =  userEntityRepository.findByFirstNameContainsIgnoreCase(userName);
       userEntity.setPassword(newPass.getNewPassword());
       userEntityRepository.save(userEntity);
    }

    public User getUser(Authentication authentication) {
        UserEntity userEntity =  userEntityRepository.findByFirstNameContainsIgnoreCase(authentication.getName());
        if (userEntity==null){
            userEntity = new UserEntity();
            userEntity.setUsername(authentication.getName());
            userEntityRepository.save(userEntity);
        }
        return UserMapper.INSTANCE.toDTO(userEntity);
    }

    public User updateUser(User user, String userName) {
        userEntityRepository.save(UserMapper.INSTANCE.toEntity(user));
        UserEntity userEntity =  userEntityRepository.findByFirstNameContainsIgnoreCase(userName);
        return UserMapper.INSTANCE.toDTO(userEntity);
    }

    public void updateAvatar(MultipartFile image, String userName) throws IOException {
        UserEntity userEntity =  userEntityRepository.findByFirstNameContainsIgnoreCase(userName);

        AvatarUserEntity avatar = avatarUserEntityRepository.findById(
                (userEntity.getId())).orElse(new AvatarUserEntity());
        avatar.setUserEntity(userEntity);
        avatar.setFilePath(String.valueOf(userEntity.getId()));
        avatar.setFileSize(image.getSize());
        avatar.setMediaType(image.getContentType());
        avatar.setData(image.getBytes());
        avatarUserEntityRepository.save(avatar);
        userEntity.setAvatarUserEntity(avatar);
        userEntityRepository.save(userEntity);
    }
    public byte[] getURLAvatar(Integer id){
        return avatarUserEntityRepository.findById(id).orElseThrow().getData();
    }
}
