package ru.skypro.homework.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.User;
import ru.skypro.homework.entity.AvatarUserEntity;
import ru.skypro.homework.entity.UserEntity;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repositories.AvatarUserEntityRepository;
import ru.skypro.homework.repositories.UserEntityRepository;
import ru.skypro.homework.security.MyUserDetails;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

/**
 * Сервис для работы с пользователями
 */
@Service
public class UserService {

    private final UserEntityRepository userEntityRepository;

    private final AvatarUserEntityRepository avatarUserEntityRepository;

    private final MyUserDetails myUserDetails;

    private final PasswordEncoder encoder;

    @Value("{Avatar.cover.dir.path}")
    private String userAvatarsDir;

    public UserService(UserEntityRepository userEntityRepository, AvatarUserEntityRepository avatarUserEntityRepository, MyUserDetails myUserDetails, PasswordEncoder encoder) {
        this.userEntityRepository = userEntityRepository;
        this.avatarUserEntityRepository = avatarUserEntityRepository;
        this.myUserDetails = myUserDetails;
        this.encoder = encoder;
    }

    /**
     * Обновление пароля
     *
     * @param newPass принимает сущность нового пароля
     * @return возвращает статус по смене 200 - ок, 401 ошибка
     */
    @Transactional
    public boolean updatePassword(NewPassword newPass) {
        UserEntity userEntity = getUserEntity(myUserDetails.getUsername());
        userEntity.setPassword(encoder.encode(newPass.getNewPassword()));
        userEntityRepository.save(userEntity);
        return true;
    }

    /**
     * Возвращает сущность пользователя для отображения на странице
     *
     * @return принимает логин пользователя
     */
    @Transactional(readOnly = true)
    public User getUser() {
        UserEntity userEntity = getUserEntity(myUserDetails.getUsername());
        User thisUser = UserMapper.INSTANCE.toDTO(userEntity);
        if (null == userEntity.getAvatarUserEntity()) {
            return thisUser;
        }
        thisUser.setImage("/users/avatar/" + userEntity.getAvatarUserEntity().getId() + "/db");

        return thisUser;
    }

    /**
     * @param user     принимает сущность пользователя с изменениями для обновления
     * @param userName принимает логин пользователя
     * @return возвращает обновленного пользователя
     */
    @Transactional
    public User updateUser(User user, String userName) {
        UserEntity userEntity = getUserEntity(userName);
        UserMapper.INSTANCE.toEntity(user, userEntity);
        userEntityRepository.save(userEntity);
        return UserMapper.INSTANCE.toDTO(userEntity);
    }

    /**
     * @param image    Мультипад файл картинка новой аватарки
     * @param userName принимает логин пользователя
     * @throws IOException
     */
    @Transactional // необходимо писать если вызываем сущность из бд с картинкой в параметрах с анат @lob
    public void updateAvatar(MultipartFile image, String userName) throws IOException {
        UserEntity userEntity = getUserEntity(userName);

        //сохранение на сервак с именем пользователя
        Path filePath = Path.of(userAvatarsDir, userName + "." + image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf(".") + 1));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);
        try (InputStream is = image.getInputStream();
             OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
             BufferedInputStream bis = new BufferedInputStream(is, 1024);
             BufferedOutputStream bos = new BufferedOutputStream(os, 1024);) {
            bis.transferTo(bos);
        }
        // сохранение авы в бд
        AvatarUserEntity avatar = avatarUserEntityRepository.findById((userEntity.getId())).orElse(new AvatarUserEntity());
        avatar.setUserEntity(userEntity);
        avatar.setMediaType(image.getContentType());
        avatar.setData(image.getBytes());
        avatar.setFilePath(filePath.toString());
        avatarUserEntityRepository.save(avatar);
        userEntity.setAvatarUserEntity(avatar);
        userEntityRepository.save(userEntity);

    }

    @Transactional()
    public UserEntity getUserEntity(String userName) {
        return userEntityRepository.findByUsername(userName);
    }

    public byte[] getURLAvatar(Integer id) throws IOException {

//        Метод для получения авы с сервера
        AvatarUserEntity avatarUser = avatarUserEntityRepository.findById(id).get();
        File file = new File(avatarUser.getFilePath());
        return Files.readAllBytes(file.toPath());

//        Метод для получения авы из бд
//        return avatarUserEntityRepository.findById(id).orElseThrow().getData();
    }
}
