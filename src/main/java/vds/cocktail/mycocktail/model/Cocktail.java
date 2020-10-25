package vds.cocktail.mycocktail.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "cocktail")
public class Cocktail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCocktail;

    @Column(name = "nom_cocktail")
    private String nomCocktail;

    @Column(name = "recette_cocktail")
    private String recetteCocktail;
}
