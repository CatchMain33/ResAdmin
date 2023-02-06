package com.catchmind.resadmin.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResAdminApiRequest {  // 프론트 > 백
    private String resaUserid;
    private String resaUserpw;
    private String resaName;
    private String resaHp;
    private String resaRegion;
    private String resaBisName;

}
