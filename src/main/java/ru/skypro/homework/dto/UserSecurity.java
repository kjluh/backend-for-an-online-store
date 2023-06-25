package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class UserSecurity {

    private int id;

    private String login;

    private String password;

    private Role role;
}
