package com.catchmind.resadmin.model.network.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ShopResTableApiRequest {
    private Long shopResId;
    private String resaBisName;
    private String shopResMonth;
    private String shopResDay;
    private String shopResTime;
    private boolean shopResStatus;
}
