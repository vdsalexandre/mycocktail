package vds.cocktail.mycocktail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vds.cocktail.mycocktail.model.Ingredient;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findAll();

    @Query(value = "SELECT ING.* FROM public.ingredient ING INNER JOIN public.composer COM " +
                    "ON ING.id_ingredient = COM.id_ingredient INNER JOIN public.cocktail COC " +
                    "ON COM.id_cocktail = COC.id_cocktail " +
                    "WHERE COC.nom_cocktail = :nomCocktail", nativeQuery = true)
    List<Ingredient> findIngredientsFromCocktail(@Param("nomCocktail") String nomCocktail);

    @Query(value = "SELECT ING.* FROM ingredient ING INNER JOIN composer COM " +
                    "ON ING.id_ingredient = COM.id_ingredient INNER JOIN cocktail COC " +
                    "ON COM.id_cocktail = COC.id_cocktail " +
                    "WHERE COC.id_cocktail = :idCocktail", nativeQuery = true)
    List<Ingredient> findIngredientsByIdCocktail(@Param("idCocktail") Long idCocktail);

    List<Ingredient> findIngredientsByTypeIngredient(String typeIngredient);

    List<Ingredient> findIngredientsByTypeIngredientOrderByNomIngredient(String typeIngredient);

    List<Ingredient> findIngredientsByIdIngredientIn(List<Long> idIngredients);
}
