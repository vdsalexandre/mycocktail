## MyCocktail

### Application to find a cocktail from ingredients

#### Example of use (REST) :

| URL                                                  | RESULT                                         |
|------------------------------------------------------|------------------------------------------------|
| http://localhost:8080/cocktail/contains/rhum%20blanc | List of <*cocktail*> containing **rhum blanc** |
| http://localhost:8080/cocktail/all                   | List of all <*cocktail*>                       |
| http://localhost:8080/cocktail/mojito                | information about <*cocktail*> **mojito**      |
| http://localhost:8080/ingredient/all                 | List of all <*ingredient*>                     |
| http://localhost:8080/ingredient/pina%20colada       | List of <*ingredient*> from **pina colada**    |

#### Example of use application :

| URL                                                  | RESULT                                         |
|------------------------------------------------------|------------------------------------------------|
| http://localhost:8080/                               | home                                           |
| http://localhost:8080/ask                            | find a cocktail that contains <ingredient>     |
