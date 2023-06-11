package ru.skypro.homework.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.RegisterReq;
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
       UserEntity userEntity =  userEntityRepository.findByUsername(userName);
       userEntity.setPassword(newPass.getNewPassword());
       userEntityRepository.save(userEntity);
    }

    @Transactional(readOnly = true)
    public User getUser(String userName) {
        UserEntity userEntity =  userEntityRepository.findByUsername(userName);
        User thisUser = UserMapper.INSTANCE.toDTO(userEntity);
//        if (thisUser.getImage()==null && avatarUserEntityRepository.findById(userEntity.getId())!=null){
//            thisUser.setImage("/users/avatar/"+userEntity.getId()+"/db");
//        }
        return thisUser;
    }

    @Transactional
    public User updateUser(User user, String userName) {
        UserEntity userEntity =  userEntityRepository.findByUsername(userName);

        UserMapper.INSTANCE.toEntity(user,userEntity);
        userEntityRepository.save(userEntity);
        return UserMapper.INSTANCE.toDTO(userEntity);
    }

    @Transactional // необходимо писать если вызываем сущность из бд с картинкой в параметрах с анат @lob
    public void updateAvatar(MultipartFile image, String userName) throws IOException {
        UserEntity userEntity =  userEntityRepository.findByUsername(userName);

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
