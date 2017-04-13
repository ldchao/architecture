<%--
  Created by IntelliJ IDEA.
  User: marioquer
  Date: 2017/4/10
  Time: 下午4:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="commonJSP/head.jsp" %>
    <%--个性化的css文件统一放在上面include的文件末尾，方便后期合并--%>
</head>
<body>
<%--TODO:个性化的body主体--%>
<nav class="white" role="navigation">
    <div class="nav-wrapper container">
        <a id="logo-container" href="#" class="brand-logo blue-grey-text">爱比价网</a>
        <ul class="right hide-on-med-and-down">
            <li><a href="#login" class="teal-text">登录</a></li>
            <li><a href="#logup" class="teal-text">注册</a></li>
        </ul>
        <ul id="nav-mobile" class="side-nav">
            <li><a href="#login">登录</a></li>
            <li><a href="#logup">注册</a></li>
        </ul>
        <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
</nav>

<div id="index-banner" class="parallax-container" style="height: 100%;">
    <div class="container">
        <br><br>
        <h1 class="header center white-text">爱比价网</h1>
        <div class="row center">
        <h5 class="header col s12 light white-text">最便宜的都在这</h5>
        </div>
        <div class="row center">
            <a href="#login" id="download-button"
               class="btn-large waves-effect waves-light white lighten-1 teal-text">立即体验</a>
        </div>
        <br><br>

    </div>
    <div class="parallax"><img class="background" src="/img/1.jpg">
    </div>
</div>

<!-- Login Modal -->
<div id="login" class="modal" style="width: 360px">
    <div class="modal-content">
        <h4 class="center-align">登 录</h4>
        <div class="row">
            <div class="input-field col s12">
                <input id="username" type="text" class="validate">
                <label for="username">用户名</label>
            </div>
            <div class="input-field col s12">
                <input id="password" type="password" class="validate">
                <label for="password">密码</label>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <a onclick="login()" href="#!" class=" modal-action waves-effect waves-teal btn-flat teal-text">确认</a>
        <a onclick="trans(0)" href="#!" class=" modal-action waves-effect waves-orange btn-flat orange-text">注册</a>
        <a href="#!" class=" modal-action modal-close waves-effect waves-grey btn-flat">取消</a>
    </div>
</div>

<!-- Logup Modal -->
<div id="logup" class="modal" style="width: 360px; overflow: visible;">
    <div class="modal-content">
        <h4 class="center-align teal-text">注 册</h4>
        <div class="row">
            <div class="input-field col s12">
                <input placeholder="请输入手机号码" id="new_username" type="text" class="validate">
                <label for="new_username">用户名</label>
            </div>
            <div class="input-field col s12">
                <input placeholder="不超过20位字母或数字" id="new_password" type="password" class="validate">
                <label for="new_password">密码</label>
            </div>
            <div class="input-field col s12">
                <input placeholder="输入您的邮箱" id="new_email" type="text" class="validate">
                <label for="new_email">邮箱</label>
            </div>
            <div class="input-field col s12">
                <input placeholder="输入您的主配送地址" id="new_address" type="text" class="validate">
                <label for="new_address">地址</label>
            </div>
            <%--<div class="input-field col s12">--%>
            <%--<select id="new_role">--%>
            <%--<option value="" disabled selected>选择你的目的</option>--%>
            <%--<option value="0">订房</option>--%>
            <%--<option value="1">开客栈</option>--%>
            <%--<option value="2">总经理</option>--%>
            <%--</select>--%>
            <%--<label>目的</label>--%>
            <%--</div>--%>
        </div>
    </div>
    <div class="modal-footer">
        <a onclick="logup()" href="#!" class=" modal-action waves-effect waves-teal btn-flat teal-text">确认</a>
        <a onclick="trans(1)" href="#!" class=" modal-action waves-effect waves-orange btn-flat orange-text">登录</a>
        <a href="#!" class=" modal-action modal-close waves-effect waves-grey btn-flat">取消</a>
    </div>
</div>

<%@include file="commonJSP/script.jsp" %>
<%--个性化的script文件统一放在上面include的文件末尾，方便后期合并--%>
</body>
</html>
