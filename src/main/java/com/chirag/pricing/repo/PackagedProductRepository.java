package com.chirag.pricing.repo;

import com.chirag.pricing.model.core.product.PackagedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PackagedProductRepository extends JpaRepository<PackagedProduct, Long>, JpaSpecificationExecutor<PackagedProduct> {
}