package com.chirag.pricing.dtos.product;

import com.chirag.pricing.utils.enums.Unit;
import lombok.Data;

@Data
public class ProductCreateDTO{

    private String name;
    private Unit unit;
}
