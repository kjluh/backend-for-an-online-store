package ru.skypro.homework.entities;
import lombok.Data;
import ru.skypro.homework.entities.InfoForAds;

import javax.persistence.*;

/**
 * Комментарий к объявлению
 */
@Entity
@Data
public class CommentsForAds {
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
