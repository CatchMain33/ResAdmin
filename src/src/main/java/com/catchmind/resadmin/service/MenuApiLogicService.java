package com.catchmind.resadmin.service;


import com.catchmind.resadmin.model.entity.Menu;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.Pagination;
import com.catchmind.resadmin.model.network.request.MenuApiRequest;
import com.catchmind.resadmin.model.network.response.MenuApiResponse;
import com.catchmind.resadmin.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuApiLogicService extends BaseService<MenuApiRequest, MenuApiResponse, Menu>{

    private final MenuRepository menuRepository;


    private MenuApiResponse response(Menu menu){
        MenuApiResponse menuApiResponse = MenuApiResponse.builder()
                .meIdx(menu.getMeIdx())
                .resaBisName(menu.getResaBisName())
                .meName(menu.getMeName())
                .meContent(menu.getMeContent())
                .mePrice(menu.getMePrice())
                .regDate(menu.getRegDate())
                .updateDate(menu.getUpdateDate())
                .build();
        return menuApiResponse;
    }

    @Override
    public Header<MenuApiResponse> create(Header<MenuApiRequest> request) {
        MenuApiRequest menuApiRequest = request.getData();
        System.out.println(menuApiRequest);
        Menu menu = Menu.builder()
                .resaBisName(menuApiRequest.getResaBisName())
                .meName(menuApiRequest.getMeName())
                .meContent(menuApiRequest.getMeContent())
                .mePrice(menuApiRequest.getMePrice())
                .build();
        Menu newMenu = baseRepository.save(menu);
        return Header.OK(response(newMenu));
    }

    @Override
    public Header<MenuApiResponse> read(Long meIdx) {
        return baseRepository.findById(meIdx).map(menu -> response(menu))
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
    public Header<MenuApiResponse> update(Header<MenuApiRequest> request) {
        MenuApiRequest menuApiRequest = request.getData();
        Optional<Menu> menu = menuRepository.findByMeName(menuApiRequest.getMeName());
        System.out.println(menu);
        return menu.map(
                        user->{
                            user.setMeName(menuApiRequest.getMeName());
                            user.setMeContent(menuApiRequest.getMeContent());
                            user.setMePrice(menuApiRequest.getMePrice());
                            return user;
                        }).map(user-> baseRepository.save(user))
                .map(user->response(user))
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음")
                );
    }


    public Header delete(Long meIdx) {
        Optional<Menu> menu = baseRepository.findById(meIdx);
        return menu.map(user->{
            baseRepository.delete(user);
            return Header.Ok();
        }).orElseGet(()->Header.ERROR("에러!"));
    }

    public Header<List<MenuApiResponse>> search(String resaBisName){
        List<Menu> menu = menuRepository.findAllByResaBisName(resaBisName);
        List<MenuApiResponse> menuApiResponses =menu.stream().map(
                user -> response(user)).collect(Collectors.toList());
        return Header.OK(menuApiResponses);
    }
}