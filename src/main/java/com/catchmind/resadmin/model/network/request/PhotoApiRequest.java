package com.catchmind.resadmin.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PhotoApiRequest {
    private Long phIdx;

    private String orgNm;

    private String savedNm;

    private String savedPath;

    private String type;

    private String resaBisName;

    private Long revIdx;
}
