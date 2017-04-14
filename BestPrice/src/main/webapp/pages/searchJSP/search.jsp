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
        <button class="sortButton">综合</button>
        <button class="sortButton">购买量</button>
        <button class="sortButton">评论量</button>
        <button class="sortButton">价格</button>
    </div>

    <%--<div class="filter">--%>
        <%--<button class="filterButton">未加盟</button>--%>
        <%--<button class="filterButton">购买过少</button>--%>
        <%--<button class="filterButton">评论过少</button>--%>
    <%--</div>--%>

</div>



<script>
    $(document).ready(function () {

        getGoods(key);
        searchInit();
    });

    function getGoods(key){
        $.ajax({
            type:"GET",
            url:"/search",
            data:{
                key: key
            },
            success: function (data) {
                console.log(data);
                $("#product-panel").empty();
                var list = data.list;
                for (var i = 0; i < list.length; i++) {
                    var html =
                        '<div class="product-card" productId="' + list[i].id + '">' +
                        '<img src="' + list[i].imgPath + '" class="product-img">' +
                        '<div class="product-name">' + list[i].name + '</div>' +
                        '<div class="product-price">￥' + list[i].minPrice + '</div>' +
                        '</div>';
                    $("#product-panel").append(html);
                }
                $("#product-panel").children(".product-card").click(function () {
                    window.location.href = "/product?id=" + $(this).attr("productId");
                });

            },
            error: function () {
                toaster("服务器出现问题，请稍微再试！", "error");
            }
        });
    }


    function searchInit() {
        $("#js-btn-search").click(function () {
            getGoods( $("#js-search-input").val())
        });
    }

</script>



</body>
</html>
