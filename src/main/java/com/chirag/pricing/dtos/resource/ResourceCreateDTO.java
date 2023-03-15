package com.chirag.pricing.dtos.resource;

import com.chirag.pricing.dtos.interfaces.ICreator;
import com.chirag.pricing.model.auxillary.ValueWithUnit;
import com.chirag.pricing.model.core.resource.Resource;
import com.chirag.pricing.utils.enums.Unit;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResourceCreateDTO implements ICreator<Resource> {
    private String name;
    private double cost;
    private Unit unit;

    public Resource create(){
        Resource resource = new Resource();
        resource.setName(this.getName());
        ValueWithUnit rate = new ValueWithUnit(this.getCost(), this.getUnit());
        resource.setRate(rate);

        return resource;
    }
}
