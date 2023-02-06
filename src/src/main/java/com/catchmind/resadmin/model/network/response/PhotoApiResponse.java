package com.catchmind.resadmin.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhotoApiResponse {
    private Long phIdx;

    private String orgNm;

    private String savedNm;

    private String savedPath;

    private String type;

    private String resaBisName;

    private Long revIdx;
}
