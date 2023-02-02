package com.catchmind.resadmin.model.network.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

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
}
