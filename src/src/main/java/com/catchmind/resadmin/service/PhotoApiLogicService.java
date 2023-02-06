package com.catchmind.resadmin.service;

import com.catchmind.resadmin.model.entity.Photo;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.request.PhotoApiRequest;
import com.catchmind.resadmin.model.network.response.PhotoApiResponse;
import com.catchmind.resadmin.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PhotoApiLogicService extends BaseService<PhotoApiRequest,PhotoApiResponse,Photo> {
    private String fileDir;

    @Override
    public Header<PhotoApiResponse> create(Header<PhotoApiRequest> request) {
        return null;
    }

    @Override
    public Header<PhotoApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<PhotoApiResponse> update(Header<PhotoApiRequest> request ) {
        return null;
    }

    @Override
    public Header<PhotoApiResponse> delete(Long id) {
        return null;
    }
    private final PhotoRepository photoRepository;

    public Optional<Photo> saveFile(String resaBisName,MultipartFile files) throws IOException {
        // 원래 파일 이름 추출
        String origName = files.getOriginalFilename();

        // 파일 이름으로 쓸 uuid 생성
        String uuid = UUID.randomUUID().toString();

        // 확장자 추출(ex : .png)
        String extension = origName.substring(origName.lastIndexOf("."));

        // uuid와 확장자 결합
        String savedName = uuid + extension;

        // 파일을 불러올 때 사용할 파일 경로
        String savedPath = "C:\\test/" + savedName;

        String type = "rest";

        files.transferTo(new File(savedPath));

        Optional<Photo> photo = photoRepository.findByResaBisName(resaBisName);

        // 파일 엔티티 생성
        Photo file = Photo.builder()
                .orgNm(origName)
                .savedNm(savedName)
                .savedPath(savedPath)
                .type(type)
                .build();

        return photo.map(photo1->{
                    photo1.setSavedNm(file.getSavedNm());
                    photo1.setOrgNm(file.getOrgNm());
                    photo1.setSavedPath(file.getSavedPath());
                    photo1.setType(file.getType());
                    return photo1;
                }).map( photo1 ->
                baseRepository.save(photo1));
    }
}
