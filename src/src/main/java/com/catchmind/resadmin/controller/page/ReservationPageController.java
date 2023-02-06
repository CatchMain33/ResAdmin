package com.catchmind.resadmin.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class ReservationPageController {

    // 예약 내역 페이지
    // http://localhost:8888/reservation
    @GetMapping(path = "reservation")
    public ModelAndView reservation(HttpServletRequest request){
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
        return new ModelAndView("/reservation");
    }

    // 예약 캘린더 페이지
    // http://localhost:8888/reservationCalender
    @GetMapping(path = "reservationCalender")
    public ModelAndView reservationCalender(HttpServletRequest request){
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
        return new ModelAndView("/reservation_calender");
    }

    // 예약 취소 내역 페이지
    // http://localhost:8888/reservationCancel
    @GetMapping(path = "reservationCancel")
    public ModelAndView reservationCancel(HttpServletRequest request){
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
        return new ModelAndView("/reservation_cancel");
    }





}
