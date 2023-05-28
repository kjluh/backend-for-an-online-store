package ru.skypro.homework.dto;

import lombok.Data;
import ru.skypro.homework.dto.FullAds;

import javax.persistence.*;
import java.util.Collection;

/**
 * Аватарка объявления
 */
@Data
public class User {
    /**
     * ID аватарки объявления
     */
    private int id;
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
     * Ссылка на аватар пользователя
     */
    private String image;
}
