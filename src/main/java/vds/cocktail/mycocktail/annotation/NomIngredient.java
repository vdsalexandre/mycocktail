package vds.cocktail.mycocktail.annotation;


import vds.cocktail.mycocktail.validator.NomIngredientValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = NomIngredientValidator.class)
public @interface NomIngredient {

    String message() default "L'ingrédient {nomIngredient} existe déjà";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
