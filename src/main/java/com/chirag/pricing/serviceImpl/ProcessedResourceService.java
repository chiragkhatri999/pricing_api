package com.chirag.pricing.serviceImpl;

import com.chirag.pricing.model.core.resource.ProcessedResource;
import com.chirag.pricing.repo.ProcessedResourceRepository;
import com.chirag.pricing.service.IProcessedResourceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessedResourceService implements IProcessedResourceService {

    private final ProcessedResourceRepository processedResourceRepository;

    public ProcessedResourceService(ProcessedResourceRepository processedResourceRepository){
        this.processedResourceRepository = processedResourceRepository;
    }

    @Override
    public ProcessedResource save(ProcessedResource processedResource) {
        return this.processedResourceRepository.save(processedResource);
    }

    @Override
    public List<ProcessedResource> getAll() {
        return this.processedResourceRepository.findAll();
    }
}
