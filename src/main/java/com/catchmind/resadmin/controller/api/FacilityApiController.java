package com.catchmind.resadmin.controller.api;

import com.catchmind.resadmin.controller.CrudController;
import com.catchmind.resadmin.model.entity.Facility;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.request.FacilityApiRequest;
import com.catchmind.resadmin.model.network.response.FacilityApiResponse;
import com.catchmind.resadmin.service.FacilityApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/facility")    // http://localhost:9999/api/facility
@RequiredArgsConstructor
public class FacilityApiController extends CrudController<FacilityApiRequest, FacilityApiResponse, Facility> {
    private final FacilityApiLogicService facilityApiLogicService;

    @Override
    public Header<FacilityApiResponse> create(Header<FacilityApiRequest> request) {
        return super.create(request);
    }

    @Override
    public Header<FacilityApiResponse> read(Long id) {
        return super.read(id);
    }

    @Override
    public Header<FacilityApiResponse> update(Header<FacilityApiRequest> request) {
        return super.update(request);
    }

    @Override
    public Header<FacilityApiResponse> delete(Long id) {
        return super.delete(id);
    }
    @GetMapping("/update")
    public Header<FacilityApiResponse> update11(@RequestParam("facParking") boolean facParking,@RequestParam("facValet") boolean facValet,@RequestParam("facCorkage") boolean facCorkage,
                                                @RequestParam("facNokid") boolean facNokid,@RequestParam("facAnimal") boolean facAnimal,@RequestParam("facHandi") boolean facHandi,
                                                HttpServletRequest request){
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        String resaBisName = name;
        return facilityApiLogicService.updatefac(facParking,facValet,facCorkage,facNokid,facAnimal,facHandi,resaBisName);
    }
}
