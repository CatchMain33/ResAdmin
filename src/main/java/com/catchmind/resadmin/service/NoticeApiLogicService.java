package com.catchmind.resadmin.service;

import com.catchmind.resadmin.model.entity.Notice;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.Pagination;
import com.catchmind.resadmin.model.network.request.NoticeApiRequest;
import com.catchmind.resadmin.model.network.response.NoticeApiResponse;
import com.catchmind.resadmin.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoticeApiLogicService extends BaseService<NoticeApiRequest, NoticeApiResponse, Notice> {

    private final NoticeRepository noticeRepository;

    private NoticeApiResponse response(Notice notice){
        NoticeApiResponse noticeApiResponse = NoticeApiResponse.builder()
                .noIdx(notice.getNoIdx())
                .noTitle(notice.getNoTitle())
                .adName(notice.getAdName())
                .adUserid(notice.getAdUserid())
                .noContent(notice.getNoContent())
                .regDate(notice.getRegDate())
                .updateDate(notice.getUpdateDate())
                .build();
        return noticeApiResponse;
    }


    @Override
    public Header<NoticeApiResponse> create(Header<NoticeApiRequest> request) {
//        ResAdminApiRequest resAdminApiRequest = request.getData();
//
//        ResAdmin resAdmin = ResAdmin.builder().meUserid(adminUserApiRequest.getMeUserid())
//                .meUserpw(adminUserApiRequest.getMeUserpw())
//                .meName(adminUserApiRequest.getMeName())
//                .meHp(adminUserApiRequest.getMeHp())
//                .meName(adminUserApiRequest.getMeName())
//                .meEmail(adminUserApiRequest.getMeEmail())
//                .mePosition(adminUserApiRequest.getMePosition())
//                .build();
//        AdminUser newUsers = baseRepository.save(users);
//        return Header.OK(response(newUsers));
        return null;
    }

    @Override
    public Header<NoticeApiResponse> read(Long idx) {
        return baseRepository.findById(idx).map(menu -> response(menu))
                .map(Header::OK).orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<NoticeApiResponse> update(Header<NoticeApiRequest> request) {
        return null;
    }

    @Override
    public Header<NoticeApiResponse> delete(Long id) {
        return null;
    }

    public Header<List<NoticeApiResponse>> search(Pageable pageable){
        Page<Notice> notice = baseRepository.findAll(pageable);
        List<NoticeApiResponse> noticeApiResponses =notice.stream().map(
                user -> response(user)).collect(Collectors.toList());

        Pagination pagination = Pagination.builder()
                .totalPages(notice.getTotalPages())
                .totalElements(notice.getTotalElements())
                .currentPage(notice.getNumber())
                .currentElements(notice.getNumberOfElements())
                .build();
        return Header.OK(noticeApiResponses, pagination);
    }

}
