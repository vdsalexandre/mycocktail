package vds.cocktail.mycocktail.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "ingredient")
public class Ingredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingredient")
    private Long idIngredient;

    @Column(name = "nom_ingredient")
    private String nomIngredient;

    @Column(name = "type_ingredient")
    private String typeIngredient;

    @ManyToMany(mappedBy = "ingredients", fetch = FetchType.LAZY)
    private List<Cocktail> cocktails = new ArrayList<>();
}
