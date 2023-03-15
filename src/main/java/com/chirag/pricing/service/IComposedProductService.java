package com.chirag.pricing.service;

import com.chirag.pricing.dtos.product.ComposedProductCreateDTO;
import com.chirag.pricing.dtos.product.ComposedProductUpdateDTO;
import com.chirag.pricing.model.core.product.ComposedProduct;

import java.util.List;

public interface IComposedProductService {

    List<ComposedProduct> getAll();

    ComposedProduct getById(Long id);

    ComposedProduct create(ComposedProductCreateDTO composedProductCreateDTO);
    ComposedProduct update(Long id, ComposedProductUpdateDTO composedProductUpdateDTO);

    void delete(Long id);

}
