package com.catchmind.resadmin.service;

import com.catchmind.resadmin.model.entity.totalTable;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.request.CapacityApiRequest;
import com.catchmind.resadmin.model.network.response.CapacityApiResponse;
import com.catchmind.resadmin.repository.CapacityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CapacityApiLogicService extends BaseService<CapacityApiRequest, CapacityApiResponse, totalTable> {
    private final CapacityRepository capacityRepository;

    private CapacityApiResponse response(totalTable capacity){
        CapacityApiResponse capacityApiResponse = CapacityApiResponse.builder()
                .totTableId(capacity.getTotTableId())
                .resaBisName(capacity.getResaBisName())
                .totCapacity(capacity.getTotCapacity())
                .totTable(capacity.getTotTable()).build();
        return capacityApiResponse;
    }

    @Override
    public Header<CapacityApiResponse> create(Header<CapacityApiRequest> request) {
        return null;
    }

    @Override
    public Header<CapacityApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<CapacityApiResponse> update(Header<CapacityApiRequest> request) {
        return null;
    }

    @Override
    public Header<CapacityApiResponse> delete(Long id) {
        return null;
    }

    public Header<CapacityApiResponse> update11(String resaBisName,String totCapacity,String totTable){
        Optional<totalTable> capacity = capacityRepository.findByResaBisName(resaBisName);
        return capacity.map(
                        user->{
                            user.setTotCapacity(totCapacity);
                            user.setTotTable(totTable);
                            return user;
                        }).map(user-> baseRepository.save(user))
                .map(user->response(user))
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음")
        );
    }
}
