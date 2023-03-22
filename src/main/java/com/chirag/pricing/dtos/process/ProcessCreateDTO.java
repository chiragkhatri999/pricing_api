package com.chirag.pricing.dtos.process;

import com.chirag.pricing.utils.enums.Unit;
import lombok.Data;

@Data
public class ProcessCreateDTO {

    private String name;
    private double cost;
    private Unit unit;
    private double quantityChangePercentage;

}
