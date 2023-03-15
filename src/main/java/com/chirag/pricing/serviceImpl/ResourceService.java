package com.chirag.pricing.serviceImpl;

import com.chirag.pricing.dtos.resource.ResourceCreateDTO;
import com.chirag.pricing.dtos.resource.ResourceUpdateDTO;
import com.chirag.pricing.model.core.resource.Resource;
import com.chirag.pricing.repo.ResourceRepository;
import com.chirag.pricing.service.IResourceService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Resource> getAll() {
        return resourceRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Resource resource = this.resourceRepository.getReferenceById(id);
        this.resourceRepository.delete(resource);
    }

    @Override
    public Resource create(ResourceCreateDTO resourceCreateDTO) {
        return resourceCreateDTO.create();
    }

    @Override
    public Resource update(Long id,  ResourceUpdateDTO resourceUpdateDTO){
        Resource toUpdate = this.getById(id);
        resourceUpdateDTO.update(toUpdate);
        return this.resourceRepository.save(toUpdate);
    }
}
