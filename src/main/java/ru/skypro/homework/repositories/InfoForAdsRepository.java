package ru.skypro.homework.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.dto.FullAds;

public interface InfoForAdsRepository extends JpaRepository<FullAds,Long> {
    FullAds findByUserName(String name);
}
