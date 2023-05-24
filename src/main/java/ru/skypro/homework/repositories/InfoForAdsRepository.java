package ru.skypro.homework.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.dto.InfoForAds;

public interface InfoForAdsRepository extends JpaRepository<InfoForAds,Long> {
}
