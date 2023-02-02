package com.catchmind.resadmin.controller.api;

import com.catchmind.resadmin.controller.CrudController;
import com.catchmind.resadmin.model.entity.Reserve;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.request.ReserveApiRequest;
import com.catchmind.resadmin.model.network.response.ReserveApiResponse;
import com.catchmind.resadmin.service.ReserveApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/reservation")    // http://localhost:8888/api/reserve
@RequiredArgsConstructor
public class ReserveApiController extends CrudController<ReserveApiRequest, ReserveApiResponse, Reserve> {
    private final ReserveApiLogicService reserveApiLogicService;

    @Override
    public Header<ReserveApiResponse> create(Header<ReserveApiRequest> request) {
        return super.create(request);
    }

    @Override
    public Header<ReserveApiResponse> read(Long id) {
        return super.read(id);
    }

    @Override
    public Header<ReserveApiResponse> update(Header<ReserveApiRequest> request) {
        return super.update(request);
    }

    @Override
    public Header<ReserveApiResponse> delete(Long id) {
        return super.delete(id);
    }

    @GetMapping("/data1")
    public Header<List<ReserveApiResponse>> listDetail1(String resaBisName, @RequestParam("resMonth") String resMonth, @RequestParam("resDay") String resDay, @RequestParam("resTime") String resTime, String resStatus,HttpServletRequest request){
        resStatus = "PLANNED";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        System.out.println(reserveApiLogicService.readAllReserve(resaBisName,resMonth,resDay,resTime, resStatus));
        return reserveApiLogicService.readAllReserve(resaBisName,resMonth,resDay,resTime,resStatus);
    }


    @GetMapping("/data2")
    public Header<List<ReserveApiResponse>> listDetail2(String resaBisName, @RequestParam("resMonth") String resMonth, @RequestParam("resDay") String resDay, @RequestParam("resTime") String resTime, String resStatus,HttpServletRequest request){
        resStatus = "PLANNED";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        System.out.println(reserveApiLogicService.readAllReserve(resaBisName,resMonth,resDay,resTime, resStatus));
        return reserveApiLogicService.readAllReserve(resaBisName,resMonth,resDay,resTime,resStatus);
    }

    @GetMapping("/data3")
    public Header<List<ReserveApiResponse>> listDetail3(String resaBisName, @RequestParam("resMonth") String resMonth, @RequestParam("resDay") String resDay, @RequestParam("resTime") String resTime, String resStatus,HttpServletRequest request){
        resStatus = "PLANNED";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        System.out.println(reserveApiLogicService.readAllReserve(resaBisName,resMonth,resDay,resTime, resStatus));
        return reserveApiLogicService.readAllReserve(resaBisName,resMonth,resDay,resTime,resStatus);
    }

    @GetMapping("/data4")
    public Header<List<ReserveApiResponse>> listDetail4(String resaBisName, @RequestParam("resMonth") String resMonth, @RequestParam("resDay") String resDay, @RequestParam("resTime") String resTime, String resStatus,HttpServletRequest request){
        resStatus = "PLANNED";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        System.out.println(reserveApiLogicService.readAllReserve(resaBisName,resMonth,resDay,resTime, resStatus));
        return reserveApiLogicService.readAllReserve(resaBisName,resMonth,resDay,resTime,resStatus);
    }

    @GetMapping("/data5")
    public Header<List<ReserveApiResponse>> listDetail5(String resaBisName, @RequestParam("resMonth") String resMonth, @RequestParam("resDay") String resDay, @RequestParam("resTime") String resTime, String resStatus,HttpServletRequest request){
        resStatus = "PLANNED";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        System.out.println(reserveApiLogicService.readAllReserve(resaBisName,resMonth,resDay,resTime, resStatus));
        return reserveApiLogicService.readAllReserve(resaBisName,resMonth,resDay,resTime,resStatus);
    }

    @GetMapping("/data6")
    public Header<List<ReserveApiResponse>> listDetail6(String resaBisName, @RequestParam("resMonth") String resMonth, @RequestParam("resDay") String resDay, @RequestParam("resTime") String resTime, String resStatus, HttpServletRequest request){
        resStatus = "PLANNED";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        System.out.println(reserveApiLogicService.readAllReserve(resaBisName,resMonth,resDay,resTime, resStatus));
        return reserveApiLogicService.readAllReserve(resaBisName,resMonth,resDay,resTime,resStatus);
    }

    @GetMapping("/cancel")
    public Header<List<ReserveApiResponse>> cancelList(String resaBisName,String resStatus, @RequestParam("resMonth") String resMonth, @RequestParam("resDay") String resDay, HttpServletRequest request){
        resStatus = "CANCEL";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.readCancel(resaBisName,resStatus,resMonth,resDay);
    }
    @GetMapping("/noshow")
    public Header<List<ReserveApiResponse>> noshowList(String resaBisName,String resStatus, @RequestParam("resMonth") String resMonth, @RequestParam("resDay") String resDay, HttpServletRequest request){
        resStatus = "NOSHOW";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.readNoshow(resaBisName,resStatus,resMonth,resDay);
    }

    @GetMapping("/modify")
    public Header<ReserveApiResponse> statusUpdate(String resaBisName,@RequestParam("resStatus")String resStatus, @RequestParam("resMonth") String resMonth , @RequestParam("resDay") String resDay, @RequestParam("resTime") String resTime, @RequestParam("resReason") String resReason,@RequestParam("visitName") String visitName, HttpServletRequest request){
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.updateStatus(resaBisName,resStatus,resMonth,resDay,resTime,resReason,visitName);
    }

    @GetMapping("/daycom")
    public Header<List<ReserveApiResponse>> noshowList1(String resaBisName,String resStatus, @RequestParam("resMonth") String resMonth, @RequestParam("resDay") String resDay, HttpServletRequest request){
        resStatus = "DONE";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.dayReserve(resaBisName,resMonth,resDay,resStatus);
    }

    @GetMapping("/dayplan")
    public Header<List<ReserveApiResponse>> noshowList2(String resaBisName,String resStatus, @RequestParam("resMonth") String resMonth, @RequestParam("resDay") String resDay, HttpServletRequest request){
        resStatus = "PLANNED";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.dayReserve(resaBisName,resMonth,resDay,resStatus);
    }

    @GetMapping("/daycancel")
    public Header<List<ReserveApiResponse>> noshowList3(String resaBisName,String resStatus, @RequestParam("resMonth") String resMonth, @RequestParam("resDay") String resDay, HttpServletRequest request){
        resStatus = "CANCEL";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.dayReserve(resaBisName,resMonth,resDay,resStatus);
    }

    @GetMapping("/monthcom")
    public Header<List<ReserveApiResponse>> noshowList4(String resaBisName,String resStatus, @RequestParam("resMonth") String resMonth,HttpServletRequest request){
        resStatus = "DONE";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }

    @GetMapping("/monthplan")
    public Header<List<ReserveApiResponse>> noshowList5(String resaBisName,String resStatus, @RequestParam("resMonth") String resMonth,HttpServletRequest request){
        resStatus = "PLANNED";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }

    @GetMapping("/monthcancel")
    public Header<List<ReserveApiResponse>> noshowList6(String resaBisName,String resStatus, @RequestParam("resMonth") String resMonth,HttpServletRequest request){
        resStatus = "CANCEL";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/month1")
    public Header<List<ReserveApiResponse>> month1(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "PLANNED";
        resMonth = "01";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/mmonth1")
    public Header<List<ReserveApiResponse>> mmonth1(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "DONE";
        resMonth = "01";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/month2")
    public Header<List<ReserveApiResponse>> month2(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "PLANNED";
        resMonth = "02";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/mmonth2")
    public Header<List<ReserveApiResponse>> mmonth2(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "DONE";
        resMonth = "02";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/month3")
    public Header<List<ReserveApiResponse>> month3(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "PLANNED";
        resMonth = "03";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/mmonth3")
    public Header<List<ReserveApiResponse>> mmonth3(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "DONE";
        resMonth = "03";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/month4")
    public Header<List<ReserveApiResponse>> month4(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "PLANNED";
        resMonth = "04";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/mmonth4")
    public Header<List<ReserveApiResponse>> mmonth4(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "DONE";
        resMonth = "04";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/month5")
    public Header<List<ReserveApiResponse>> month5(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "PLANNED";
        resMonth = "05";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/mmonth5")
    public Header<List<ReserveApiResponse>> mmonth5(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "DONE";
        resMonth = "05";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/month6")
    public Header<List<ReserveApiResponse>> month6(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "PLANNED";
        resMonth = "06";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/mmonth6")
    public Header<List<ReserveApiResponse>> mmonth6(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "DONE";
        resMonth = "06";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/month7")
    public Header<List<ReserveApiResponse>> month7(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "PLANNED";
        resMonth = "07";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/mmonth7")
    public Header<List<ReserveApiResponse>> mmonth7(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "DONE";
        resMonth = "07";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/month8")
    public Header<List<ReserveApiResponse>> month8(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "PLANNED";
        resMonth = "08";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/mmonth8")
    public Header<List<ReserveApiResponse>> mmonth8(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "DONE";
        resMonth = "08";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/month9")
    public Header<List<ReserveApiResponse>> month9(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "PLANNED";
        resMonth = "09";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/mmonth9")
    public Header<List<ReserveApiResponse>> mmonth9(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "DONE";
        resMonth = "09";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/month10")
    public Header<List<ReserveApiResponse>> month10(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "PLANNED";
        resMonth = "10";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/mmonth10")
    public Header<List<ReserveApiResponse>> mmonth10(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "DONE";
        resMonth = "10";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/month11")
    public Header<List<ReserveApiResponse>> month11(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "PLANNED";
        resMonth = "11";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/mmonth11")
    public Header<List<ReserveApiResponse>> mmonth11(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "DONE";
        resMonth = "11";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/month12")
    public Header<List<ReserveApiResponse>> month12(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "PLANNED";
        resMonth = "12";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
    @GetMapping("/mmonth12")
    public Header<List<ReserveApiResponse>> mmonth12(String resaBisName,String resMonth,String resStatus,HttpServletRequest request){
        resStatus = "DONE";
        resMonth = "12";
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        resaBisName = name;
        return reserveApiLogicService.monthReserve(resaBisName,resMonth,resStatus);
    }
}

