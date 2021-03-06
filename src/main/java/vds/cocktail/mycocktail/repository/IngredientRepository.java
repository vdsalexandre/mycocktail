package vds.cocktail.mycocktail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vds.cocktail.mycocktail.model.Ingredient;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findAll();

    List<Ingredient> findIngredientsByTypeIngredientOrderByNomIngredient(String typeIngredient);

    List<Ingredient> findIngredientsByIdIngredientIn(List<Long> idIngredients);

    @Override
    Ingredient save(Ingredient ingredient);
}
