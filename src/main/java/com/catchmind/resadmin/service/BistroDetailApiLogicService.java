package com.catchmind.resadmin.service;


import com.catchmind.resadmin.model.entity.BistroDetail;
import com.catchmind.resadmin.model.entity.BistroInfo;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.request.BistroDetailApiRequest;
import com.catchmind.resadmin.model.network.request.BistroInfoApiRequest;
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
                .bdNotice(bistroDetail.getBdNotice())
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
                .bdNotice(bistroDetailApiRequest.getBdNotice())
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


//        public Header<BistroApiResponse> login(Header<BistroApiRequest> request) {
//        BistroApiRequest bistroApiRequest = request.getData();
//
//        Optional<Bistro> adminUser = bistroRepository.findByUseridAndUserpw(bistroApiRequest.getUserid(), bistroApiRequest.getUserpw());
//        if(!adminUser.isEmpty()){
//            return Header.OK();
//        }
//        return Header.ERROR("아이디 또는 비밀번호 확인");
//    }
//    @Override
//    public Header<BistroApiResponse> read(Long id) {
//        return null;
//    }

//    public Header<BistroApiResponse> read(String userid, String userpw) {
//        return adminUserRepository.findByUseridAndUserpw(userid, userpw).map(
//                users-> response(users)).map(Header::OK).orElseGet(() -> Header.ERROR("아이디 또는 비림번호 화긴")
//        );
//    }
    @Override
    public Header<BistroDetailApiResponse> update(Header<BistroDetailApiRequest> request) {
        BistroDetailApiRequest bistroDetailApiRequest = request.getData();
        Optional<BistroDetail> bistroDetail = bistroDetailRepository.findByResaBisName(bistroDetailApiRequest.getResaBisName());
        System.out.println(bistroDetailApiRequest.getResaBisName());
        System.out.println(bistroDetail);
        return bistroDetail.map(
                        user->{
                            user.setBdNotice(bistroDetailApiRequest.getBdNotice());
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


    public Header<BistroDetailApiResponse> delete(Long id) {
       return null;
    }
}