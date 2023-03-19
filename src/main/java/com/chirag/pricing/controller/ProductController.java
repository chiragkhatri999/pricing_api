package com.chirag.pricing.controller;

import com.chirag.pricing.dtos.product.ProductCreateWithIngredientsDTO;
import com.chirag.pricing.dtos.product.ProductUpdateDTO;
import com.chirag.pricing.model.core.product.Product;
import com.chirag.pricing.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService){
        this.productService = productService;
    }

    /**
     * Get Composed product
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id){
        return ResponseEntity.ok(this.productService.getById(id));
    }

    /**
     * Get all composed products
     * @return
     */
    @GetMapping("")
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(this.productService.getAll());
    }

    /**
     * Create Composed Product
     * @param productCreateWithIngredientsDTO
     * @return
     */
    @PostMapping("")
    public ResponseEntity<Product> create(@RequestBody ProductCreateWithIngredientsDTO productCreateWithIngredientsDTO){
        Product product = this.productService.create(productCreateWithIngredientsDTO);
        return ResponseEntity.ok(product);
    }

    /**
     * Update composed product
     * @param id
     * @param productUpdateDTO
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody ProductUpdateDTO productUpdateDTO){
        Product updatedProduct = this.productService.update(id, productUpdateDTO);
        return ResponseEntity.ok(updatedProduct);
    }

    /**
     * Delete composed product
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        this.productService.delete(id);
        return ResponseEntity.ok().build();
    }


    /**
     * Add ingredient to product
     * @param productId
     * @param ingredientId
     * @return
     */
    @PostMapping("/{productId}/add/{ingredientId}")
    public ResponseEntity<Product> addIngredient(@PathVariable("productId") Long productId, @PathVariable("ingredientId") Long ingredientId){
        Product product = this.productService.addIngredient(productId, ingredientId);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/{productId}/remove/{ingredientId}")
    public ResponseEntity<Product> removeIngredient(@PathVariable("productId") Long productId, @PathVariable("ingredientId") Long ingredientId){
        Product product = this.productService.removeIngredient(productId, ingredientId);
        return ResponseEntity.ok(product);
    }
}
