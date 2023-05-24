package ru.skypro.homework.dto;
import lombok.Data;
import javax.persistence.*;

/**
 * Комментарий к объявлению
 */
@Entity
@Data
public class Comments {
    /**
     * ID комментария
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Текст комментария
     */
    private String text;
    /**
     * Объявление к которому относится комментарий
     */
    @ManyToOne
    private InfoForAds infoForAds;
}
