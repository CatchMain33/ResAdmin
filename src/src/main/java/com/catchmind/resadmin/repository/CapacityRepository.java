package com.catchmind.resadmin.repository;

import com.catchmind.resadmin.model.entity.totalTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CapacityRepository extends JpaRepository<totalTable,Long> {
    Optional<totalTable> findByResaBisName(String resaBisName);
}
