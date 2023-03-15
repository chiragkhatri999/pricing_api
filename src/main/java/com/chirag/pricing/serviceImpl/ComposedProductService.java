package com.chirag.pricing.serviceImpl;

import com.chirag.pricing.dtos.product.ComposedProductCreateDTO;
import com.chirag.pricing.dtos.product.ComposedProductUpdateDTO;
import com.chirag.pricing.model.core.product.ComposedProduct;
import com.chirag.pricing.repo.ComposedProductRepository;
import com.chirag.pricing.service.IComposedProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComposedProductService implements IComposedProductService {
    private final ComposedProductRepository composedProductRepository;
    public ComposedProductService(ComposedProductRepository composedProductRepository){
        this.composedProductRepository = composedProductRepository;
    }
    @Override
    public List<ComposedProduct> getAll() {
        return this.composedProductRepository.findAll();
    }

    @Override
    public ComposedProduct getById(Long id) {
        return this.composedProductRepository.getReferenceById(id);
    }

    @Override
    public ComposedProduct create(ComposedProductCreateDTO composedProductCreateDTO) {
        ComposedProduct composedProduct = composedProductCreateDTO.create();
        this.composedProductRepository.save(composedProduct);
        return composedProduct;
    }

    @Override
    public ComposedProduct update(Long id, ComposedProductUpdateDTO composedProductUpdateDTO) {
        ComposedProduct existing = this.getById(id);
        ComposedProduct updated = composedProductUpdateDTO.update(existing);
        this.composedProductRepository.save(updated);
        return updated;
    }

    @Override
    public void delete(Long id) {
        this.composedProductRepository.deleteById(id);
    }
}
