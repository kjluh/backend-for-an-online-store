package ru.skypro.homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.entity.CommentEntity;


public interface CommentRepository extends JpaRepository<CommentEntity,Integer> {
}