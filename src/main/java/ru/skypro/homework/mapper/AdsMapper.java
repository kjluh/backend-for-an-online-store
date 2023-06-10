package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.FullAds;
import ru.skypro.homework.entity.AdsEntity;

@Mapper
public interface AdsMapper {
    AdsMapper INSTANCE = Mappers.getMapper(AdsMapper.class);

    @Mapping(source = "id", target = "pk")
    @Mapping(source = "author.getFirstName()", target = "authorFirstName")
    @Mapping(source = "author.getLastName()", target = "authorLastName")
    @Mapping(source = "author.getEmail()", target = "email")
    @Mapping(source = "author.getPhone()", target = "phone")
    FullAds AdsEntityToFullAds();

    AdsEntity CreateAdsToAdsEntity();
}
