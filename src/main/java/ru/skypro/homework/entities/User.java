package ru.skypro.homework.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

/**
 * Аватарка объявления
 */
@Entity
@Data
public class User {

    /**
     * ID аватарки объявления
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Логин пользователя
     */
    private String username;

    /**
     * Пароль пользователя
     */
    private String password;

    /**
     * Имя пользователя
     */
    private String name;

    /**
     * Возраст
     */
    private int age;

    /**
     * Аватарка пользователя в массиве байт
     */
    @OneToOne
    private AvatarUser avatarReq;

    /**
     * Объявления пользователя
     */
    @OneToMany()
    private Collection<InfoForAds> infoForAds;


}
