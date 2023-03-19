package com.chirag.pricing.controller;

import com.chirag.pricing.dtos.process.ProcessResourceRequestDTO;
import com.chirag.pricing.model.auxillary.Process;
import com.chirag.pricing.model.core.resource.ProcessedResource;
import com.chirag.pricing.service.IProcessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/process")
public class ProcessController {

    private final IProcessService processService;

    public ProcessController(IProcessService processService){
        this.processService = processService;
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
    @GetMapping("/:id")
    public ResponseEntity<Process> get(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.processService.getById(id));
    }

    /**
     * Process resource
     * @param request
     * @return
     */
    @PostMapping("")
    public ResponseEntity<ProcessedResource> processResource(@RequestBody ProcessResourceRequestDTO request){
        ProcessedResource processedResource =  processService.processProduct(request.getNewName(), request.getResource_id(), request.getProcess_id());
        return ResponseEntity.ok(processedResource);
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
