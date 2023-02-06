package com.catchmind.resadmin.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MenuApiRequest {  // 프론트 > 백
    private Long meIdx;
    private String resaBisName;
    private String meName;
    private String meContent;
    private String mePrice;

}
