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
     * Логин (почта) пользователя
     */
    private String email;

    /**
     * Пароль пользователя
     */
    private String password;

    /**
     * Имя пользователя
     */
    private String firstName;

    /**
     * Фамилия пользователя
     */
    private String lastName;

    /**
     * Телефон
     */
    private int phone;

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone=" + phone +
                ", avatarReq=" + avatarReq +
                '}';
    }
}
