package com.chirag.pricing.dtos.process;

import lombok.Data;

@Data
public class ProcessResourceRequestDTO {
    private Long process_id;
    private Long resource_id;

    private String newName;
}
