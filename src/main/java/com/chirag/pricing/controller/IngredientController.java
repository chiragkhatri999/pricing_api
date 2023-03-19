package com.chirag.pricing.controller;

import com.chirag.pricing.dtos.ingredient.IngredientCreateDTO;
import com.chirag.pricing.dtos.ingredient.IngredientUpdateDTO;
import com.chirag.pricing.model.core.ingredient.Ingredient;
import com.chirag.pricing.service.IIngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {
    private final IIngredientService ingredientService;
    public IngredientController(IIngredientService ingredientService){
        this.ingredientService = ingredientService;
    }

    @GetMapping("")
    public ResponseEntity<List<Ingredient>> getAll(){
        return ResponseEntity.ok(this.ingredientService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getById(@PathVariable Long id){
        return ResponseEntity.ok(this.ingredientService.getById(id));
    }

    @PostMapping("")
    public ResponseEntity<Ingredient> create(@RequestBody IngredientCreateDTO ingredientCreateDTO){
        return ResponseEntity.ok(this.ingredientService.create(ingredientCreateDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> create(@PathVariable Long id, @RequestBody IngredientUpdateDTO ingredientUpdateDTO){
        return ResponseEntity.ok(this.ingredientService.update(id, ingredientUpdateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        this.ingredientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
