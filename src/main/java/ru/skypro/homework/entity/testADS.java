package ru.skypro.homework.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class testADS { //Костя удали этот класс, у меня не поднимался проект из-за отсутствия ентити ADS
    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
