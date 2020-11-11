let ingredients = [];
let ingredientsIds = [];

$(function () {
    $("#accordion").accordion({
        heightStyle: "content"
    });

    $("input[type='checkbox']").change(function () {
        let element = $(this);
        let ingredient = element.val();
        let ingredientID = element.attr('id');
        let p = $('#pListIngredient');

        if (element.is(':checked')) {
            ingredients.push(ingredient);
            ingredientsIds.push(ingredientID);
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
        }

        p.text(arrayToString(ingredients));
        updateSearchUrl();
    });

    $('#aSearchCocktail').click(function (e) {
        let href = $(this).attr('href');
        let urlElements = href.split('?');

        if (urlElements.length !== 2 || urlElements[1].length === 0) {
            e.preventDefault();
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