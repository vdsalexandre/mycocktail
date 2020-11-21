package vds.cocktail.mycocktail.model;

import lombok.Data;

import java.util.List;

@Data
public class CocktailDto {
    private Cocktail cocktail;
    private List<Ingredient> ingredients;
}
