package com.catchmind.resadmin.repository;

import com.catchmind.resadmin.model.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve,Long> {
    List<Reserve> findAllByResaBisName(String resaBisName);

    List<Reserve> findAllByResaBisNameAndResMonthAndResDayAndResTimeAndResStatus(String resaBisName, String resMonth, String resDay, String resTime, String resStatus);

    List<Reserve> findAllByResaBisNameAndResStatusAndResMonthAndResDay(String resaBisName, String resStatus,String resMonth,String resDay);

    List<Reserve> findAllByResaBisNameAndResStatusAndResMonth(String resaBisName, String resStatus,String resMonth);

    Optional<Reserve>  findByResaBisNameAndResMonthAndResDayAndResTimeAndVisitName(String resaBisName, String resMonth, String resDay, String resTime,String visitName);

    Long countReserveByResaBisNameAndResMonthAndResDayAndResStatus(String resaBisName, String resMonth, String resDay,String resStatus);

    Long countReserveByResaBisNameAndResMonthAndResStatus(String resaBisName, String resMonth, String resStatus);
}