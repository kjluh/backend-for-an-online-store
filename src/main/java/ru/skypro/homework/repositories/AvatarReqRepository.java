package ru.skypro.homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.entities.AvatarUser;

public interface AvatarReqRepository extends JpaRepository<AvatarUser,Long> {
}
