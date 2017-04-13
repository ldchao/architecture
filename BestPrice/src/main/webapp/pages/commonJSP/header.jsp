<%--
  Created by IntelliJ IDEA.
  User: marioquer
  Date: 2017/4/10
  Time: 下午4:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" language="java" %>
<nav class="white" role="navigation">
    <div class="nav-wrapper container">
        <a id="logo-container" href="#" class="brand-logo blue-grey-text">爱比价网</a>
        <ul class="right hide-on-med-and-down">
            <li><a href="javascript:logout(${sessionScope.get("user").getUserId()})" class="teal-text">登出</a></li>
        </ul>
        <ul id="nav-mobile" class="side-nav">
            <li><a href="javascript:logout(${sessionScope.get("user").getUserId()})">登出</a></li>
        </ul>
        <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
</nav>


