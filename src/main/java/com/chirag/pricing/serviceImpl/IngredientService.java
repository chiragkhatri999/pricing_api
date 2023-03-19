package com.chirag.pricing.serviceImpl;

import com.chirag.pricing.dtos.ingredient.IngredientCreateDTO;
import com.chirag.pricing.dtos.ingredient.IngredientUpdateDTO;
import com.chirag.pricing.model.core.ingredient.Ingredient;
import com.chirag.pricing.model.core.resource.Resource;
import com.chirag.pricing.repo.IngredientRepository;
import com.chirag.pricing.service.IIngredientService;
import com.chirag.pricing.service.IResourceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class IngredientService implements IIngredientService {

    private final IngredientRepository ingredientRepository;
    private final IResourceService resourceService;

    public IngredientService(IngredientRepository ingredientRepository, ResourceService resourceService){
        this.ingredientRepository = ingredientRepository;
        this.resourceService = resourceService;
    }
    @Override
    public List<Ingredient> getAll() {
        return this.ingredientRepository.findAll();
    }

    @Override
    public Ingredient getById(Long id) {
        return this.ingredientRepository.getReferenceById(id);
    }

    @Override
    public Ingredient create(IngredientCreateDTO ingredientCreateDTO) {
        Ingredient ingredient = ingredientCreateDTO.create();
        Resource resource =  this.resourceService.getById(ingredientCreateDTO.getResourceId());
        ingredient.setResource(resource);
        Ingredient createdIngredient =  this.ingredientRepository.save(ingredient);
        return createdIngredient;
    }

    @Override
    public Ingredient update(Long id, IngredientUpdateDTO ingredientUpdateDTO) {
        Ingredient existing = this.ingredientRepository.getReferenceById(id);
        Ingredient updated = ingredientUpdateDTO.update(existing);
        Resource resource = this.resourceService.getById(ingredientUpdateDTO.getResourceId());
        updated.setResource(resource);
        Ingredient updatedIngredient = this.ingredientRepository.save(updated);
        return updatedIngredient;
    }

    @Override
    public void delete(Long id) {
        this.ingredientRepository.deleteById(id);
    }

    @Override
    public Set<Ingredient> getByIds(Set<Long> ids) {
        Set<Ingredient> ingredients =  ids.stream().map(id -> this.ingredientRepository.getReferenceById(id)).collect(Collectors.toSet());
        return ingredients;
    }
}
