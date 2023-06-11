package ru.skypro.homework.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.entity.testADS;

public interface AdsRepository extends JpaRepository<testADS,Long> {
//    FullAds findByUserName(String name);
}
