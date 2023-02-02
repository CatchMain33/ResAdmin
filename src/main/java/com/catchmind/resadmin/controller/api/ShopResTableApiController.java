package com.catchmind.resadmin.controller.api;

import com.catchmind.resadmin.controller.CrudController;
import com.catchmind.resadmin.model.entity.ShopResTable;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.request.ShopResTableApiRequest;
import com.catchmind.resadmin.model.network.response.ShopResTableApiResponse;
import com.catchmind.resadmin.service.ShopResTableApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/status")    // http://localhost:8888/api/reviewLookUp
@RequiredArgsConstructor
public class ShopResTableApiController extends CrudController<ShopResTableApiRequest, ShopResTableApiResponse, ShopResTable> {
    private final ShopResTableApiLogicService shopResTableApiLogicService;

    @Override
    public Header<ShopResTableApiResponse> create(Header<ShopResTableApiRequest> request) {
        return super.create(request);
    }

    @Override
    public Header<ShopResTableApiResponse> read(Long id) {
        return super.read(id);
    }

    @Override
    public Header<ShopResTableApiResponse> update(Header<ShopResTableApiRequest> request) {
        return super.update(request);
    }

    @Override
    public Header<ShopResTableApiResponse> delete(Long id) {
        return super.delete(id);
    }

    @GetMapping("/findstatus")
    public Header<List<ShopResTableApiResponse>> findsall(@RequestParam("shopResMonth") String shopResMonth, @RequestParam("shopResDay") String shopResDay, HttpServletRequest request){
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        String resaBisName = name;
        Header<List<ShopResTableApiResponse>> list = shopResTableApiLogicService.findlist(resaBisName,shopResMonth,shopResDay);
        System.out.println(list);
        return list;
    }

    @GetMapping("/updatestatus")
    public Header<ShopResTableApiResponse> updatestatus(@RequestParam("shopResMonth") String shopResMonth, @RequestParam("shopResDay") String shopResDay, @RequestParam("shopResTime") String shopResTime, @RequestParam("shopResStatus") boolean shopResStatus, HttpServletRequest request){
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        String resaBisName = name;
        return shopResTableApiLogicService.updatestatus(resaBisName,shopResMonth,shopResDay,shopResTime,shopResStatus);
    }
}
