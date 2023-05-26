package ru.skypro.homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.dto.AvatarAds;

public interface AvatarAdsRepository extends JpaRepository<AvatarAds,Long> {
}
