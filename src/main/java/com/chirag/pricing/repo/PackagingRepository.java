package com.chirag.pricing.repo;

import com.chirag.pricing.model.auxillary.Packaging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PackagingRepository extends JpaRepository<Packaging, Long>, JpaSpecificationExecutor<Packaging> {
}