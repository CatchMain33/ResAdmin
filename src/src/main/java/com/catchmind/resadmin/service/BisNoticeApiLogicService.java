package com.catchmind.resadmin.service;

import com.catchmind.resadmin.dto.BisNoticeDto;
import com.catchmind.resadmin.model.entity.BisNotice;
import com.catchmind.resadmin.repository.BisNoticeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BisNoticeApiLogicService {

    private BisNoticeRepository bisNoticeRepository;

    public BisNoticeApiLogicService(BisNoticeRepository bisNoticeRepository) {
        this.bisNoticeRepository = bisNoticeRepository;
    }

    @Transactional
    public Long savePost(BisNoticeDto bisNoticeDto) {
        return bisNoticeRepository.save(bisNoticeDto.toEntity()).getBinIdx();
    }

    @Transactional
    public List<BisNotice> getNoticeList(String resaBisName){
        List<BisNotice> bisNoticeList = bisNoticeRepository.findAllByResaBisName(resaBisName);
        List<BisNoticeDto> bisNoticeDtoList = new ArrayList<>();

        for (BisNotice bisNotice : bisNoticeList) {
            BisNoticeDto bisNoticeDto = BisNoticeDto.builder()
                    .binIdx(bisNotice.getBinIdx())
                    .binTitle(bisNotice.getBinTitle())
                    .resaBisName(bisNotice.getResaBisName())
                    .binContent(bisNotice.getBinContent())
                    .regDate(bisNotice.getRegDate())
                    .updateDate(bisNotice.getUpdateDate())
                    .build();
            bisNoticeDtoList.add(bisNoticeDto);
        }
        return  bisNoticeList;
    }

    @Transactional
    public BisNoticeDto getPost(Long binIdx) {
        BisNotice bisNotice = bisNoticeRepository.findById(binIdx).get();

        BisNoticeDto bisNoticeDto = BisNoticeDto.builder()
                .binIdx(bisNotice.getBinIdx())
                .binTitle(bisNotice.getBinTitle())
                .resaBisName(bisNotice.getResaBisName())
                .binContent(bisNotice.getBinContent())
                .regDate(bisNotice.getRegDate())
                .updateDate(bisNotice.getUpdateDate())
                .build();
        return bisNoticeDto;
    }

    @Transactional
    public void deletePost(Long binIdx) {
        bisNoticeRepository.deleteById(binIdx);
    }



    //    private BisNoticeApiResponse response(BisNotice bisNotice){
//        BisNoticeApiResponse bisNoticeApiResponse = BisNoticeApiResponse.builder()
//                .binIdx(bisNotice.getBinIdx())
//                .binTitle(bisNotice.getBinTitle())
//                .bisName(bisNotice.getBisName())
//                .binContent(bisNotice.getBinContent())
//                .regDate(bisNotice.getRegDate())
//                .updateDate(bisNotice.getUpdateDate())
//                .build();
//        return bisNoticeApiResponse;
//
//    }
//
//    @Override
//    public Header<BisNoticeApiResponse> create(Header<BisNoticeApiRequest> request) {
//        BisNoticeApiRequest bisNoticeApiRequest = request.getData();
//        BisNotice bisNotice = BisNotice.builder()
//                .binTitle(bisNoticeApiRequest.getBinTitle())
//                .binContent(bisNoticeApiRequest.getBinContent())
//                .build();
//        BisNotice newBisNotice = baseRepository.save(bisNotice);
//        return Header.OK(response(newBisNotice));
//    }
//
//    @Override
//    public Header<BisNoticeApiResponse> read(Long id) {
//        return null;
//    }
//
//    @Override
//    public Header<BisNoticeApiResponse> update(Header<BisNoticeApiRequest> request) {
//        return null;
//    }
//
//    @Override
//    public Header<BisNoticeApiResponse> delete(Long id) {
//        return null;
//    }
//
//    public Header<List<BisNoticeApiResponse>> search(Pageable pageable){
//        Page<BisNotice> bisNotice = baseRepository.findAll(pageable);
//        List<BisNoticeApiResponse> bisNoticeApiResponses =bisNotice.stream().map(
//                user -> response(user)).collect(Collectors.toList());
//
//        Pagination pagination = Pagination.builder()
//                .totalPages(bisNotice.getTotalPages())
//                .totalElements(bisNotice.getTotalElements())
//                .currentPage(bisNotice.getNumber())
//                .currentElements(bisNotice.getNumberOfElements())
//                .build();
//        return Header.OK(bisNoticeApiResponses, pagination);
//    }
}
