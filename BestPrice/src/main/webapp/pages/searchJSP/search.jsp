<%--
  Created by IntelliJ IDEA.
  User: lois
  Date: 2017/4/14
  Time: 上午11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索</title>
<%@include file="../commonJSP/head.jsp"%>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/favicon.ico">
    <link rel="stylesheet" href="/css/search/normalize.css">
    <link rel="stylesheet" href="/css/search/font-awesome.min.css">
    <link rel="stylesheet" href="/css/search/style.css">
    <script src="/js/search/jquery-2.1.4.min.js"></script>
    <script src="/js/search/script.js"></script>
</head>

<body>

<%--<%@include file="../commonJSP/navbar.jsp"%>--%>
<%@include file="../commonJSP/header.jsp"%>

<%@include file="../commonJSP/searchHeader.jsp"%>

<div class="wrapper">

    <div class="content">
        <div class="product-panel" id="product-panel"></div>
    </div>

</div>

<div class="choice">
    <div class="sort">
        <button class="sortButton" onclick="sort('SortByBidding')">综合</button>
        <button class="sortButton" onclick="sort('SortBySalesVolume')">购买量</button>
        <button class="sortButton" onclick="sort('SortByCommentsVolume')">评论量</button>
        <button class="sortButton" onclick="sort('SortByPrice')">价格</button>
    </div>

    <%--<div class="filter">--%>
        <%--<button class="filterButton">未加盟</button>--%>
        <%--<button class="filterButton">购买过少</button>--%>
        <%--<button class="filterButton">评论过少</button>--%>
    <%--</div>--%>

    <div class="filter">
        <label><input name="filter" type="checkbox" onchange="filter('Shield_NotJoin')">未加盟</label>
        <label><input name="filter" type="checkbox" onchange="filter('Shield_SalesLess')">购买过少</label>
        <label><input name="filter" type="checkbox" onchange="filter('Shield_CommentsLess')">评论过少</label>
    </div>
</div>



<script>
    $(document).ready(function () {

        getGoods(key);
    });

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

    function sort(sortRule) {

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

</script>



</body>
</html>
