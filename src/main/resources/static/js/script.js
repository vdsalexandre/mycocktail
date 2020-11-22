let ingredients = [];
let ingredientsIds = [];
let currentUrl = '';
let isAdmin = false;

$(function () {
    updateCurrentUrl();

    $("#accordion").accordion({
        heightStyle: "content"
    });

    $("input[type='checkbox']").change(function () {
        let element = $(this);
        let ingredient = element.val();
        let ingredientID = element.attr('id');
        const ingredientType = element.attr('data');
        let p = $('#pListIngredient');

        if (element.is(':checked')) {
            ingredients.push(ingredient);
            ingredientsIds.push(ingredientID);
            addCocktailIngredient(ingredientID, ingredient, ingredientType);
            element.closest('li').addClass('liSelected');
        }
        else {
            const index = ingredients.indexOf(ingredient);
            const indexId = ingredientsIds.indexOf(ingredientID);
            if (index > -1)
                ingredients.splice(index, 1);
            if (indexId > -1)
                ingredientsIds.splice(indexId, 1);
            element.closest('li').removeClass('liSelected');
            removeCocktailIngredient(ingredientID);
        }

        p.text(arrayToString(ingredients));
        if (!isAdmin)
            updateSearchUrl();
    });

    $('#aSearchCocktail').click(function (e) {
        let href = $(this).attr('href');
        let urlElements = href.split('?');

        if (urlElements.length !== 2 || urlElements[1].length === 0) {
            e.preventDefault();
        }
    });

    $('.p-ingredient').each(function () {
        const ingredients = $('#pListIngredient').text();
        let ingredient = $(this).text();
        ingredient = ingredient.replace("-", "").trim();
        if (ingredients.includes(ingredient)) {
            $(this).addClass('p-selected');
        }
    });
});

function arrayToString(elements) {
    let stringOfElements = '';
    for (const element of elements) {
        stringOfElements += element + ', ';
    }
    const inxdex = stringOfElements.length;
    return stringOfElements.substring(0, inxdex - 2);
}

function updateSearchUrl() {
    let searchElement = $('#aSearchCocktail');
    let tempUrl = searchElement.attr('href');
    let urlElements = tempUrl.split("?");
    let searchUrl = urlElements[0] + '?';

    if (ingredientsIds.length > 0) {
        for (const id of ingredientsIds) {
            searchUrl += 'ingredient=' + id + '&';
        }
    }
    searchUrl = searchUrl.substring(0, searchUrl.length - 1);
    searchElement.attr('href', searchUrl);
}

function addCocktailIngredient(id, name, type) {
    const index = ingredientsIds.length - 1;
    $('#div-cocktail-ingredients')
        .append("<div id='div-" + id + "'>" +
                    "<input type='hidden' id='ingredients[" + index + "].idIngredient' name='ingredients[" + index + "].idIngredient' value='" + id + "' />" +
                    "<input type='hidden' id='ingredients[" + index + "].nomIngredient' name='ingredients[" + index + "].nomIngredient' value='" + name + "' />" +
                    "<input type='hidden' id='ingredients[" + index + "].typeIngredient' name='ingredients[" + index + "].typeIngredient' value='" + type + "' />" +
                "</div>");
}

function removeCocktailIngredient(id) {
    $('#div-' + id).remove();
}

function updateCurrentUrl() {
    currentUrl = window.location.href;
    isAdmin = currentUrl.indexOf("admin") !== -1;
}