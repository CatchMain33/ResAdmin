package com.catchmind.resadmin.controller.page;

import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.response.NoticeApiResponse;
import com.catchmind.resadmin.service.NoticeApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class NoticePageController {

    @Autowired
    NoticeApiLogicService noticeApiLogicService;

    // 관리자에서 제공하는 공지사항 페이지
    // http://localhost:8888/notice
    @GetMapping(path = "notice")
    public ModelAndView notice(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String id = null;
        String name = null;

        if(session == null){
            System.out.println("세션이 없습니다.");
            return new ModelAndView("/login");

        }else{
            id = (String)session.getAttribute("id");
            name = (String)session.getAttribute("name");
            System.out.println("세션이 있습니다.");
        }
        return new ModelAndView("/notice");
    }

    // 관리자에서 제공하는 공지사항 상세페이지
    // http://localhost:8888/noticeReview
    @GetMapping(path = "noticeReview")
    public ModelAndView noticeReview(){
        return new ModelAndView("/notice_review");
    }

    @GetMapping("/noticeReview/{noIdx}")
    public ModelAndView detail(@PathVariable("noIdx") Long noIdx){
        Header<NoticeApiResponse> notice = noticeApiLogicService.read(noIdx);
        System.out.println(notice);
        return new ModelAndView("/notice_review")
                .addObject("content",notice.getData());
    }

//    @GetMapping(path = "api/notice/noticeReview/{noIdx}")
//    public ModelAndView noticeReview1(){
//        return new ModelAndView("/notice_review");
//    }

//    // 식당에서 작성한 공지사항 리스트 페이지
//    // http://localhost:8888/resNotice
//    @GetMapping(path = "resNotice")
//    public ModelAndView resNotice(){
//        return new ModelAndView("/res_notice");
//    }
//
//    // 식당에서 공지사항 작성 페이지
//    // http://localhost:8888/resNoticeWrite
//    @GetMapping(path = "resNoticeWrite")
//    public ModelAndView resNoticeWrite(){
//        return new ModelAndView("/res_notice_write");
//    }
//
//    // 식당에서 공지사항 작성 수정 페이지
//    // http://localhost:8888/resNoticeWriteModify
//    @GetMapping(path = "resNoticeWriteModify")
//    public ModelAndView resNoticeWriteModify(){
//        return new ModelAndView("/res_notice_write_modify");
//    }
}
