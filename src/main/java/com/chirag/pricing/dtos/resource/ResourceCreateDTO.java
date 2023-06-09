package com.chirag.pricing.dtos.resource;

import com.chirag.pricing.utils.enums.Unit;
import lombok.Data;

@Data
public class ResourceCreateDTO{
    private String name;
    private double cost;
    private Unit unit;
}
