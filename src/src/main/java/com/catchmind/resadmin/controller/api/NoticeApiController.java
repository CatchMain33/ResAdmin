package com.catchmind.resadmin.controller.api;

import com.catchmind.resadmin.controller.CrudController;
import com.catchmind.resadmin.model.entity.Notice;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.request.NoticeApiRequest;
import com.catchmind.resadmin.model.network.response.NoticeApiResponse;
import com.catchmind.resadmin.service.NoticeApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/notice")    // http://localhost:8888/api/notice
@RequiredArgsConstructor
public class NoticeApiController extends CrudController<NoticeApiRequest, NoticeApiResponse, Notice> {

    private final NoticeApiLogicService noticeApiLogicService;

    @Override
    @PostMapping("")
    public Header<NoticeApiResponse> create(@RequestBody Header<NoticeApiRequest> request) {
        System.out.println("---------------");
        System.out.println(request);
        System.out.println("---------------");
        return noticeApiLogicService.create(request);
    }

//    @PostMapping("login") // http://localhost:8888/api/admin/login
//    public Header<BistroApiResponse> login(@RequestBody Header<BistroApiRequest> request) {
//        return bistroApiLogicService.login(request);
//    }

    @Override
    public Header<NoticeApiResponse> read(Long id) {
        return super.read(id);
    }

    @Override
    @PutMapping("")
    public Header<NoticeApiResponse> update(@RequestBody Header<NoticeApiRequest> request) {
        return noticeApiLogicService.update(request);
    }



    @GetMapping("") // http://localhost:8888/api/notice?page=1
    public Header<List<NoticeApiResponse>> findAll(@PageableDefault(sort = {"noIdx"}, direction= Sort.Direction.DESC) Pageable pageable){
        return noticeApiLogicService.search(pageable);
    }


}
