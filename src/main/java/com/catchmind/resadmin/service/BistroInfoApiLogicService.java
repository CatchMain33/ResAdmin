package com.catchmind.resadmin.service;


import com.catchmind.resadmin.model.entity.BistroInfo;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.request.BistroInfoApiRequest;
import com.catchmind.resadmin.model.network.response.BistroInfoApiResponse;
import com.catchmind.resadmin.repository.BistroInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BistroInfoApiLogicService extends BaseService<BistroInfoApiRequest, BistroInfoApiResponse, BistroInfo>{

    private final BistroInfoRepository bistroInfoRepository;

    private BistroInfoApiResponse response(BistroInfo bistroInfo){
        BistroInfoApiResponse bistroInfoApiResponse = BistroInfoApiResponse.builder()
                .bisIdx(bistroInfo.getBisIdx())
                .resaBisName(bistroInfo.getResaBisName())
                .bisDesc(bistroInfo.getBisDesc())
                .bisCategory(bistroInfo.getBisCategory())
                .bisRegion(bistroInfo.getBisRegion())
                .bisLunch(bistroInfo.getBisLunch())
                .bisDinner(bistroInfo.getBisDinner())
                .regDate(bistroInfo.getRegDate())
                .build();
        return bistroInfoApiResponse;
    }

    @Override
    public Header<BistroInfoApiResponse> create(Header<BistroInfoApiRequest> request) {
        BistroInfoApiRequest bistroInfoApiRequest = request.getData();
        BistroInfo bistroInfo = BistroInfo.builder()
                .resaBisName(bistroInfoApiRequest.getResaBisName())
                .bisDesc(bistroInfoApiRequest.getBisDesc())
                .bisCategory(bistroInfoApiRequest.getBisCategory())
                .bisRegion(bistroInfoApiRequest.getBisRegion())
                .bisLunch(bistroInfoApiRequest.getBisLunch())
                .bisDinner(bistroInfoApiRequest.getBisDinner())
                .build();
        BistroInfo newBistroInfo = baseRepository.save(bistroInfo);
        return Header.OK(response(newBistroInfo));
    }

    @Override
    public Header<BistroInfoApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<BistroInfoApiResponse> update(Header<BistroInfoApiRequest> request) {
        BistroInfoApiRequest bistroInfoApiRequest = request.getData();
        Optional<BistroInfo> bistroInfo = bistroInfoRepository.findByResaBisName(bistroInfoApiRequest.getResaBisName());
        return bistroInfo.map(
                        user->{
                            user.setBisDesc(bistroInfoApiRequest.getBisDesc());
                            user.setBisCategory(bistroInfoApiRequest.getBisCategory());
                            user.setBisRegion(bistroInfoApiRequest.getBisRegion());
                            user.setBisLunch(bistroInfoApiRequest.getBisLunch());
                            user.setBisDinner(bistroInfoApiRequest.getBisDinner());
                            return user;
                        }).map(user-> baseRepository.save(user))
                .map(user->response(user))
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음")
                );
    }

    public Header<BistroInfoApiResponse> updatephoto(Long phIdx,String resaBisName){
        Optional<BistroInfo> bistroInfo = bistroInfoRepository.findByResaBisName(resaBisName);
        return bistroInfo.map(
                user->{
                    user.setPhIdx(phIdx);
                    return user;
                }).map(user-> baseRepository.save(user))
                .map(user->response(user))
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음")
                );
    }


    public Header<BistroInfoApiResponse> delete(Long id) {
       return null;
    }

    public Header<BistroInfoApiResponse> read(String resaBisName) {
        Optional<BistroInfo> bistroInfo = bistroInfoRepository.findByResaBisName(resaBisName);
        return bistroInfo.map(user -> response(user)).map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

}