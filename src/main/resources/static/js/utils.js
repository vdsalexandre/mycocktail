let ingredients = [];
let ingredientsIds = [];

function arrayToString(elements) {
    let stringOfElements = '';
    for (const element of elements) {
        stringOfElements += element + ', ';
    }
    const inxdex = stringOfElements.length;
    return stringOfElements.substring(0, inxdex - 2);
}

function updateSearchUrl(searchParam) {
    let searchElement = $(searchParam);
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

function showMenuPanel() {

}

function hideMenuPanel() {

}