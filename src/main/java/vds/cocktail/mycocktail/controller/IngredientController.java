package vds.cocktail.mycocktail.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import vds.cocktail.mycocktail.model.Ingredient;
import vds.cocktail.mycocktail.repository.IngredientRepository;

import javax.validation.Valid;

@Controller
public class IngredientController {
    private static final Logger LOGGER = LogManager.getLogger(IngredientController.class);

    @Autowired
    private IngredientRepository ingredientRepository;

    @Value("${server.servlet.context-path}")
    private String serverContextPath;

    @PostMapping("/ingredient/add")
    public RedirectView saveIngredient(@Valid @ModelAttribute Ingredient ingredient, BindingResult errors, RedirectAttributes attributes) {
        if (!errors.hasErrors()) {
            LOGGER.info("Nouvel ingrédient à insérer en base : {} - {}", ingredient.getNomIngredient(), ingredient.getTypeIngredient());
            ingredientRepository.save(ingredient);
        }
        else {
            String defaultMessage = errors.getFieldError().getDefaultMessage();
            LOGGER.warn("Erreur - {}", defaultMessage);
            attributes.addAttribute("errorMessage", defaultMessage);
        }
        return new RedirectView(serverContextPath + "/admin");
    }
}
