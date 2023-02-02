package com.catchmind.resadmin.repository;

import com.catchmind.resadmin.model.entity.ShopResTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShopResTableRepository extends JpaRepository<ShopResTable,Long> {
    Optional<ShopResTable> findByResaBisNameAndShopResMonthAndShopResDayAndAndShopResTime(String resaBisName,String shopResMonth,String shopResDay,String shopResTime);

    List<ShopResTable> findAllByResaBisNameAndShopResMonthAndShopResDay(String resaBisName, String shopResMonth, String shopResDay);
}
