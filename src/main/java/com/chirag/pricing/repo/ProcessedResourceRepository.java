package com.chirag.pricing.repo;

import com.chirag.pricing.model.core.resource.ProcessedResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProcessedResourceRepository extends JpaRepository<ProcessedResource, Long>, JpaSpecificationExecutor<ProcessedResource> {
}