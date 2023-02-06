package com.catchmind.resadmin.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewApiResponse {
    private Long revIdx;
    private String revNick;
    private String revPhoto;
    private int revLike;
    private String revContent;
    private double revScore;
    private String resaBisName;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;

}