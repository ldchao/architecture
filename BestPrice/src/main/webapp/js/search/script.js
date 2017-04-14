
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

var DATA_TEMP;  // 用来缓存上一次过滤的结果

//过滤
function filter(index) {

    var conditions = ["Shield_NotJoin", "Shield_SalesLess", "Shield_CommentsLess"];
    var condition = conditions[index];

    var input = arguments[1];
    if (input.checked) {
        $.ajax({
            type: "POST",
            url: "/goods/shieldSearchResult",
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
    } else {
        setGoodsResult(DATA_TEMP);
    }

}

function sort(sortRule) {

    $.ajax({
        type: "POST",
        url: "/goods/sortSearchResult",
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
    getGoods( $("#js-search-input").val())
}

function getGoods(key){
    $.ajax({
        type:"POST",
        url:"/goods/searchGoods",
        data:{
            key: key
        },
        success: function (list) {
            DATA_TEMP = list;
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

        var cardDiv = $("<div class='product-card' onclick='gotoDetail(this)' productId=" + list[i].id +"></div>");
        var nameDiv = $("<div class='product-name'>" + list[i].product_name + "</div>");
        var priceDiv = $("<div class='product-price'>"+ "￥" + list[i].price +"</div>");
        $(cardDiv).append(nameDiv);
        $(cardDiv).append(priceDiv);

        $("#product-panel").append(cardDiv);
    }
    // $("#product-panel").children(".product-card").click(function () {
    //     window.location.href = "/product?id=" + $(this).attr("productId");
    // });
}

function gotoDetail(cardDiv) {

    var proId = $(cardDiv).attr("productId");
    window.location.href =  "/goods/showGoodsInfo?GoodId=" + proId;
}
