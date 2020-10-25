package vds.cocktail.mycocktail.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idIngredient;

    @Column(name = "nom_ingredient")
    private String nomIngredient;

    @Column(name = "type_ingredient")
    private String typeIngredient;
}
