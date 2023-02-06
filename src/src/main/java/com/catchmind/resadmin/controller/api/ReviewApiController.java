package com.catchmind.resadmin.controller.api;

import com.catchmind.resadmin.controller.CrudController;
import com.catchmind.resadmin.model.entity.Review;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.request.ReviewApiRequest;
import com.catchmind.resadmin.model.network.response.ReviewApiResponse;
import com.catchmind.resadmin.service.ReviewApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/reviewLookUp")    // http://localhost:8888/api/reviewLookUp
@RequiredArgsConstructor
public class ReviewApiController extends CrudController<ReviewApiRequest, ReviewApiResponse, Review> {

    private final ReviewApiLogicService reviewApiLogicService;

    @Override
    @PostMapping("")
    public Header<ReviewApiResponse> create(@RequestBody Header<ReviewApiRequest> request) {
        System.out.println("---------------");
        System.out.println(request);
        System.out.println("---------------");
        return reviewApiLogicService.create(request);
    }

//    @PostMapping("login") // http://localhost:8888/api/admin/login
//    public Header<BistroApiResponse> login(@RequestBody Header<BistroApiRequest> request) {
//        return bistroApiLogicService.login(request);
//    }

    @Override
    public Header<ReviewApiResponse> read(Long id) {
        return super.read(id);
    }

    @Override
    @PutMapping("")
    public Header<ReviewApiResponse> update(@RequestBody Header<ReviewApiRequest> request) {
        return reviewApiLogicService.update(request);
    }



    @GetMapping("") // http://localhost:8888/api/reviewLookUp?page=1
    public Header<List<ReviewApiResponse>> findAll(String resaBisName, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reviewApiLogicService.search(resaBisName);
    }
}
