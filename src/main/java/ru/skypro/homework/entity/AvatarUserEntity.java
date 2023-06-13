package ru.skypro.homework.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AvatarUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String filePath;
    private long fileSize;
    private String mediaType;
    @Lob
    private byte[] data;

    @OneToOne(mappedBy = "avatarUserEntity")
    private UserEntity userEntity;
}
