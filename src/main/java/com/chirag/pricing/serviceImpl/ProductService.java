package com.chirag.pricing.serviceImpl;

import com.chirag.pricing.dtos.IdListDTO;
import com.chirag.pricing.dtos.product.ProductCreateWithIngredientsDTO;
import com.chirag.pricing.dtos.product.ProductUpdateDTO;
import com.chirag.pricing.model.auxillary.ValueWithUnit;
import com.chirag.pricing.model.core.ingredient.Ingredient;
import com.chirag.pricing.model.core.product.Product;
import com.chirag.pricing.repo.ProductRepository;
import com.chirag.pricing.service.IIngredientService;
import com.chirag.pricing.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {


    private final ProductRepository productRepository;
    private final IIngredientService ingredientService;

    public ProductService(ProductRepository productRepository, IIngredientService ingredientService){
        this.productRepository = productRepository;
        this.ingredientService = ingredientService;
    }
    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return this.productRepository.getReferenceById(id);
    }

    @Override
    public Product create(ProductCreateWithIngredientsDTO productCreateWithIngredientsDTO) {
        Product product = new Product();
        product.setName(productCreateWithIngredientsDTO.getName());
        product.setRate(ValueWithUnit.createWithUnit(productCreateWithIngredientsDTO.getUnit()));
        //create ingredients and set on product
        Set<Ingredient> ingredients = productCreateWithIngredientsDTO.getIngredients().stream()
                .map(ingredientCreateDTO -> this.ingredientService.create(ingredientCreateDTO))
                .collect(Collectors.toSet());
        product.setIngredients(ingredients);
        Product createdProduct = this.productRepository.save(product);
        return createdProduct;
    }

    @Override
    public Product update(Long id, ProductUpdateDTO productUpdateDTO) {
        Product toBeUpdated = this.getById(id);
        toBeUpdated.setName(productUpdateDTO.getName());
        // get ingredients and update on product
        IdListDTO idListDTO = new IdListDTO(productUpdateDTO.getIngredientIds());
        Set<Ingredient> ingredients = this.ingredientService.getByIds(idListDTO.getIds());
        toBeUpdated.setIngredients(ingredients);

        // save updated product
        Product product = this.productRepository.save(toBeUpdated);
        return product;
    }

    @Override
    public void delete(Long id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public Product addIngredient(Long productId, Long ingredientId) {
        // Get ingredient from id
        Ingredient ingredient = this.ingredientService.getById(ingredientId);

        // get existing ingredient of product
        Product existingProduct = this.getById(productId);
        Set<Ingredient> ingredients = existingProduct.getIngredients();
        ingredients.add(ingredient);

        // add ingredient and save product
        existingProduct.setIngredients(ingredients);
        Product updatedProduct = this.productRepository.save(existingProduct);
        return updatedProduct;
    }

    @Override
    public Product removeIngredient(Long productId, Long ingredientId) {
        // Get ingredient from id
        Ingredient ingredient = this.ingredientService.getById(ingredientId);

        // get existing ingredient of product
        Product existingProduct = this.getById(productId);
        Set<Ingredient> ingredients = existingProduct.getIngredients();
        ingredients.remove(ingredient);

        // add ingredient and save product
        existingProduct.setIngredients(ingredients);
        Product updatedProduct = this.productRepository.save(existingProduct);

        this.ingredientService.delete(ingredientId);
        return updatedProduct;
    }
}
