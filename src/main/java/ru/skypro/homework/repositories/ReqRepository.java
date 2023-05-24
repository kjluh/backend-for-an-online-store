package ru.skypro.homework.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.dto.RegisterReq;

public interface ReqRepository extends JpaRepository<RegisterReq,Long> {
}
