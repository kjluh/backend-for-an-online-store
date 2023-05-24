package ru.skypro.homework.dto;

import lombok.Data;

import javax.persistence.*;

/**
 * Аватарка пользователя
 */
@Entity
@Data
public class AvatarReq {
    /**
     * ID аватарки
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
    private RegisterReq req;
}
