package com.catchmind.resadmin.controller.api;

import com.catchmind.resadmin.controller.CrudController;
import com.catchmind.resadmin.model.entity.totalTable;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.request.CapacityApiRequest;
import com.catchmind.resadmin.model.network.response.CapacityApiResponse;
import com.catchmind.resadmin.service.CapacityApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/capacity")    // http://localhost:8888/api/capacity
@RequiredArgsConstructor
public class CapacityApiController extends CrudController<CapacityApiRequest, CapacityApiResponse, totalTable> {
    private final CapacityApiLogicService capacityApiLogicService;

    @Override
    public Header<CapacityApiResponse> create(Header<CapacityApiRequest> request) {
        return super.create(request);
    }

    @Override
    public Header<CapacityApiResponse> read(Long id) {
        return super.read(id);
    }

    @Override
    public Header<CapacityApiResponse> update(Header<CapacityApiRequest> request) {
        return super.update(request);
    }

    @Override
    public Header<CapacityApiResponse> delete(Long id) {
        return super.delete(id);
    }

    @GetMapping("/update")
    public Header<CapacityApiResponse> update12(String resaBisName,HttpServletRequest request,@RequestParam("totCapacity") String totCapacity,@RequestParam("totTable") String totTable){
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return capacityApiLogicService.update11(resaBisName,totCapacity,totTable);
    }
}
