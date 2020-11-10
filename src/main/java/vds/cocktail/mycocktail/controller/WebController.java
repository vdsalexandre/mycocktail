package vds.cocktail.mycocktail.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vds.cocktail.mycocktail.model.Cocktail;
import vds.cocktail.mycocktail.model.Ingredient;
import vds.cocktail.mycocktail.repository.CocktailRepository;
import vds.cocktail.mycocktail.repository.IngredientRepository;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
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

    @GetMapping(value = {"/", "/home"})
    public String home(Model model) {
        LOGGER.info("returning home view with list of cocktails");
        List<Cocktail> cocktails = cocktailRepository.findAll();
        model.addAttribute("cocktails", cocktails);
        return "home";
    }

    @GetMapping("/detail/{idCocktail}")
    public String detail(@PathVariable Long idCocktail, Model model) {
        Cocktail cocktail = cocktailRepository.findByIdCocktail(idCocktail);
        LOGGER.info("find all ingredients for '{}'", cocktail.getNomCocktail());
        List<Ingredient> ingredients = ingredientRepository.findIngredientsByIdCocktail(cocktail.getIdCocktail());
        model.addAttribute("recetteCocktail", cocktail.getRecetteCocktail());
        model.addAttribute("nomCocktail", cocktail.getNomCocktail());
        model.addAttribute("ingredients", ingredients);
        return "detail";
    }

    @GetMapping("/ask")
    public String ask(Model model) {
        List<Ingredient> alcools = ingredientRepository.findIngredientsByTypeIngredientOrderByNomIngredient("alcool");
        List<Ingredient> softs = ingredientRepository.findIngredientsByTypeIngredient("soft");
        List<Ingredient> autres = ingredientRepository.findIngredientsByTypeIngredient("autre");
        LOGGER.info("ask view found {} alcools, {} softs and {} autres", alcools.size(), softs.size(), autres.size());
        model.addAttribute("alcools", alcools);
        model.addAttribute("softs", softs);
        model.addAttribute("autres", autres);
        return "ask";
    }

    @GetMapping("/searchcocktail")
    public String searchCocktail(@RequestParam(value = "ingredient") List<Long> ingredients, Model model) {
        List<Cocktail> cocktails = cocktailRepository.findCocktailsContainingIngredients(ingredients, ingredients.size());
        List<Ingredient> ingredientList = ingredientRepository.findIngredientsByIdIngredientIn(ingredients);
        LOGGER.info("ask cocktails view, {} cocktail(s) found that contains {} ingredients", cocktails.size(), ingredientList.size());
        model.addAttribute("cocktails", cocktails);
        model.addAttribute("ingredients", ingredientList);
        return "cocktails";
    }

    @PostConstruct
    private void onControllerReady() throws UnknownHostException {
        String host = InetAddress.getLocalHost().getHostAddress();
        LOGGER.info("----------------------------------------------------------");
        LOGGER.info("| Application ready : http://{}:{}{}/", host, serverPort, serverContextPath);
        LOGGER.info("| Application ask : http://{}:{}{}/ask/", host, serverPort, serverContextPath);
        LOGGER.info("----------------------------------------------------------");
    }
}
