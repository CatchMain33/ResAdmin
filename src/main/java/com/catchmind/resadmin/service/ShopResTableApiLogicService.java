package com.catchmind.resadmin.service;

import com.catchmind.resadmin.model.entity.Reserve;
import com.catchmind.resadmin.model.entity.ShopResTable;
import com.catchmind.resadmin.model.entity.TotalTable;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.request.ShopResTableApiRequest;
import com.catchmind.resadmin.model.network.response.ReserveApiResponse;
import com.catchmind.resadmin.model.network.response.ShopResTableApiResponse;
import com.catchmind.resadmin.repository.CapacityRepository;
import com.catchmind.resadmin.repository.ShopResTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShopResTableApiLogicService extends BaseService<ShopResTableApiRequest, ShopResTableApiResponse, ShopResTable> {
    private final ShopResTableRepository shopResTableRepository;
    private final CapacityRepository capacityRepository;

    private ShopResTableApiResponse response(ShopResTable shopResTable) {
        ShopResTableApiResponse shopResTableApiResponse = ShopResTableApiResponse.builder()
                .shopResId(shopResTable.getShopResId()).resaBisName(shopResTable.getResaBisName())
                .shopResMonth(shopResTable.getShopResMonth()).shopResDay(shopResTable.getShopResDay())
                .shopResTime(shopResTable.getShopResTime()).shopResStatus(shopResTable.isShopResStatus())
                .build();
        return shopResTableApiResponse;
    }

    @Override
    public Header<ShopResTableApiResponse> create(Header<ShopResTableApiRequest> request) {
        return null;
    }

    @Override
    public Header<ShopResTableApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<ShopResTableApiResponse> update(Header<ShopResTableApiRequest> request) {
        return null;
    }

    @Override
    public Header<ShopResTableApiResponse> delete(Long id) {
        return null;
    }

    public Header<List<ShopResTableApiResponse>> findlist(String resaBisName,String shopResMonth,String shopResDay){
        Optional<TotalTable> totalTable = capacityRepository.findByResaBisName(resaBisName);
        int totTableId = Math.toIntExact(totalTable.get().getTotTableId());
        List<ShopResTable> shopResTables = shopResTableRepository.findAllByTotTableIdAndShopResMonthAndShopResDay(totTableId,shopResMonth,shopResDay);
        List<ShopResTableApiResponse> shopResTableApiResponses = shopResTables.stream().map(user->response(user)).collect(Collectors.toList());
        return Header.OK(shopResTableApiResponses);
    }

    public Header<ShopResTableApiResponse> updatestatus(String resaBisName,String shopResMonth,String shopResDay,String shopResTime,boolean shopResStatus){
        Optional<TotalTable> totalTable = capacityRepository.findByResaBisName(resaBisName);
        int totTableId = Math.toIntExact(totalTable.get().getTotTableId());
        Optional<ShopResTable> shopResTable = shopResTableRepository.findByAndTotTableIdAndShopResMonthAndShopResDayAndAndShopResTime(totTableId,shopResMonth,shopResDay,shopResTime);
        return shopResTable.map(user->{
                    user.setShopResStatus(shopResStatus);
                    return user;
                }).map(user-> baseRepository.save(user))
                .map(user->response(user))
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }


    public boolean createDate(String shopResMonth, String shopResDay, String name) {
        Optional<TotalTable> totalTable = capacityRepository.findByResaBisName(name);
        int totTableId = Math.toIntExact(totalTable.get().getTotTableId());
        int time = 10;
        for(int i = 0; i<6; i++){
            ShopResTable shopResTable = ShopResTable.builder()
                    .shopResMonth(shopResMonth)
                    .shopResDay(shopResDay)
                    .shopResStatus(true)
                    .totTableId(totTableId)
                    .shopResTime(String.valueOf(time))
                    .build();
            ShopResTable newShopResTable = baseRepository.save(shopResTable);
            time += 2;
            if(time == 16){
                time = 17;
            }
        }
        return true;
    }
}
