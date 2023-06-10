package ru.skypro.homework.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Getter
@Data
public class AdsEntity {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private UserEntity author;

    private String title;
    private String description;
    private int price;
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name="ads")
    private AdsImage image;

}
