package com.catchmind.resadmin.controller.api;

import com.catchmind.resadmin.controller.CrudController;
import com.catchmind.resadmin.model.entity.BistroInfo;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.request.BistroInfoApiRequest;
import com.catchmind.resadmin.model.network.response.BistroInfoApiResponse;
import com.catchmind.resadmin.service.BistroInfoApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")    // http://localhost:8888/api/admin
@RequiredArgsConstructor
public class BistroInfoApiController extends CrudController<BistroInfoApiRequest, BistroInfoApiResponse, BistroInfo> {

    private final BistroInfoApiLogicService bistroInfoApiLogicService;

    @Override
    public Header<BistroInfoApiResponse> create(@RequestBody Header<BistroInfoApiRequest> request) {
        return bistroInfoApiLogicService.create(request);
    }

//    @PostMapping("login") // http://localhost:8888/api/admin/login
//    public Header<BistroApiResponse> login(@RequestBody Header<BistroApiRequest> request) {
//        return bistroApiLogicService.login(request);
//    }

    @Override
    public Header<BistroInfoApiResponse> read(Long id) {
        return super.read(id);
    }

    @Override
    @PostMapping("")
    public Header<BistroInfoApiResponse> update(@RequestBody Header<BistroInfoApiRequest> request) {
        return bistroInfoApiLogicService.update(request);
    }

    @Override
    public Header<BistroInfoApiResponse> delete(Long id) {
        return super.delete(id);
    }
}
