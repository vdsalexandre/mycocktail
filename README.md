## MyCocktail

### Application to find a cocktail from ingredients

#### Example of use (REST) :

| URL                                                             | RESULT                                         |
|-----------------------------------------------------------------|------------------------------------------------|
| http://localhost:9090/mycocktail/cocktail/contains/rhum%20blanc | List of <*cocktail*> containing **rhum blanc** |
| http://localhost:9090/mycocktail/cocktail/all                   | List of all <*cocktail*>                       |
| http://localhost:9090/mycocktail/cocktail/mojito                | information about <*cocktail*> **mojito**      |
| http://localhost:9090/mycocktail/ingredient/all                 | List of all <*ingredient*>                     |
| http://localhost:9090/mycocktail/ingredient/pina%20colada       | List of <*ingredient*> from **pina colada**    |

#### Example of use application :

| URL                                                  | RESULT                                         |
|------------------------------------------------------|------------------------------------------------|
| http://localhost:9090/mycocktail/                    | home                                           |
| http://localhost:9090/mycocktail/ask                 | find a cocktail that contains <*ingredient*>   |
