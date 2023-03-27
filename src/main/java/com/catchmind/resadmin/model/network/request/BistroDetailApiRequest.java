package com.catchmind.resadmin.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BistroDetailApiRequest {  // 프론트 > 백
    private String bdNotice;
    private String bdPark;
    private String bdAddr;
    private String bdHp;
    private String bdIntro;
    private String bdCaution;
    private String bdHour;
    private String bdHoliday;
    private String resaBisName;
    private String bdHomepage;
}
