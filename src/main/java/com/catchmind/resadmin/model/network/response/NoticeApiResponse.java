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
public class NoticeApiResponse {
    private Long noIdx;
    private String noTitle;
    private String noContent;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;

}