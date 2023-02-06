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
public class MenuApiResponse {
    private Long meIdx;
    private String resaBisName;
    private String meName;
    private String meContent;
    private String mePrice;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;

}