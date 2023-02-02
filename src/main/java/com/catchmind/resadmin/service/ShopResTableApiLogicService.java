package com.catchmind.resadmin.service;

import com.catchmind.resadmin.model.entity.Reserve;
import com.catchmind.resadmin.model.entity.ShopResTable;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.request.ShopResTableApiRequest;
import com.catchmind.resadmin.model.network.response.ReserveApiResponse;
import com.catchmind.resadmin.model.network.response.ShopResTableApiResponse;
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
        List<ShopResTable> shopResTables = shopResTableRepository.findAllByResaBisNameAndShopResMonthAndShopResDay(resaBisName,shopResMonth,shopResDay);
        List<ShopResTableApiResponse> shopResTableApiResponses = shopResTables.stream().map(user->response(user)).collect(Collectors.toList());
        return Header.OK(shopResTableApiResponses);
    }

    public Header<ShopResTableApiResponse> updatestatus(String resaBisName,String shopResMonth,String shopResDay,String shopResTime,boolean shopResStatus){
        Optional<ShopResTable> shopResTable = shopResTableRepository.findByResaBisNameAndShopResMonthAndShopResDayAndAndShopResTime(resaBisName,shopResMonth,shopResDay,shopResTime);
        return shopResTable.map(user->{
                    user.setShopResStatus(shopResStatus);
                    return user;
                }).map(user-> baseRepository.save(user))
                .map(user->response(user))
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }
}
