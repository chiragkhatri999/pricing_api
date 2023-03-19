package com.chirag.pricing.serviceImpl;

import com.chirag.pricing.dtos.process.ProcessResourceRequestDTO;
import com.chirag.pricing.model.auxillary.Process;
import com.chirag.pricing.model.core.resource.ProcessedResource;
import com.chirag.pricing.model.core.resource.Resource;
import com.chirag.pricing.repo.ProcessRepository;
import com.chirag.pricing.service.IProcessService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessService implements IProcessService {

    private final ProcessRepository processRepository;

    private final ResourceService resourceService;

    public ProcessService(ProcessRepository processRepository, ResourceService resourceService){
        this.processRepository = processRepository;
        this.resourceService = resourceService;
    }
    @Override
    public List<Process> getAll() {
        return this.processRepository.findAll();
    }

    @Override
    public ProcessedResource processProduct(ProcessResourceRequestDTO resourceRequestDTO) {
        return this.processProduct(resourceRequestDTO.getNewName(), resourceRequestDTO.getResource_id(), resourceRequestDTO.getProcess_id());
    }

    @Override
    public ProcessedResource processProduct(String newName, Resource resource, Process process) {
        ProcessedResource processedResource = process.process(newName, resource);
        return processedResource;
    }



    @Override
    public ProcessedResource processProduct(String newName, Long resource_id, Long process_id){
        Resource resource = this.resourceService.getById(resource_id);
        Process process = this.getById(process_id);
        return this.processProduct(newName, resource, process);
    }

    @Override
    public Process getById(Long id){
        return this.processRepository.getReferenceById(id);
    }

    public void delete(Long id){
        Process toBeDelete = this.getById(id);
        this.processRepository.delete(toBeDelete);
    }
}
