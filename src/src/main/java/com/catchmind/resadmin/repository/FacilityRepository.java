package com.catchmind.resadmin.repository;

import com.catchmind.resadmin.model.entity.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FacilityRepository extends JpaRepository<Facility,Long> {
    Optional<Facility> findByResaBisName(String resaBisName);
}
