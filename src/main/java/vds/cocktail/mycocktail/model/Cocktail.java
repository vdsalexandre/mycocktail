package vds.cocktail.mycocktail.model;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "cocktail")
public class Cocktail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cocktail")
    private Long idCocktail;

    @Column(name = "nom_cocktail")
    private String nomCocktail;

    @Column(name = "recette_cocktail")
    private String recetteCocktail;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "composer",
            joinColumns = {
                @JoinColumn(name = "id_cocktail", referencedColumnName = "id_cocktail",
                        nullable = false, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "id_ingredient", referencedColumnName = "id_ingredient",
                        nullable = false, updatable = false)})
    private List<Ingredient> ingredients = new ArrayList<>();
}
