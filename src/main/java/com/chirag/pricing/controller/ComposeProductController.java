package com.chirag.pricing.controller;

import com.chirag.pricing.dtos.product.ComposedProductCreateDTO;
import com.chirag.pricing.dtos.product.ComposedProductUpdateDTO;
import com.chirag.pricing.model.core.product.ComposedProduct;
import com.chirag.pricing.service.IComposedProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product/compose")
public class ComposeProductController {
    private final IComposedProductService composedProductService;

    public ComposeProductController(IComposedProductService composedProductService){
        this.composedProductService = composedProductService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComposedProduct> getById(@PathVariable Long id){
        return ResponseEntity.ok(this.composedProductService.getById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<ComposedProduct>> getAll(){
        return ResponseEntity.ok(this.composedProductService.getAll());
    }

    @PostMapping("")
    public ResponseEntity<ComposedProduct> create(@RequestBody ComposedProductCreateDTO composedProductCreateDTO){
        ComposedProduct composedProduct = this.composedProductService.create(composedProductCreateDTO);
        return ResponseEntity.ok(composedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComposedProduct> update(@PathVariable Long id, @RequestBody ComposedProductUpdateDTO composedProductUpdateDTO){
        ComposedProduct updatedComposedProduct = this.composedProductService.update(id, composedProductUpdateDTO);
        return ResponseEntity.ok(updatedComposedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        this.composedProductService.delete(id);
        return ResponseEntity.ok().build();
    }
}
