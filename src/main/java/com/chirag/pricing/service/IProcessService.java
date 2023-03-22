package com.chirag.pricing.service;

import com.chirag.pricing.dtos.process.ProcessCreateDTO;
import com.chirag.pricing.model.auxillary.Process;
import com.chirag.pricing.model.core.resource.ProcessedResource;
import com.chirag.pricing.model.core.resource.Resource;

import java.util.List;

public interface IProcessService {
        List<Process> getAll();

        Process create(ProcessCreateDTO processCreateDTO);

        ProcessedResource processProduct(String name, Resource resource, Process process);

        ProcessedResource processProduct(String name, Long resource_id, Long process_id);

        Process getById(Long id);

        void delete(Long id);
}
