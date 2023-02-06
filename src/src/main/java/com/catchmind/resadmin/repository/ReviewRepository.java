package com.catchmind.resadmin.repository;


import com.catchmind.resadmin.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByResaBisName(String resaBisName);
}
