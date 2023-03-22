package com.chirag.pricing.serviceImpl;

import com.chirag.pricing.dtos.process.ProcessCreateDTO;
import com.chirag.pricing.model.auxillary.Process;
import com.chirag.pricing.model.auxillary.ValueWithUnit;
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
    public Process create(ProcessCreateDTO processCreateDTO) {
        Process process = new Process();
        process.setName(processCreateDTO.getName());
        ValueWithUnit rate = new ValueWithUnit(processCreateDTO.getCost(), processCreateDTO.getUnit());
        process.setRate(rate);
        process.setQuantityChangePercentage(processCreateDTO.getQuantityChangePercentage());
        Process createdProcess = this.processRepository.save(process);
        return createdProcess;
    }

    @Override
    public ProcessedResource processProduct(String name, Resource resource, Process process) {
        ProcessedResource processedResource = process.process(name, resource);

        return processedResource;
    }

    @Override
    public ProcessedResource processProduct(String name, Long resource_id, Long process_id){
        Resource resource = this.resourceService.getById(resource_id);
        Process process = this.getById(process_id);
        return this.processProduct(name, resource, process);
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
