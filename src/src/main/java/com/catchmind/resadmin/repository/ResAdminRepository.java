package com.catchmind.resadmin.repository;

import com.catchmind.resadmin.model.entity.ResAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResAdminRepository extends JpaRepository<ResAdmin, Long> {
    Optional<ResAdmin> findByResaUseridAndResaUserpw(String resaUserid, String resaUserpw);
    Optional<ResAdmin> findByResaUserid (String resaUserid);
    Optional<ResAdmin> findByResaUserpw (String resaUserpw);
}
