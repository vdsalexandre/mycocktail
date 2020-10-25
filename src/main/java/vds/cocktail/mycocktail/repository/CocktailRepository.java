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

    Cocktail findByNomCocktail(String nomCocktail);

    @Query(value = "SELECT COC.* FROM public.ingredient ING INNER JOIN public.composer COM " +
            "ON ING.id_ingredient = COM.id_ingredient INNER JOIN public.cocktail COC ON COM.id_cocktail = COC.id_cocktail " +
            "WHERE ING.nom_ingredient = :nomIngredient", nativeQuery = true)
    List<Cocktail> findCocktailContainingIngredient(@Param("nomIngredient") String nomIngredient);
}
