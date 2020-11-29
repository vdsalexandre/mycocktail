package vds.cocktail.mycocktail.annotation;

import vds.cocktail.mycocktail.validator.NomCocktailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = NomCocktailValidator.class)
public @interface NomCocktail {

    String message() default "{cocktail.name.error.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
