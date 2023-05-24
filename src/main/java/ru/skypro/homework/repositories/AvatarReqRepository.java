package ru.skypro.homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.dto.AvatarReq;

public interface AvatarReqRepository extends JpaRepository<AvatarReq,Long> {
}
