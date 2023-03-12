package com.chirag.pricing.dtos.process;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProcessResourceRequestDTO {
    private Long process_id;
    private Long resource_id;

    private String newName;
}
