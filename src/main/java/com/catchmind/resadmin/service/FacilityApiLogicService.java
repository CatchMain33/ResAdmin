package com.catchmind.resadmin.service;

import com.catchmind.resadmin.model.entity.Facility;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.request.FacilityApiRequest;
import com.catchmind.resadmin.model.network.response.FacilityApiResponse;
import com.catchmind.resadmin.repository.FacilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacilityApiLogicService extends  BaseService<FacilityApiRequest, FacilityApiResponse, Facility> {
    private final FacilityRepository facilityRepository;

    private FacilityApiResponse response(Facility facility){
        FacilityApiResponse facilityApiResponse = FacilityApiResponse.builder()
                .facIdx(facility.getFacIdx()).bisIdx(facility.getBisIdx())
                .resaBisName(facility.getResaBisName()).facParking(facility.isFacParking())
                .facValet(facility.isFacValet()).facCorkage(facility.isFacCorkage())
                .facNokid(facility.isFacNokid()).facAnimal(facility.isFacAnimal())
                .facHandi(facility.isFacHandi()).regDate(facility.getRegDate())
                .build();
        return facilityApiResponse;
    }

    @Override
    public Header<FacilityApiResponse> create(Header<FacilityApiRequest> request) {
        return null;
    }

    @Override
    public Header<FacilityApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<FacilityApiResponse> update(Header<FacilityApiRequest> request) {
        return null;
    }

    @Override
    public Header<FacilityApiResponse> delete(Long id) {
        return null;
    }

    public Header<FacilityApiResponse> find(String resaBisName){
        return facilityRepository.findByResaBisName(resaBisName).map(menu -> response(menu))
                .map(Header::OK).orElseGet(()->Header.ERROR("데이터 없음"));
    }

    public Header<FacilityApiResponse> updatefac(boolean facParking,boolean facValet,boolean facCorkage,
                                                 boolean facNokid,boolean facAnimal,boolean facHandi,String resaBisName){
        Optional<Facility> facility = facilityRepository.findByResaBisName(resaBisName);
        return  facility.map(user->{
                    user.setFacParking(facParking);
                    user.setFacValet(facValet);
                    user.setFacCorkage(facCorkage);
                    user.setFacNokid(facNokid);
                    user.setFacAnimal(facAnimal);
                    user.setFacHandi(facHandi);
                    return user;
                }).map(user-> baseRepository.save(user))
                .map(user->response(user))
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }
}
