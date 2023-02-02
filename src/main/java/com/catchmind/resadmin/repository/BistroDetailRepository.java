package com.catchmind.resadmin.repository;


import com.catchmind.resadmin.model.entity.BistroDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BistroDetailRepository extends JpaRepository<BistroDetail, Long> {
    Optional<BistroDetail> findByResaBisName(String resaBisName);
}
