package com.catchmind.resadmin.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BistroInfoApiRequest {  // 프론트 > 백
    private String resaBisName;
    private String bisDesc;
    private String bisCategory;
    private String bisRegion;
    private String bisLunch;
    private String bisDinner;
}
