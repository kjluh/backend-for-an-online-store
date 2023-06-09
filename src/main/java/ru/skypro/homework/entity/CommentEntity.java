package ru.skypro.homework.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data

public class CommentEntity {

    /**
     * Уникальный ID для хранения класса в БД и использования экземпляра в программе
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Данные автора комментария
     */
    private UserEntity user;

    /**
     * Время создания комментария
     */
    private LocalDateTime createTime;

    /**
     * Текст комментария
     */
    private String text;

}
