package com.chirag.pricing.controller;

import com.chirag.pricing.dtos.process.ProcessCreateDTO;
import com.chirag.pricing.dtos.process.ResourceProcessDTO;
import com.chirag.pricing.model.auxillary.Process;
import com.chirag.pricing.model.core.resource.ProcessedResource;
import com.chirag.pricing.service.IProcessService;
import com.chirag.pricing.service.IProcessedResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/process")
public class ProcessController {

    private final IProcessService processService;
    private final IProcessedResourceService processedResourceService;

    public ProcessController(
            IProcessService processService,
            IProcessedResourceService processedResourceService){
        this.processService = processService;
        this.processedResourceService = processedResourceService;
    }

    /**
     * Get all processes
     * @return
     */
    @GetMapping("")
    public ResponseEntity<List<Process>> getAllProcesses(){
        return ResponseEntity.ok(this.processService.getAll());
    }

    /**
     * get process
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Process> get(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.processService.getById(id));
    }

    /**
     * Create process
     * @param processCreateDTO
     * @return
     */
    @PostMapping("")
    public ResponseEntity<Process> create(@RequestBody ProcessCreateDTO processCreateDTO){
        return ResponseEntity.ok(this.processService.create(processCreateDTO));
    }

    /**
     * Process resource
     * @param processId
     * @param resourceId
     * @param resourceProcessDTO
     * @return
     */
    @PostMapping("/processResource")
    public ResponseEntity<ProcessedResource> processResource(@RequestParam("processId") Long processId, @RequestParam("resourceId") Long resourceId, @RequestBody ResourceProcessDTO resourceProcessDTO){
        ProcessedResource processedResource =  processService.processProduct(resourceProcessDTO.getName(), resourceId, processId);
        ProcessedResource createdProcessedResource = this.processedResourceService.save(processedResource);
        return ResponseEntity.ok(createdProcessedResource);
    }

    /**
     * Delete process
     * @param id
     * @return
     */
    @DeleteMapping("/delete/:id")
    public ResponseEntity delete(@PathVariable("id") Long id){
        this.processService.delete(id);
        return ResponseEntity.ok().build();
    }

    // Update not required
}
