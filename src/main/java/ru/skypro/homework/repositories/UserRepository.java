package ru.skypro.homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
}
