$(function () {

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
    });
});

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