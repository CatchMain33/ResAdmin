package com.catchmind.resadmin.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ReviewApiRequest {  // 프론트 > 백
    private String revNick;
    private String revPhoto;
    private int revLike;
    private String revContent;
    private double revScore;
    private String resaBisName;

}
