package ru.skypro.homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.dto.Comment;

public interface CommentsForAdsRepository extends JpaRepository<Comment,Long> {
}
