package ru.skypro.homework.dto;
import lombok.Data;
import javax.persistence.*;

/**
 * Сущность для хранения объявления
 */
@Entity
@Data
public class InfoForAds {
    /**
     * ID объявления
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Текст объявления
     */
    private String text;
    /**
     * Владелец объявления
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private RegisterReq user;
    /**
     * Аватарка объявления
     */
    @OneToOne
    private AvatarAds avatarAds;
}
