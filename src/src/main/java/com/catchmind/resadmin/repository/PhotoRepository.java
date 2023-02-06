package com.catchmind.resadmin.repository;

import com.catchmind.resadmin.model.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    Optional<Photo> findByResaBisName(String resaBisName);
}
