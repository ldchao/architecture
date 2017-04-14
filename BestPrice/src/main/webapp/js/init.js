(function ($) {
    $(function () {
        $('.button-collapse').sideNav();
        $('.parallax').parallax();
    }); // end of document ready

})(jQuery); // end of jQuery name space、

$(document).ready(function () {
    $('.modal').modal();
    $('.collapsible').collapsible({
        accordion: false // A setting that changes the collapsible behavior to expandable instead of the default accordion style
    });
    $(function () {
        $('.button-collapse').sideNav();
        $('.parallax').parallax();
    });
    $('ul.tabs').tabs();
    $('select').material_select();
});