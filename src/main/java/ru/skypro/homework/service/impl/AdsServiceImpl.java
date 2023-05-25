package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.entities.Ads;
import ru.skypro.homework.service.AdsService;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class AdsServiceImpl implements AdsService {
    @Override
    public Collection<Ads> findAll() {
        Collection<Ads> collection = new ArrayList<>();
        collection.add(new Ads("1"));
        collection.add(new Ads("2"));
        collection.add(new Ads("3"));
        return collection;
    }

    @Override
    public Ads save(String name) {
        return new Ads(name);
    }

    @Override
    public Ads findById(Long id) {
        return new Ads("1");
    }

    @Override
    public Ads delete(Long id) {
        return new Ads("1");
    }
}
