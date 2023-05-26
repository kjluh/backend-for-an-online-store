package ru.skypro.homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.entities.CommentsForAds;

public interface CommentsForAdsRepository extends JpaRepository<CommentsForAds,Long> {
}
