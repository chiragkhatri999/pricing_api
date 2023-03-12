package com.chirag.pricing.serviceImpl;

import com.chirag.pricing.model.core.resource.Resource;
import com.chirag.pricing.repo.ResourceRepository;
import com.chirag.pricing.service.IResourceService;

public class ResourceService implements IResourceService {

    private ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository){
        this.resourceRepository = resourceRepository;
    }

    @Override
    public Resource getById(Long id){
        return this.resourceRepository.getReferenceById(id);
    }
}
