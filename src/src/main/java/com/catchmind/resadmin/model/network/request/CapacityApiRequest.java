package com.catchmind.resadmin.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CapacityApiRequest {
    private Long totTableId;
    private String resaBisName;
    private String totCapacity;
    private String totTable;
}
