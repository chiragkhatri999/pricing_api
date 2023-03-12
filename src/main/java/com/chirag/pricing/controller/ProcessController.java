package com.chirag.pricing.controller;

import com.chirag.pricing.dtos.process.ProcessResourceRequestDTO;
import com.chirag.pricing.model.auxillary.Process;
import com.chirag.pricing.model.core.resource.ProcessedResource;
import com.chirag.pricing.serviceImpl.ProcessService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/api/process")
public class ProcessController {

    private final ProcessService processService;

    public ProcessController(ProcessService processService){
        this.processService = processService;
    }
    @GetMapping("")
    public List<Process> getAllProcesses(){
        return this.processService.getAll();
    }

    @PostMapping("/resource")
    public ResponseEntity<ProcessedResource> processResource(@RequestBody(required = true) ProcessResourceRequestDTO request){
        ProcessedResource processedResource =  processService.processProduct(request.getNewName(), request.getResource_id(), request.getProcess_id());
        return ResponseEntity.ok(processedResource);
    }
}
