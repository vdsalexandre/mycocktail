package vds.cocktail.mycocktail.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AppJasyptPropertyService {

    @Value("${spring.datasource.password}")
    private String property;

    public String getProperty() {
        return property;
    }
}
