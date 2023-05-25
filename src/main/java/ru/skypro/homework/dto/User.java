package ru.skypro.homework.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

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
    @Lob
    private byte[] avatar;


}
