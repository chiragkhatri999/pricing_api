package com.chirag.pricing.repo;

import com.chirag.pricing.model.core.product.ComposedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ComposedProductRepository extends JpaRepository<ComposedProduct, Long>, JpaSpecificationExecutor<ComposedProduct> {
}