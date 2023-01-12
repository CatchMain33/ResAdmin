package com.catchmind.resadmin.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class NoticePageController {

    // 관리자에서 제공하는 공지사항 페이지
    // http://localhost:8888/notice
    @GetMapping(path = "notice")
    public ModelAndView notice(){
        return new ModelAndView("/notice");
    }

    // 관리자에서 제공하는 공지사항 상세페이지
    // http://localhost:8888/noticeReview
    @GetMapping(path = "noticeReview")
    public ModelAndView noticeReview(){
        return new ModelAndView("/notice_review");
    }

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
