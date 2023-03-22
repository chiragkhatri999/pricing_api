package com.chirag.pricing.controller;

import com.chirag.pricing.model.core.resource.ProcessedResource;
import com.chirag.pricing.service.IProcessedResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/processed-resource")
public class ProcessedResourceController {

    private final IProcessedResourceService processedResourceService;
    public ProcessedResourceController(IProcessedResourceService processedResourceService){
        this.processedResourceService = processedResourceService;
    }
    @GetMapping("")
    public ResponseEntity<List<ProcessedResource>> getAll(){
        return ResponseEntity.ok(this.processedResourceService.getAll());
    }
}
