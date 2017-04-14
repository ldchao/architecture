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
</head>

<body>

<%@include file="../commonJSP/header.jsp"%>
<div class="content">

    <div class="search">
        <input class="input" id="js-search-input" type="text" placeholder="搜索商品...">
        <button class="btn-search" id="js-btn-search" onclick="searchInit(this)">搜索</button>
    </div>
</div>

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

    <div class="filter">
        <input name="filter" type="checkbox" onchange="filter('Shield_NotJoin')" id="checkbox1"><label for="checkbox1">未加盟</label>
        <input name="filter" type="checkbox" onchange="filter('Shield_SalesLess')" id="checkbox2"><label for="checkbox2">购买过少</label>
        <input name="filter" type="checkbox" onchange="filter('Shield_CommentsLess')" id="checkbox3"><label for="checkbox3">评论过少</label>
    </div>
</div>

<script src="../../js/search/jquery-2.1.4.min.js" type="text/javascript"></script>
<script src="../../js/search/script.js" type="text/javascript"></script>
</body>
</html>
