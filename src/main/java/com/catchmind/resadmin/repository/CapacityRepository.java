package com.catchmind.resadmin.repository;

import com.catchmind.resadmin.model.entity.TotalTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CapacityRepository extends JpaRepository<TotalTable,Long> {
    Optional<TotalTable> findByResaBisName(String resaBisName);
}
