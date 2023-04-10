package com.catchmind.resadmin.model.network.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopResTableApiResponse {
    private Long shopResId;
    private String resaBisName;
    private String shopResMonth;
    private String shopResDay;
    private String shopResTime;
    private boolean shopResStatus;
    private int totTableId;
}
