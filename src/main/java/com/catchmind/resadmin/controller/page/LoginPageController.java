package com.catchmind.resadmin.controller.page;

import com.catchmind.resadmin.service.ResAdminApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class LoginPageController {

    @Autowired
    private ResAdminApiLogicService resAdminApiLogicService;

    @GetMapping("")
    public ModelAndView index(HttpServletRequest request) {
        HttpSession session =request.getSession(false);
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
        return new ModelAndView("/index")
                .addObject("id", id)
                .addObject("name",name);
    }
    // 로그인 페이지
    // http://localhost:8888/login
    @GetMapping(path = "login")
    public ModelAndView login(){
        return new ModelAndView("/login");
    }

    @PostMapping(path="loginOk")  // http://localhost:8888/loginOk
    public String loginOk(HttpServletRequest request, String resaUserid, String resaUserpw){
        if(resAdminApiLogicService.read(resaUserid,resaUserpw).getData()!= null) {
            HttpSession session = request.getSession();
            String resaBisName = resAdminApiLogicService.read(resaUserid, resaUserpw).getData().getResaBisName();
            session.setAttribute("id",resaUserid);
            session.setAttribute("pw",resaUserpw);
            session.setAttribute("name",resaBisName);
            System.out.println(resaUserpw);
            if(resaUserpw.equals("1234")){
                return "redirect:/rePassword";
            }else{
                return "redirect:/";
            }
        }else{
            return "redirect:/login";
        }
    }

    // 비밀번호 찾기
    // http://localhost:8888/passwordChange
    @GetMapping(path = "passwordChange")
    public ModelAndView passwordChange(HttpServletRequest request){
        HttpSession session =request.getSession(false);
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
        return new ModelAndView("/password_change");
    }

    // 초기값 비밀번호 변경 페이지
    // http://localhost:8888/rePassword
    @GetMapping(path = "rePassword")
    public ModelAndView rePassword(HttpServletRequest request){
        HttpSession session =request.getSession(false);
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
        return new ModelAndView("/re_password");
    }

    // 비밀번호 수정 페이지
    // http://localhost:8888/myModify
    @GetMapping(path = "myModify")
    public ModelAndView myModify(HttpServletRequest request){
        HttpSession session =request.getSession(false);
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
        return new ModelAndView("/my_modify");
    }

}
