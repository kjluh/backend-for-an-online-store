package ru.skypro.homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.dto.CommentsForAds;

public interface CommentsForAdsRepository extends JpaRepository<CommentsForAds,Long> {
}
