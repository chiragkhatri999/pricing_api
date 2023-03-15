package com.chirag.pricing.dtos.product;

import com.chirag.pricing.dtos.resource.ResourceCreateDTO;
import com.chirag.pricing.model.core.product.ComposedProduct;
import com.chirag.pricing.model.core.resource.Resource;

import java.util.Collections;

public class ComposedProductCreateDTO extends ResourceCreateDTO {

    public ComposedProduct create(){
        Resource resource = super.create();
        return new ComposedProduct(resource, Collections.emptySet());
    }

}
