package com.chirag.pricing.service;

import com.chirag.pricing.model.core.resource.ProcessedResource;

import java.util.List;

public interface IProcessedResourceService {
    ProcessedResource save(ProcessedResource processedResource);

    List<ProcessedResource> getAll();
}
