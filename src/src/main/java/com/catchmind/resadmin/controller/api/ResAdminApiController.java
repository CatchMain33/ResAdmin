package com.catchmind.resadmin.controller.api;


import com.catchmind.resadmin.controller.CrudController;
import com.catchmind.resadmin.model.entity.ResAdmin;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.request.ResAdminApiRequest;
import com.catchmind.resadmin.model.network.response.ResAdminApiResponse;
import com.catchmind.resadmin.service.ResAdminApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")    // http://localhost:8888/api/
@RequiredArgsConstructor
public class ResAdminApiController extends CrudController<ResAdminApiRequest, ResAdminApiResponse, ResAdmin> {

    private final ResAdminApiLogicService resAdminApiLogicService;

    @Override
    @PostMapping("")
    public Header<ResAdminApiResponse> create(@RequestBody Header<ResAdminApiRequest> request) {
        return resAdminApiLogicService.create(request);
    }
    @Override
    public Header<ResAdminApiResponse> read(Long id) {
        return super.read(id);
    }

    @Override
    @PutMapping("/re_password")
    public Header<ResAdminApiResponse> update(@RequestBody Header<ResAdminApiRequest> request) {
        System.out.println(request.getData());
        return resAdminApiLogicService.update(request);
    }

    @PostMapping("/pw")
    public Header<ResAdminApiResponse> updatePw(@RequestBody Header<ResAdminApiRequest> request) {
        return resAdminApiLogicService.updatepw(request);
    }

    @Override
    public Header<ResAdminApiResponse> delete(Long id) {
        return super.delete(id);
    }

    @PostMapping("/login")
    public Header<ResAdminApiResponse> login(@RequestBody Header<ResAdminApiRequest> request){
        return resAdminApiLogicService.login(request);
    }



}
