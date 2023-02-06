package com.catchmind.resadmin.service;


import com.catchmind.resadmin.model.entity.Profile;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.Pagination;
import com.catchmind.resadmin.model.network.request.ProfileApiRequest;
import com.catchmind.resadmin.model.network.response.ProfileApiResponse;
import com.catchmind.resadmin.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileApiLogicService extends BaseService<ProfileApiRequest, ProfileApiResponse, Profile>{

    private final ProfileRepository profileRepository;


    private ProfileApiResponse response(Profile profile){
        ProfileApiResponse profileApiResponse = ProfileApiResponse.builder()
                .prIdx(profile.getPrIdx())
                .prNick(profile.getPrNick())
                .prName(profile.getPrName())
                .prIntro(profile.getPrIntro())
                .prRegion(profile.getPrRegion())
                .prHp(profile.getPrHp())
                .prUserpw(profile.getPrUserpw())
                .prGender(profile.getPrGender())
                .prBirth(profile.getPrBirth())
                .prMemo(profile.getPrMemo())
                .prReview(profile.getPrReview())
                .prNoshow(profile.getPrNoshow())
                .prBlock(profile.isPrBlock())
                .regDate(profile.getRegDate())
                .updateDate(profile.getUpdateDate())
                .build();
        return profileApiResponse;
    }

    @Override
    public Header<ProfileApiResponse> create(Header<ProfileApiRequest> request) {
//        ProfileApiRequest profileApiRequest = request.getData();
//        System.out.println(profileApiRequest);
//        Menu menu = Menu.builder()
//                .resaBisName(profileApiRequest.getResaBisName())
//                .meName(profileApiRequest.getMeName())
//                .meContent(profileApiRequest.getMeContent())
//                .mePrice(profileApiRequest.getMePrice())
//                .build();
//        Menu newMenu = baseRepository.save(menu);
//        return Header.OK(response(newMenu));
        return null;
    }

    @Override
    public Header<ProfileApiResponse> read(Long prIdx) {
        return baseRepository.findById(prIdx).map(profile -> response(profile))
                .map(Header::OK).orElseGet(()->Header.ERROR("데이터 없음"));
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
    public Header<ProfileApiResponse> update(Header<ProfileApiRequest> request) {
//        MenuApiRequest menuApiRequest = request.getData();
//        Optional<Menu> menu = menuRepository.findByMeName(menuApiRequest.getMeName());
//        System.out.println(menu);
//        return menu.map(
//                        user->{
//                            user.setMeName(menuApiRequest.getMeName());
//                            user.setMeContent(menuApiRequest.getMeContent());
//                            user.setMePrice(menuApiRequest.getMePrice());
//                            return user;
//                        }).map(user-> baseRepository.save(user))
//                .map(user->response(user))
//                .map(Header::OK)
//                .orElseGet(()->Header.ERROR("데이터 없음")
//                );
        return null;
    }


    public Header delete(Long meIdx) {
//        Optional<Menu> menu = baseRepository.findById(meIdx);
//        return menu.map(user->{
//            baseRepository.delete(user);
//            return Header.Ok();
//        }).orElseGet(()->Header.ERROR("에러!"));
        return null;
    }

    public Header<List<ProfileApiResponse>> search(Pageable pageable){
        Page<Profile> profile = baseRepository.findAll(pageable);
        List<ProfileApiResponse> profileApiResponses =profile.stream().map(
                user -> response(user)).collect(Collectors.toList());

        Pagination pagination = Pagination.builder()
                .totalPages(profile.getTotalPages())
                .totalElements(profile.getTotalElements())
                .currentPage(profile.getNumber())
                .currentElements(profile.getNumberOfElements())
                .build();
        return Header.OK(profileApiResponses, pagination);
    }

    public Header<ProfileApiResponse> updateNoshow(String prName){
        Optional<Profile> profile = profileRepository.findByPrName(prName);
        return profile.map(
                        user->{
                            user.setPrNoshow(user.getPrNoshow()+1);
                            return user;
                        }).map(user-> baseRepository.save(user))
                .map(user->response(user))
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음")
        );
    }
}