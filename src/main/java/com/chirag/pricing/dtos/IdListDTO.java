package com.chirag.pricing.dtos;

import lombok.Data;
import lombok.NonNull;

import java.util.Set;

@Data
public class IdListDTO {
    @NonNull
    public Set<Long> ids;
}
