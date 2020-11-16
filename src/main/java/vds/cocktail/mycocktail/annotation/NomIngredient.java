package vds.cocktail.mycocktail.annotation;


import vds.cocktail.mycocktail.validator.NomIngredientValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = NomIngredientValidator.class)
public @interface NomIngredient {

    String message() default "{ingredient.name.error.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
