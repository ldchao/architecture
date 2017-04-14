<%--
  Created by IntelliJ IDEA.
  User: lois
  Date: 2017/4/14
  Time: 下午1:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header">
    <div class="content">
        <a href="${pageContext.request.contextPath}/">
            <img src="${pageContext.request.contextPath}/logo.png">
        </a>
        <div class="search">
            <input class="input" id="js-search-input" type="text" placeholder="搜索商品...">
            <button class="btn-search" id="js-btn-search">搜索</button>
        </div>
        <%--<div class="shopping-cart">--%>
            <%--<button class="btn-cart" onclick="window.location.href='/shoppingCart'">--%>
                <%--<i class="fa fa-shopping-cart"></i> 购物车</button>--%>
            <%--<button class="btn-order" onclick="window.location.href='/user/order'">我的订单</button>--%>
        <%--</div>--%>
    </div>
</div>
