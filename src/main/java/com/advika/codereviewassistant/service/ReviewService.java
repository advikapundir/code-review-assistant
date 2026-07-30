package com.advika.codereviewassistant.service;

import com.advika.codereviewassistant.entity.Review;
import com.advika.codereviewassistant.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final GeminiService geminiService;

    public ReviewService(ReviewRepository reviewRepository,
                         GeminiService geminiService) {

        this.reviewRepository = reviewRepository;
        this.geminiService = geminiService;
    }

    public Review saveReview(Review review) {

        String aiReview = geminiService.reviewCode(review.getSourceCode());

        review.setAiReview(aiReview);
        review.setCreatedAt(LocalDateTime.now());

        return reviewRepository.save(review);
    }
}