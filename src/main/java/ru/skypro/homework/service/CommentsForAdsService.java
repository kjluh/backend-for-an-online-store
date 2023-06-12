package ru.skypro.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.CreateComment;
import ru.skypro.homework.entity.Comment;
import ru.skypro.homework.repositories.AdsRepository;
import ru.skypro.homework.repositories.CommentsForAdsRepository;

@Service

public class CommentsForAdsService {

//    @Autowired
//    private CommentsForAdsRepository commentsForAdsRepository;
//    @Autowired
//    private AdsRepository adsRepository;
//
//    public Comment save(CreateComment comment) {
//
//       return null;//commentsForAdsRepository.save(comment); //Временное решение, нужно сохранять уже нашу сущность, не ДТО
//    }
//
//    public Comment get(Integer id) {
//        return commentsForAdsRepository.findById(id).orElse(null);
//    }
//
//    public void delete(Integer id) {
//        commentsForAdsRepository.deleteById(id);
//    }
//
//    public Comment update(Long adId, Long commentsId, Comment comment) {
//        return null;
//    }
}
