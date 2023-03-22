package com.chirag.pricing.serviceImpl;

import com.chirag.pricing.dtos.resource.ResourceCreateDTO;
import com.chirag.pricing.dtos.resource.ResourceUpdateDTO;
import com.chirag.pricing.model.auxillary.ValueWithUnit;
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
        Resource resource = new Resource();
        resource.setName(resourceCreateDTO.getName());
        ValueWithUnit rate = new ValueWithUnit(resourceCreateDTO.getCost(), resourceCreateDTO.getUnit());
        resource.setRate(rate);
        Resource createdResource = this.resourceRepository.save(resource);
        return createdResource;
    }

    @Override
    public Resource update(Long id,  ResourceUpdateDTO resourceUpdateDTO){
        Resource toUpdate = this.getById(id);
        toUpdate.setName(resourceUpdateDTO.getName());
        ValueWithUnit rate =  new ValueWithUnit(resourceUpdateDTO.getCost(), resourceUpdateDTO.getUnit());
        toUpdate.setRate(rate);
        Resource updatedResource = this.resourceRepository.save(toUpdate);
        return updatedResource;
    }
}
