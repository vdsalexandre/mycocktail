package vds.cocktail.mycocktail.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vds.cocktail.mycocktail.model.Cocktail;
import vds.cocktail.mycocktail.repository.CocktailRepository;

import java.util.List;

@Controller
public class WebController {
    private static final Logger LOGGER = LogManager.getLogger(WebController.class);

    @Autowired
    private CocktailRepository cocktailRepository;

    @GetMapping(value = {"/", "/home"})
    public String home(Model model) {
        LOGGER.info("returning home view with list of cocktails");
        List<Cocktail> cocktails = cocktailRepository.findAll();
        model.addAttribute("cocktails", cocktails);
        return "home";
    }
}
