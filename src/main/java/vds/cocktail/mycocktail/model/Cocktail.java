package vds.cocktail.mycocktail.model;

import javax.persistence.*;

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

    public Cocktail() { }

    public Long getIdCocktail() {
        return idCocktail;
    }

    public String getNomCocktail() {
        return nomCocktail;
    }

    public void setNomCocktail(String nomCocktail) {
        this.nomCocktail = nomCocktail;
    }

    public String getRecetteCocktail() {
        return recetteCocktail;
    }

    public void setRecetteCocktail(String recetteCocktail) {
        this.recetteCocktail = recetteCocktail;
    }
}
