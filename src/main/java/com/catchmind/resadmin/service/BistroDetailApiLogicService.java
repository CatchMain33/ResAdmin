package com.catchmind.resadmin.service;


import com.catchmind.resadmin.model.entity.BistroDetail;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.request.BistroDetailApiRequest;
import com.catchmind.resadmin.model.network.response.BistroDetailApiResponse;
import com.catchmind.resadmin.repository.BistroDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BistroDetailApiLogicService extends BaseService<BistroDetailApiRequest, BistroDetailApiResponse, BistroDetail>{

    private final BistroDetailRepository bistroDetailRepository;


    private BistroDetailApiResponse response(BistroDetail bistroDetail){
        BistroDetailApiResponse bistroDetailApiResponse = BistroDetailApiResponse.builder()
                .bdIdx(bistroDetail.getBdIdx())
                .bdPark(bistroDetail.getBdPark())
                .bdAddr(bistroDetail.getBdAddr())
                .bdHp(bistroDetail.getBdHp())
                .bdIntro(bistroDetail.getBdIntro())
                .bdCaution(bistroDetail.getBdCaution())
                .bdHour(bistroDetail.getBdHour())
                .bdHoliday(bistroDetail.getBdHoliday())
                .bdHomepage(bistroDetail.getBdHomepage())
                .build();
        return bistroDetailApiResponse;
    }

    @Override
    public Header<BistroDetailApiResponse> create(Header<BistroDetailApiRequest> request) {
        BistroDetailApiRequest bistroDetailApiRequest = request.getData();

        BistroDetail bistroDetail = BistroDetail.builder()
                .bdPark(bistroDetailApiRequest.getBdPark())
                .bdAddr(bistroDetailApiRequest.getBdAddr())
                .bdHp(bistroDetailApiRequest.getBdHp())
                .bdIntro(bistroDetailApiRequest.getBdIntro())
                .bdCaution(bistroDetailApiRequest.getBdCaution())
                .bdHour(bistroDetailApiRequest.getBdHour())
                .bdHoliday(bistroDetailApiRequest.getBdHoliday())
                .bdHomepage(bistroDetailApiRequest.getBdHomepage())
                .build();
        BistroDetail newBistroDetail = baseRepository.save(bistroDetail);
        return Header.OK(response(newBistroDetail));
    }

    @Override
    public Header<BistroDetailApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<BistroDetailApiResponse> update(Header<BistroDetailApiRequest> request) {
        BistroDetailApiRequest bistroDetailApiRequest = request.getData();
        Optional<BistroDetail> bistroDetail = bistroDetailRepository.findByResaBisName(bistroDetailApiRequest.getResaBisName());
        System.out.println(bistroDetailApiRequest.getResaBisName());
        System.out.println(bistroDetail);
        return bistroDetail.map(
                        user->{
                            user.setBdPark(bistroDetailApiRequest.getBdPark());
                            user.setBdAddr(bistroDetailApiRequest.getBdAddr());
                            user.setBdHp(bistroDetailApiRequest.getBdHp());
                            user.setBdIntro(bistroDetailApiRequest.getBdIntro());
                            user.setBdCaution(bistroDetailApiRequest.getBdCaution());
                            user.setBdHour(bistroDetailApiRequest.getBdHour());
                            user.setBdHoliday(bistroDetailApiRequest.getBdHoliday());
                            user.setBdHomepage(bistroDetailApiRequest.getBdHomepage());
                            return user;
                        }).map(user-> baseRepository.save(user))
                .map(user->response(user))
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음")
                );
    }

    public Header<BistroDetailApiResponse> read(String resaBisName) {
        Optional<BistroDetail> bistroDetail = bistroDetailRepository.findByResaBisName(resaBisName);
        return bistroDetail.map(user -> response(user)).map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }


    public Header<BistroDetailApiResponse> delete(Long id) {
       return null;
    }
}