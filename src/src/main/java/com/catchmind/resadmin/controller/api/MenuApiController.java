package com.catchmind.resadmin.controller.api;

import com.catchmind.resadmin.controller.CrudController;
import com.catchmind.resadmin.model.entity.Menu;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.request.MenuApiRequest;
import com.catchmind.resadmin.model.network.response.MenuApiResponse;
import com.catchmind.resadmin.service.MenuApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/menu")    // http://localhost:8888/api/menu
@RequiredArgsConstructor
public class MenuApiController extends CrudController<MenuApiRequest, MenuApiResponse, Menu> {

    private final MenuApiLogicService menuApiLogicService;

    @Override
    @PostMapping("")
    public Header<MenuApiResponse> create(@RequestBody Header<MenuApiRequest> request) {
        System.out.println("---------------");
        System.out.println(request);
        System.out.println("---------------");
        return menuApiLogicService.create(request);
    }

//    @PostMapping("login") // http://localhost:8888/api/admin/login
//    public Header<BistroApiResponse> login(@RequestBody Header<BistroApiRequest> request) {
//        return bistroApiLogicService.login(request);
//    }

    @Override
    public Header<MenuApiResponse> read(Long id) {
        return super.read(id);
    }

    @Override
    @PutMapping("")
    public Header<MenuApiResponse> update(@RequestBody Header<MenuApiRequest> request) {
        return menuApiLogicService.update(request);
    }



    @GetMapping("") // http://localhost:8888/api/menu
    public Header<List<MenuApiResponse>> findAll(String resaBisName, HttpServletRequest request){
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return menuApiLogicService.search(resaBisName);
    }


    @Override
    @DeleteMapping("{meIdx}")
    public Header<MenuApiResponse> delete(@PathVariable Long meIdx) {
        return menuApiLogicService.delete(meIdx);
    }

}
