package com.catchmind.resadmin.controller.api;

import com.catchmind.resadmin.controller.CrudController;
import com.catchmind.resadmin.model.entity.Photo;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.request.PhotoApiRequest;
import com.catchmind.resadmin.model.network.response.PhotoApiResponse;
import com.catchmind.resadmin.service.PhotoApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/api/photo")    // http://localhost:8888/api/photo
@RequiredArgsConstructor
public class PhotoApiController extends CrudController<PhotoApiRequest, PhotoApiResponse, Photo> {

    private final PhotoApiLogicService photoApiLogicService;

    @Override
    public Header<PhotoApiResponse> create(Header<PhotoApiRequest> request) {
        return super.create(request);
    }

    @Override
    public Header<PhotoApiResponse> read(Long id) {
        return super.read(id);
    }

    @Override
    public Header<PhotoApiResponse> update(Header<PhotoApiRequest> request) {
        return super.update(request);
    }

    @Override
    public Header<PhotoApiResponse> delete(Long id) {
        return super.delete(id);
    }

    @PostMapping("/upload")
    public String photo(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        HttpSession session =request.getSession(false);
        String name;
        name = (String)session.getAttribute("name");
        String resaBisName = name;
        photoApiLogicService.saveFile(resaBisName,file);


//        for (MultipartFile multipartFile : files) {
//            photoApiLogicService.saveFile(resaBisName,multipartFile);
//        }
        return "redirect:/index";
    }
}
