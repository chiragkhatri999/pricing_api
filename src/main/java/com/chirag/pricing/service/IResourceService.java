package com.chirag.pricing.service;

import com.chirag.pricing.dtos.resource.ResourceCreateDTO;
import com.chirag.pricing.dtos.resource.ResourceUpdateDTO;
import com.chirag.pricing.model.core.resource.Resource;

import java.util.List;

public interface IResourceService {
    Resource getById(Long id);

    List<Resource> getAll();

    void delete(Long id);

    Resource create(ResourceCreateDTO resourceCreateDTO);

    Resource update(Long id, ResourceUpdateDTO resourceUpdateDTO);
}
