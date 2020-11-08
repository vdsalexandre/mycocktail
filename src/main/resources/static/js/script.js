let ingredients = [];

$(function () {
    $("#accordion").accordion({
        heightStyle: "content"
    });

    $("input[type='checkbox']").change(function () {
        let element = $(this);
        let ingredient = element.val();
        let p = $('#pListIngredient');

        if (element.is(':checked')) {
            ingredients.push(ingredient);
        }
        else {
            const index = ingredients.indexOf(ingredient);
            if (index > -1)
                ingredients.splice(index, 1);
        }

        p.text(arrayToString(ingredients));
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
