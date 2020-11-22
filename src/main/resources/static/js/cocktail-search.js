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
        updateSearchUrl('#aSearchCocktail');
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