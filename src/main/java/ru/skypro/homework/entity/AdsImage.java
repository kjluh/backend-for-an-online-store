package ru.skypro.homework.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Data
@Getter
@Entity
public class AdsImage {
    @Id
    @GeneratedValue
    private int id;

    private byte[] data;
    private long fileSize;
    private String filePath;
    private String contentType;

    @ManyToOne
    private AdsEntity ads;
}
