package com.catchmind.resadmin.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phIdx;

    private String orgNm;

    private String savedNm;

    private String savedPath;

    private String type;

    private String resaBisName;

    private Long revIdx;

    @Builder
    public Photo(Long phIdx, String orgNm, String savedNm, String savedPath, String type, String resaBisName, Long revIdx) {
        this.phIdx = phIdx;
        this.orgNm = orgNm;
        this.savedNm = savedNm;
        this.savedPath = savedPath;
        this.type = type;
        this.resaBisName = resaBisName;
        this.revIdx = revIdx;
    }
}
