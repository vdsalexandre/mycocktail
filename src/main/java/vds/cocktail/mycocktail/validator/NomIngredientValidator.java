package vds.cocktail.mycocktail.validator;

import org.springframework.beans.factory.annotation.Autowired;
import vds.cocktail.mycocktail.annotation.NomIngredient;
import vds.cocktail.mycocktail.model.Ingredient;
import vds.cocktail.mycocktail.repository.IngredientRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class NomIngredientValidator implements ConstraintValidator<NomIngredient, String> {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getNomIngredient().equals(value))
                return false;
        }
        return true;
    }
}
