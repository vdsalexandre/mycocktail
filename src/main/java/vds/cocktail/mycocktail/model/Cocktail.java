package vds.cocktail.mycocktail.model;

import javax.persistence.*;

@Entity
@Table(name = "cocktail")
public class Cocktail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCocktail;

    @Column(name = "nom_cocktail")
    private String nomCocktail;

    @Column(name = "recette_cocktail")
    private String recetteCocktail;
}
