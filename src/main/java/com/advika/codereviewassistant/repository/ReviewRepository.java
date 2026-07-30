package com.advika.codereviewassistant.repository;

import com.advika.codereviewassistant.entity.Review;
import com.advika.codereviewassistant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByUser(User user);

}