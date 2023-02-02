package com.catchmind.resadmin.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ReserveApiRequest {
    private Long resIdx;
    private String resaBisName;
    private int prIdx;
    private String resName;
    private String resHp;
    private String resRequest;
    private String visitName;
    private String visitHp;
    private String resMonth;
    private String resDay;
    private String resPerson;
    private String resTime;
    private String resStatus;
    private String resReason;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
}
