package com.catchmind.resadmin.controller.api;

import com.catchmind.resadmin.controller.CrudController;
import com.catchmind.resadmin.model.entity.Profile;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.request.ProfileApiRequest;
import com.catchmind.resadmin.model.network.response.ProfileApiResponse;
import com.catchmind.resadmin.service.ProfileApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profile")    // http://localhost:8888/api/profile
@RequiredArgsConstructor
public class ProfileApiController extends CrudController<ProfileApiRequest, ProfileApiResponse, Profile> {
    private final ProfileApiLogicService profileApiLogicService;

    @Override
    public Header<ProfileApiResponse> create(Header<ProfileApiRequest> request) {
        return super.create(request);
    }

    @Override
    public Header<ProfileApiResponse> read(Long id) {
        return super.read(id);
    }

    @Override
    public Header<ProfileApiResponse> update(Header<ProfileApiRequest> request) {
        return super.update(request);
    }

    @Override
    public Header<ProfileApiResponse> delete(Long id) {
        return super.delete(id);
    }

    @GetMapping("/noshow")
    public Header<ProfileApiResponse> plusNoshow(@RequestParam("prName") String prName){
        return profileApiLogicService.updateNoshow(prName);
    }
}
