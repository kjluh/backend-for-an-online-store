package ru.skypro.homework.entities;

import lombok.Data;
import ru.skypro.homework.entities.InfoForAds;

import javax.persistence.*;

/**
 * Аватарка объявления
 */
@Entity
@Data
public class AvatarAds {
    /**
     * ID аватарки объявления
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * Путь, где лежит аватарка
     */
    private String filePath;
    /**
     * Размер аватарка
     */
    private long fileSize;
    /**
     * Тип аватарка
     */
    private String mediaType;
    /**
     * Аватарка в массиве байт
     */
    @Lob
    private byte[] data;
    /**
     * Объявление к которому аватарка относится
     */
    @OneToOne
    private InfoForAds ads;
}
