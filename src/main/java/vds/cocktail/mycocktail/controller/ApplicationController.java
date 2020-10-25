package vds.cocktail.mycocktail.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vds.cocktail.mycocktail.model.Cocktail;
import vds.cocktail.mycocktail.model.Ingredient;
import vds.cocktail.mycocktail.repository.CocktailRepository;
import vds.cocktail.mycocktail.repository.IngredientRepository;

import java.util.List;

@RestController
public class ApplicationController {
    private static final Logger LOGGER = LogManager.getLogger(ApplicationController.class);

    @Autowired
    CocktailRepository cocktailRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @GetMapping("cocktail/all")
    public List<Cocktail> findAll() {
        LOGGER.info("find all cocktails in database");
        return cocktailRepository.findAll();
    }

    @GetMapping("cocktail/{name}")
    public Cocktail findByName(@PathVariable String name) {
        LOGGER.info("find information about {}", name);
        return cocktailRepository.findByNomCocktail(name);
    }

    @GetMapping("ingredient/all")
    public List<Ingredient> findAllIngredient() {
        LOGGER.info("find all ingredients in database");
        return ingredientRepository.findAll();
    }
}
