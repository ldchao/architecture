<%--
  Created by IntelliJ IDEA.
  User: marioquer
  Date: 2017/4/14
  Time: 下午2:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<ul id="slide-out" class="side-nav fixed">
    <li>
        <div class="userView">
            <div class="background">
                <img src="/img/background.jpg">
            </div>
            <a href="#!user"><img class="circle" src="/img/mario.jpg"></a>
            <a href="#!name" style="height: 60px; font-size: 30px;"><span class="white-text name"><%=userVO.getName()%></span></a>
        </div>
    </li>
    <li class="margin-top-10"><a href="/commentManage" class="waves-effect"><i class="material-icons">business</i>评论管理</a></li>
    <li><a class="waves-effect" href="/adsManage"><i class="material-icons">shopping_cart</i>广告管理</a></li>
    <li><a class="waves-effect" href="/userManage"><i class="material-icons">person_pin</i>用户管理</a></li>
    <%--<li><a class="waves-effect" href="/user/statistics"><i class="material-icons">assessment</i>统计明细</a></li>--%>
    <li>
        <div class="divider"></div>
    </li>
    <li class="margin-top-10"><a class="waves-effect" href="javascript:logout()"><i class="material-icons">open_in_browser</i>退出登录</a></li>
</ul>
<a href="#" data-activates="slide-out" class="hide-on-large-only button-collapse"><i class="material-icons">menu</i></a>
