package com.catchmind.resadmin.repository;

import com.catchmind.resadmin.model.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
//    Optional<ResAdmin> findByResaUseridAndResaUserpw(String resaUserid, String resaUserpw);
    Optional<Profile> findByPrName(String prName);
}
