package com.catchmind.resadmin.controller.page;

import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.response.MenuApiResponse;
import com.catchmind.resadmin.service.MenuApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class MenuPageController {

    //    @GetMapping("regMenu")
//    public ModelAndView index2(HttpServletRequest request) {
//        HttpSession session =request.getSession(false);
//        String id = null;
//        String name = null;
//
//        if(session == null){
//            System.out.println("세션이 없습니다.");
//            return new ModelAndView("/login");
//
//        }else{
//            id = (String)session.getAttribute("id");
//            name = (String)session.getAttribute("name");
//            System.out.println("세션이 있습니다.");
//        }
//        return new ModelAndView("/reg_menu")
//                .addObject("id", id)
//                .addObject("name",name);
//    }
    @Autowired
    private MenuApiLogicService menuApiLogicService;
    // 메뉴 관리 페이지
    // http://localhost:8888/menuLookUp
    @GetMapping(path = "menuLookUp")
    public ModelAndView menuLookUp(HttpServletRequest request){
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
        return new ModelAndView("/menuLookUp");
    }

    // 메뉴 등록 페이지
    // http://localhost:8888/menuLookUp/regMenu
    @GetMapping(path = "menuLookUp/regMenu")
    public ModelAndView regMenu(HttpServletRequest request){
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
        return new ModelAndView("/reg_menu")
                .addObject("id", id)
                .addObject("name",name);
    }

    // 메뉴 수정 페이지
    // http://localhost:8888/menuModify

    @GetMapping("/menuModify/{meIdx}")
    public ModelAndView menuModify(@PathVariable Long meIdx) {
        ModelAndView view = new ModelAndView("menu_modify");
        Header<MenuApiResponse> api = menuApiLogicService.read(meIdx);
        System.out.println(api);
        view.addObject("api",api.getData());
        return view;
    }

//    @DeleteMapping("menuLookUp/{meIdx}")
//    public Header<MenuApiResponse> delete(@PathVariable Long meIdx) {
//        return menuApiLogicService.delete(meIdx);
//    }

}
