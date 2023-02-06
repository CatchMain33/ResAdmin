package com.catchmind.resadmin.service;

import com.catchmind.resadmin.model.entity.Menu;
import com.catchmind.resadmin.model.entity.ResAdmin;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.request.MenuApiRequest;
import com.catchmind.resadmin.model.network.request.ResAdminApiRequest;
import com.catchmind.resadmin.model.network.response.ResAdminApiResponse;
import com.catchmind.resadmin.repository.ResAdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResAdminApiLogicService extends BaseService<ResAdminApiRequest, ResAdminApiResponse, ResAdmin> {

    private final ResAdminRepository resAdminRepository;

    private ResAdminApiResponse response(ResAdmin resAdmin){
        ResAdminApiResponse resAdminApiResponse = ResAdminApiResponse.builder()
                .resaUserid(resAdmin.getResaUserid())
                .resaUserpw(resAdmin.getResaUserpw())
                .resaName(resAdmin.getResaName())
                .resaHp(resAdmin.getResaHp())
                .resaRegion(resAdmin.getResaRegion())
                .resaBisName(resAdmin.getResaBisName())
                .regDate(resAdmin.getRegDate())
                .build();
        return resAdminApiResponse;
    }


    @Override
    public Header<ResAdminApiResponse> create(Header<ResAdminApiRequest> request) {
//        ResAdminApiRequest resAdminApiRequest = request.getData();
//
//        ResAdmin resAdmin = ResAdmin.builder().meUserid(adminUserApiRequest.getMeUserid())
//                .meUserpw(adminUserApiRequest.getMeUserpw())
//                .meName(adminUserApiRequest.getMeName())
//                .meHp(adminUserApiRequest.getMeHp())
//                .meName(adminUserApiRequest.getMeName())
//                .meEmail(adminUserApiRequest.getMeEmail())
//                .mePosition(adminUserApiRequest.getMePosition())
//                .build();
//        AdminUser newUsers = baseRepository.save(users);
//        return Header.OK(response(newUsers));
        return null;
    }

    @Override
    public Header<ResAdminApiResponse> read(Long id) {
        return null;
    }

    public Header<ResAdminApiResponse> read(String resaUserid, String resaUserpw) {
        return resAdminRepository.findByResaUseridAndResaUserpw(resaUserid, resaUserpw).map(
                        users -> response(users)).map(Header::OK)
                .orElseGet(()->Header.ERROR("아이디또는 비번이 틀림")
                );
    }

    @Override
    public Header<ResAdminApiResponse> update(Header<ResAdminApiRequest> request) {
        ResAdminApiRequest resAdminApiRequest = request.getData();
        Optional<ResAdmin> resAdmin = resAdminRepository.findByResaUserid(resAdminApiRequest.getResaUserid());
        System.out.println(resAdmin);
        return resAdmin.map(
                        user->{
                            user.setResaUserpw(resAdminApiRequest.getResaUserpw());
                            return user;
                        }).map(user-> baseRepository.save(user))
                .map(user->response(user))
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음")
                );
    }

    @Override
    public Header<ResAdminApiResponse> delete(Long id) {
        return null;
    }

    public Header<ResAdminApiResponse> login(Header<ResAdminApiRequest> request){
        ResAdminApiRequest resAdminApiRequest = request.getData();

        Optional<ResAdmin> resAdmin = resAdminRepository.findByResaUseridAndResaUserpw(resAdminApiRequest.getResaUserid(),resAdminApiRequest.getResaUserpw());
        if(!resAdmin.isEmpty()){
            return Header.Ok();
        }

        return Header.ERROR("아이디 또는 비밀번호가 틀렸음!");
    }


    public Header<ResAdminApiResponse> updatepw(Header<ResAdminApiRequest> request) {
        ResAdminApiRequest resAdminApiRequest = request.getData();
        Optional<ResAdmin> resAdmin = resAdminRepository.findByResaUserpw(resAdminApiRequest.getResaUserpw());
        System.out.println(resAdmin);
        return resAdmin.map(
                        user->{
                            user.setResaUserpw(resAdminApiRequest.getResaUserpw());
                            return user;
                        }).map(user-> baseRepository.save(user))
                .map(user->response(user))
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음")
                );
    }

}
