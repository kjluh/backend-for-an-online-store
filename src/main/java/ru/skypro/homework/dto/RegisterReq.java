package ru.skypro.homework.dto;
import lombok.Data;
import javax.persistence.*;
import java.util.Collection;

/**
 * Пользователь и его параметры
 */
@Entity
@Data
public class RegisterReq {
    /**
     * ID пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * Роль пользователя
     */
    private Role role;
    /**
     * Объявления пользователя
     */
    @OneToMany()
    private Collection<InfoForAds> infoForAds;
    /**
     * Аватарка пользователя
     */
    @OneToOne
    private AvatarReq avatarReq;

}
