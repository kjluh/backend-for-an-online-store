package ru.skypro.homework.entity;

import lombok.Data;
import ru.skypro.homework.dto.Role;
import javax.persistence.*;

@Entity
@Data
public class UserEntity {
    /**
     * Уникальный ID для хранения класса в БД и использования экземпляра в программе
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Роль пользователя
     */
    private Role role;
    /**
     * Логин пользователя
     */
    private String username;
    /**
     * Пароль пользователя
     */
    private String password;
    /**
     * Логин пользователя
     */
    private String email;
    /**
     * Имя пользователя
     */
    private String firstName;
    /**
     * Фамилия пользователя
     */
    private String lastName;
    /**
     * Телефон пользователя
     */
    private String phone;
    /**
     * Аватар пользователя
     */
//    @OneToOne
//    @JoinColumn(name = "avatar_user_entity_id")
//    private AvatarUserEntity avatarUserEntity;
}