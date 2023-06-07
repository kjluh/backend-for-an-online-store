package ru.skypro.homework.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Comment {

    /**
     * Уникальный ID для хранения класса в БД и использования экземпляра в программе
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk;

    /**
     * Уникальный ID автора комментария
     */
    private int author;

    /**
     * Ссылка на аватар автора комментария
     */
    private String authorImage;

    /**
     * Имя создателя комментария
     */
    private String authorFirstName;

    /**
     * Дата и время создания комментария в миллисекундах с 00:00:00 01.01.1970
     */
    private Long createdAt;

    /**
     * Текст комментария
     */
    private String text;

}
