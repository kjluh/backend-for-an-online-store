package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class RegisterReq {
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
    private String firstName;
    /**
     * Фамилия пользователя
     */
    private String lastName;
    /**
     * Номер телефона пользователя
     */
    private String phone;
    /**
     * Роль пользователя
     */
    private Role role;
}
