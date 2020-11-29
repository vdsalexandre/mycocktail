package vds.cocktail.mycocktail.validator;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import vds.cocktail.mycocktail.annotation.NomCocktail;
import vds.cocktail.mycocktail.model.Cocktail;
import vds.cocktail.mycocktail.repository.CocktailRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class NomCocktailValidator implements ConstraintValidator<NomCocktail, String> {

   @Autowired
   private CocktailRepository cocktailRepository;

   private List<Cocktail> cocktails = new ArrayList<>();

   public void initialize(NomCocktail constraint) {
      cocktails = cocktailRepository.findAll();
   }

   public boolean isValid(String value, ConstraintValidatorContext context) {
      for (Cocktail cocktail : cocktails) {
         if (cocktail.getNomCocktail().equals(value)) {
            context.unwrap(HibernateConstraintValidatorContext.class).addMessageParameter("nomCocktail", cocktail.getNomCocktail());
            return false;
         }
      }
      return true;
   }
}
