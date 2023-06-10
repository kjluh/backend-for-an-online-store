package ru.skypro.homework.entity;

import javax.persistence.*;

@Entity
public class AdsImage {
    @Id
    @GeneratedValue
    private int id;

    private byte[] data;
    private long size;
    private String filePath;
    private String mediaType;

    @ManyToOne
    private AdsEntity ads;
}
