package com.chirag.pricing.dtos.resource;

import com.chirag.pricing.dtos.interfaces.IUpdator;
import com.chirag.pricing.model.auxillary.ValueWithUnit;
import com.chirag.pricing.model.core.resource.Resource;

public class ResourceUpdateDTO extends ResourceCreateDTO implements IUpdator<Resource> {

    /**
     * To update provided resource with info from DTO
     * All info is replaced from DTO to resource
     * @param toBeUpdated resource to update with DTO info
     */
    public Resource update(Resource toBeUpdated){
        toBeUpdated.setName(this.getName());
        ValueWithUnit rate =  new ValueWithUnit(this.getCost(), this.getUnit());
        toBeUpdated.setRate(rate);
        return toBeUpdated;
    }
}
