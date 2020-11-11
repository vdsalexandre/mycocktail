package vds.cocktail.mycocktail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vds.cocktail.mycocktail.model.Cocktail;

import java.util.List;

@Repository
public interface CocktailRepository extends JpaRepository<Cocktail, Long> {

    List<Cocktail> findAll();

    @Query(value = "SELECT COC.* FROM public.ingredient ING INNER JOIN public.composer COM " +
            "ON ING.id_ingredient = COM.id_ingredient INNER JOIN public.cocktail COC ON COM.id_cocktail = COC.id_cocktail " +
            "WHERE ING.nom_ingredient = :nomIngredient", nativeQuery = true)
    List<Cocktail> findCocktailContainingIngredient(@Param("nomIngredient") String nomIngredient);

    @Query(value = "SELECT DISTINCT C.* FROM composer O JOIN ingredient I ON O.id_ingredient = I.id_ingredient " +
            "JOIN cocktail C ON C.id_cocktail = O.id_cocktail WHERE O.id_ingredient IN ?1 " +
            "GROUP BY C.id_cocktail HAVING COUNT (DISTINCT O.id_ingredient) = ?2", nativeQuery = true)
    List<Cocktail> findCocktailsContainingIngredients(List<Long> idIngredients, Integer nbrIngredients);
}
