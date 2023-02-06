package com.catchmind.resadmin.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CapacityApiResponse {
    private Long totTableId;
    private String resaBisName;
    private String totCapacity;
    private String totTable;
}
