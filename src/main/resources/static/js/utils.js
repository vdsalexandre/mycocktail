let ingredients = [];
let ingredientsIds = [];
const menuPanel = '.menu-panel';
const shadowPanel = '.shadow-panel';
const menuButton = '.material-icons';
const menuElement = '.menu-element';

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

function toggleMenuPanel() {
    $(shadowPanel).toggle();
    $(menuPanel).slideToggle();

    if ($(shadowPanel).is(":hidden")) {
        $("*").css("filter", "none");
    } else {
        $("body > *:not(" + menuElement + ")").css("filter", "blur(2px)");
    }
}