package com.chirag.pricing.service;

import com.chirag.pricing.dtos.process.ProcessResourceRequestDTO;
import com.chirag.pricing.model.auxillary.Process;
import com.chirag.pricing.model.core.resource.ProcessedResource;
import com.chirag.pricing.model.core.resource.Resource;

import java.util.List;

public interface IProcessService {
        List<Process> getAll();

        ProcessedResource processProduct(ProcessResourceRequestDTO resourceRequestDTO);
        ProcessedResource processProduct(String newName, Resource resource, Process process);

        ProcessedResource processProduct(String newName, Long resource_id, Long process_id);

        Process getById(Long id);

        void delete(Long id);
}
