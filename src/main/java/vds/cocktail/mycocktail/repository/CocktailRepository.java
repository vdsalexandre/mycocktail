package vds.cocktail.mycocktail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vds.cocktail.mycocktail.model.Cocktail;

import java.util.List;

@Repository
public interface CocktailRepository extends JpaRepository<Cocktail, Long> {

    List<Cocktail> findAll();

    Cocktail findByNomCocktail(String nomCocktail);
}
