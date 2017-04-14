
function toaster(message, type) {
    var toaster = $("#toaster");
    toaster.append('<div class="toast-item"><div class="message">' + message + '</div>' +
        '<i class="close fa fa-close"></i></div>');
    var thisItem = toaster.children().last();
    $(thisItem.children(".close").eq(0)).bind("click", function () {
        thisItem.slideUp(function() {
            thisItem.remove();
        });
    });
    if (type == "success") thisItem.addClass("success");
    else if (type == "error") thisItem.addClass("error");
    thisItem.fadeIn();
    setTimeout(function() {
        thisItem.slideUp(function() {
            thisItem.remove();
        });
    }, 3000);
}


/////////////////////////////////
function filter(condition) {

    $.ajax({
        type: "POST",
        url: "/shieldSearchResult",
        data: {
            "condition": condition
        },
        success: function (data) {

            setGoodsResult(data);
        },
        error: function () {
            alert("筛选失败");
        }
    });
}

function mysort(sortRule) {

    alert(sortRule);

    $.ajax({
        type: "POST",
        url: "/sortSearchResult",
        data: {
            "sortRule": sortRule
        },
        success: function (data) {
            setGoodsResult(data);
        },
        error: function () {
            alert("排序失败");
        }
    });
}

function searchInit() {
    $("#js-btn-search").click(function () {
        getGoods( $("#js-search-input").val())
    });
}

function getGoods(key){
    $.ajax({
        type:"POST",
        url:"/searchGoods",
        data:{
            key: key
        },
        success: function (list) {

            console.log(list);
            setGoodsResult(list);
        },
        error: function () {
            toaster("服务器出现问题，请稍微再试！", "error");
        }
    });
}

function setGoodsResult(list) {

    $("#product-panel").empty();

    for (var i = 0; i < list.length; i++) {

        var cardDiv = $("<div class='product-card' productId=" + list[i].id +"></div>");
        var nameDiv = $("<div class='product-name'>" + list[i].product_name + "</div>");
        var priceDiv = $("<div class='product-price'>"+ ￥ + list[i].price +"</div>");
        $(cardDiv).append(nameDiv);
        $(cardDiv).append(priceDiv);

        $("#product-panel").append(cardDiv);
    }
    $("#product-panel").children(".product-card").click(function () {
        window.location.href = "/product?id=" + $(this).attr("productId");
    });
}
