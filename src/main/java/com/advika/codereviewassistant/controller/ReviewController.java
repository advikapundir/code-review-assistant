package com.advika.codereviewassistant.controller;

import com.advika.codereviewassistant.dto.ReviewRequest;
import com.advika.codereviewassistant.dto.ReviewResponse;
import com.advika.codereviewassistant.entity.Review;
import com.advika.codereviewassistant.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<ReviewResponse> reviewCode(@RequestBody ReviewRequest request) {
        System.out.println(">>> REVIEW API HIT <<<");
        Review review = Review.builder()
                .language(request.getLanguage())
                .sourceCode(request.getSourceCode())
                .build();

        Review savedReview = reviewService.saveReview(review);

        return ResponseEntity.ok(
                new ReviewResponse(savedReview.getAiReview())
        );
    }
}