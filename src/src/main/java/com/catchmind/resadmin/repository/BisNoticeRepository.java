package com.catchmind.resadmin.repository;

import com.catchmind.resadmin.dto.BisNoticeDto;
import com.catchmind.resadmin.model.entity.BisNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BisNoticeRepository extends JpaRepository <BisNotice, Long> {

    List<BisNotice> findAllByResaBisName(String resaBisName);


}
