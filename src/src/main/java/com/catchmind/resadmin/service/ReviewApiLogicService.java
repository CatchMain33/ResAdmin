package com.catchmind.resadmin.service;


import com.catchmind.resadmin.model.entity.Review;
import com.catchmind.resadmin.model.network.Header;
import com.catchmind.resadmin.model.network.Pagination;
import com.catchmind.resadmin.model.network.request.ReviewApiRequest;
import com.catchmind.resadmin.model.network.response.ReviewApiResponse;
import com.catchmind.resadmin.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewApiLogicService extends BaseService<ReviewApiRequest, ReviewApiResponse, Review>{

    private final ReviewRepository reviewRepository;


    private ReviewApiResponse response(Review review){
        ReviewApiResponse reviewApiResponse = ReviewApiResponse.builder()
                .revIdx(review.getRevIdx())

                .revLike(review.getRevLike())
                .revContent(review.getRevContent())
                .revScore(review.getRevScore())
                .resaBisName(review.getResaBisName())
                .regDate(review.getRegDate())
                .updateDate(review.getUpdateDate())
                .build();
        return reviewApiResponse;
    }

    @Override
    public Header<ReviewApiResponse> create(Header<ReviewApiRequest> request) {
//        ReviewApiRequest reviewApiRequest = request.getData();
//
//        Review review = Review.builder()
//                .bisName(bistroApiRequest.getBisName())
//                .bisDesc(bistroApiRequest.getBisDesc())
//                .bisCategory(bistroApiRequest.getBisCategory())
//                .bisRegion(bistroApiRequest.getBisRegion())
//                .bisLunch(bistroApiRequest.getBisLunch())
//                .bisDinner(bistroApiRequest.getBisDinner())
//                .bisConvenience(bistroApiRequest.getBisConvenience())
//                .build();
//        Bistro newBistro = baseRepository.save(bistro);
//        return Header.OK(response(newBistro));
        return null;
    }

    @Override
    public Header<ReviewApiResponse> read(Long revIdx) {
        return baseRepository.findById(revIdx).map(review -> response(review))
                .map(Header::OK).orElseGet(()->Header.ERROR("데이터 없음"));
    }


//        public Header<BistroApiResponse> login(Header<BistroApiRequest> request) {
//        BistroApiRequest bistroApiRequest = request.getData();
//
//        Optional<Bistro> adminUser = bistroRepository.findByUseridAndUserpw(bistroApiRequest.getUserid(), bistroApiRequest.getUserpw());
//        if(!adminUser.isEmpty()){
//            return Header.OK();
//        }
//        return Header.ERROR("아이디 또는 비밀번호 확인");
//    }
//    @Override
//    public Header<BistroApiResponse> read(Long id) {
//        return null;
//    }

    //    public Header<BistroApiResponse> read(String userid, String userpw) {
//        return adminUserRepository.findByUseridAndUserpw(userid, userpw).map(
//                users-> response(users)).map(Header::OK).orElseGet(() -> Header.ERROR("아이디 또는 비림번호 화긴")
//        );
//    }
    @Override
    public Header<ReviewApiResponse> update(Header<ReviewApiRequest> request) {
        return null;
    }


    public Header<ReviewApiResponse> delete(Long id) {
        return null;
    }

    public Header<List<ReviewApiResponse>> search(String resaBisName){
        List<Review> review = reviewRepository.findAllByResaBisName(resaBisName);
        List<ReviewApiResponse> reviewApiResponses =review.stream().map(
                user -> response(user)).collect(Collectors.toList());

        return Header.OK(reviewApiResponses);
    }
}