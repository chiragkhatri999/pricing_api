package com.chirag.pricing.serviceImpl;

import com.chirag.pricing.model.core.resource.Resource;
import com.chirag.pricing.repo.ResourceRepository;
import com.chirag.pricing.service.IResourceService;
import org.springframework.stereotype.Service;

@Service
public class ResourceService implements IResourceService {

    private final ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository){
        this.resourceRepository = resourceRepository;
    }

    @Override
    public Resource getById(Long id){
        return this.resourceRepository.getReferenceById(id);
    }
}
