package com.catchmind.resadmin.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProfileApiRequest {  // 프론트 > 백
    private String prNick;
    private String prName;
    private String prIntro;
    private String prRegion;
    private String prHp;
    private String prUserpw;
    private String prGender;
    private String prBirth;
    private String prMemo;
    private int prReview;
    private int prNoshow;
    private boolean prBlock;

}
