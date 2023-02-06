package com.catchmind.resadmin.dto;

import com.catchmind.resadmin.model.entity.BisNotice;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BisNoticeDto {

    private Long binIdx;
    private String binTitle;
    private String resaBisName;
    private String binContent;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;

    public BisNotice toEntity(){
        BisNotice bisNotice = BisNotice.builder()
                .binIdx(binIdx)
                .binTitle(binTitle)
                .resaBisName(resaBisName)
                .binContent(binContent)
                .build();
        return bisNotice;
    }

    @Builder
    public BisNoticeDto(Long binIdx, String binTitle, String resaBisName, String binContent, LocalDateTime regDate, LocalDateTime updateDate) {
        this.binIdx = binIdx;
        this.binTitle = binTitle;
        this.resaBisName = resaBisName;
        this.binContent = binContent;
        this.regDate = regDate;
        this.updateDate = updateDate;
    }
}
