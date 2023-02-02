package com.catchmind.resadmin.service;

import com.catchmind.resadmin.model.entity.Reserve;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.request.ReserveApiRequest;
import com.catchmind.resadmin.model.network.response.ReserveApiResponse;
import com.catchmind.resadmin.repository.ReserveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReserveApiLogicService extends BaseService<ReserveApiRequest, ReserveApiResponse, Reserve> {
    private final ReserveRepository reserveRepository;

    private ReserveApiResponse response(Reserve reserve){
        ReserveApiResponse reserveApiResponse = ReserveApiResponse.builder()
                .regDate(reserve.getRegDate()).resMonth(reserve.getResMonth()).resDay(reserve.getResDay())
                .resaBisName(reserve.getResaBisName()).resIdx(reserve.getResIdx())
                .prIdx(reserve.getPrIdx()).visitHp(reserve.getVisitHp()).visitName(reserve.getVisitName())
                .resPerson(reserve.getResPerson()).resRequest(reserve.getResRequest())
                .resTime(reserve.getResTime()).updateDate(reserve.getUpdateDate()).resName(reserve.getResName())
                .resHp(reserve.getResHp()).resStatus(reserve.getResStatus()).resReason(reserve.getResReason()).build();
        return reserveApiResponse;
    }

    @Override
    public Header<ReserveApiResponse> create(Header<ReserveApiRequest> request) {
        return null;
    }

    @Override
    public Header<ReserveApiResponse> read(Long id) {
        return null;
    }


    public Header<ReserveApiResponse> readAll(String resaBisName) {
        return (Header<ReserveApiResponse>) reserveRepository.findAllByResaBisName(resaBisName);
    }

    public List<Reserve> readReserve(String resaBisName, String resMonth, String resDay, String resTime, String resStatus){
        return reserveRepository.findAllByResaBisNameAndResMonthAndResDayAndResTimeAndResStatus(resaBisName,resMonth,resDay,resTime,resStatus);
    }

    public Header<List<ReserveApiResponse>>  readAllReserve (String resaBisName, String resMonth, String resDay, String resTime, String resStatus){
        List<Reserve> reserves = reserveRepository.findAllByResaBisNameAndResMonthAndResDayAndResTimeAndResStatus(resaBisName,resMonth,resDay,resTime,resStatus);
        List<ReserveApiResponse> reserveApiResponses =reserves.stream().map(user->response(user)).collect(Collectors.toList());
        return Header.OK(reserveApiResponses);
    }

    public Header<List<ReserveApiResponse>> readCancel(String resaBisName,String resStatus,String resMonth, String resDay){
        List<Reserve> reserves = reserveRepository.findAllByResaBisNameAndResStatusAndResMonthAndResDay(resaBisName,resStatus,resMonth,resDay);
        List<ReserveApiResponse> reserveApiResponses = reserves.stream().map(user->response(user)).collect(Collectors.toList());
        return Header.OK(reserveApiResponses);
    }
    public Header<List<ReserveApiResponse>> readNoshow(String resaBisName,String resStatus,String resMonth, String resDay){
        List<Reserve> reserves = reserveRepository.findAllByResaBisNameAndResStatusAndResMonthAndResDay(resaBisName,resStatus,resMonth,resDay);
        List<ReserveApiResponse> reserveApiResponses = reserves.stream().map(user->response(user)).collect(Collectors.toList());;
        return Header.OK(reserveApiResponses);
    }

    public Header<ReserveApiResponse> updateStatus(String resaBisName,String resStatus,String resMonth, String resDay,String resTime ,String resReason,String visitName){
        Optional<Reserve> reserve = reserveRepository.findByResaBisNameAndResMonthAndResDayAndResTimeAndVisitName(resaBisName,resMonth,resDay,resTime,visitName);
        return reserve.map(
                        user->{
                            user.setResStatus(resStatus);
                            user.setResReason(resReason);
                            return user;
                        }).map(user-> baseRepository.save(user))
                .map(user->response(user))
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음")
                );
    }



    @Override
    public Header<ReserveApiResponse> update(Header<ReserveApiRequest> request) {
        return null;
    }

    @Override
    public Header<ReserveApiResponse> delete(Long id) {
        return null;
    }

    public Header<List<ReserveApiResponse>> dayReserve(String resaBisName, String resMonth, String resDay,String resStatus){
        List<Reserve> reserves = reserveRepository.findAllByResaBisNameAndResStatusAndResMonthAndResDay(resaBisName,resStatus,resMonth,resDay);
        List<ReserveApiResponse> reserveApiResponses = reserves.stream().map(user->response(user)).collect(Collectors.toList());;
        return Header.OK(reserveApiResponses);
    }

    public Header<List<ReserveApiResponse>> monthReserve(String resaBisName, String resMonth, String resStatus){
        List<Reserve> reserves = reserveRepository.findAllByResaBisNameAndResStatusAndResMonth(resaBisName,resStatus,resMonth);
        List<ReserveApiResponse> reserveApiResponses = reserves.stream().map(user->response(user)).collect(Collectors.toList());
        return Header.OK(reserveApiResponses);
    }
}
