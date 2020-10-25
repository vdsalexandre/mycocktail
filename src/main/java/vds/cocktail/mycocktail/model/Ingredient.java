package vds.cocktail.mycocktail.model;

import javax.persistence.*;

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

    public Ingredient() { }

    public Long getIdIngredient() {
        return idIngredient;
    }

    public String getNomIngredient() {
        return nomIngredient;
    }

    public void setNomIngredient(String nomIngredient) {
        this.nomIngredient = nomIngredient;
    }

    public String getTypeIngredient() {
        return typeIngredient;
    }

    public void setTypeIngredient(String typeIngredient) {
        this.typeIngredient = typeIngredient;
    }
}
