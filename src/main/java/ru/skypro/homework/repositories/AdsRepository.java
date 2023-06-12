package ru.skypro.homework.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.entity.AdsEntity;

public interface AdsRepository extends JpaRepository<AdsEntity, Integer> {

}
