package com.chirag.pricing.controller;

import com.chirag.pricing.dtos.resource.ResourceCreateDTO;
import com.chirag.pricing.dtos.resource.ResourceUpdateDTO;
import com.chirag.pricing.model.core.resource.Resource;
import com.chirag.pricing.service.IResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resource")
public class ResourceController {

    private final IResourceService resourceService;

    public ResourceController(IResourceService resourceService){
        this.resourceService = resourceService;
    }

    @GetMapping("")
    public ResponseEntity<List<Resource>> getAll(){
        return ResponseEntity.ok(this.resourceService.getAll());
    }

    @GetMapping("/:id")
    public ResponseEntity<Resource> get(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.resourceService.getById(id));
    }

    @DeleteMapping("/delete/:id")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        this.resourceService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("")
    public ResponseEntity<Resource> create(@RequestBody ResourceCreateDTO resourceCreateDTO){
        Resource resource = this.resourceService.create(resourceCreateDTO);
        return ResponseEntity.ok(resource);
    }

    @PutMapping("/:id")
    public ResponseEntity<Resource> update(@PathVariable("id") Long id,  @RequestBody ResourceUpdateDTO resourceUpdateDTO){
        Resource updatedResource = this.resourceService.update(id, resourceUpdateDTO);
        return ResponseEntity.ok(updatedResource);
    }
}
