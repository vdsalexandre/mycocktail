package vds.cocktail.mycocktail.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vds.cocktail.mycocktail.model.Cocktail;
import vds.cocktail.mycocktail.model.Ingredient;
import vds.cocktail.mycocktail.repository.CocktailRepository;
import vds.cocktail.mycocktail.repository.IngredientRepository;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    private static final Logger LOGGER = LogManager.getLogger(WebController.class);

    @Autowired
    private CocktailRepository cocktailRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Value("${server.port}")
    private int serverPort;

    @Value("${server.servlet.context-path}")
    private String serverContextPath;

    private List<Ingredient> alcools = new ArrayList<>();
    private List<Ingredient> softs = new ArrayList<>();
    private List<Ingredient> autres = new ArrayList<>();

    @GetMapping("/")
    public String ask(Model model) {
        getAllIngredients();
        LOGGER.info("ask view found {} alcools, {} softs and {} autres", alcools.size(), softs.size(), autres.size());
        model.addAttribute("alcools", alcools);
        model.addAttribute("softs", softs);
        model.addAttribute("autres", autres);
        return "ask";
    }

    @GetMapping("/searchcocktail")
    public String searchCocktail(@RequestParam(value = "ingredient", required = false) List<Long> ingredients, Model model) {
        if (ingredients == null)
            LOGGER.info("liste vide ...");
        List<Cocktail> cocktails = cocktailRepository.findCocktailsContainingIngredients(ingredients, ingredients.size());
        List<Ingredient> ingredientList = ingredientRepository.findIngredientsByIdIngredientIn(ingredients);
        LOGGER.info("ask cocktails view, {} cocktail(s) found that contains {} ingredients", cocktails.size(), ingredientList.size());
        model.addAttribute("cocktails", cocktails);
        model.addAttribute("ingredients", ingredientList);
        return "cocktails";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        getAllIngredients();
        LOGGER.info("admin view");
        model.addAttribute("cocktail", new Cocktail());
        model.addAttribute("ingredients", new ArrayList<Ingredient>());
        model.addAttribute("ingredient", new Ingredient());
        model.addAttribute("alcools", alcools);
        model.addAttribute("softs", softs);
        model.addAttribute("autres", autres);
        return "admin/addCocktail";
    }

    @PostMapping("/cocktail/add")
    public String addCocktail(@ModelAttribute Cocktail cocktail, @ModelAttribute List<Ingredient> ingredients) {

        return "admin/addCocktail";
    }

    @PostConstruct
    private void onControllerReady() throws UnknownHostException {
        String host = InetAddress.getLocalHost().getHostAddress();
        LOGGER.info("----------------------------------------------------------");
        LOGGER.info("| Application ready : http://{}:{}{}/", host, serverPort, serverContextPath);
        LOGGER.info("| Application admin : http://{}:{}{}/admin/", host, serverPort, serverContextPath);
        LOGGER.info("----------------------------------------------------------");
    }

    private void getAllIngredients() {
        alcools = ingredientRepository.findIngredientsByTypeIngredientOrderByNomIngredient("alcool");
        softs = ingredientRepository.findIngredientsByTypeIngredientOrderByNomIngredient("soft");
        autres = ingredientRepository.findIngredientsByTypeIngredientOrderByNomIngredient("autre");
    }
}
