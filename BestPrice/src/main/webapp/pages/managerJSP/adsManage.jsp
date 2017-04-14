<%@ page import="vo.UserVO" %><%--
  Created by IntelliJ IDEA.
  User: marioquer
  Date: 2017/4/14
  Time: 下午12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="../commonJSP/head.jsp" %>
</head>

<%  HttpSession se = request.getSession();
    UserVO userVO = (UserVO)se.getAttribute("user");
    System.out.println(userVO.getName());
%>


<body>
<header>
    <nav class="top-nav teal">
        <div class="container">
            <div class="nav-wrapper"><a class="page-title">所有广告</a></div>
        </div>
    </nav>

    <%@ include file="../commonJSP/managerNav.jsp" %>

</header>


<main>
    <div class="container" style="min-height: 500px;">
        <table class="highlight">
            <thead>
            <tr>
                <th>id</th>
                <th></th>
                <th>房间类型</th>
                <%--<th>数目</th>--%>
                <th>预定时间</th>
                <th>总价</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="record_container">
            <tr class="none" id="record_pattern">
                <td class="record_id">1</td>
                <td class="hotel_id none">老王客栈很长的</td>
                <td class="hotel_name">老王客栈很长的</td>
                <td class="room_style">单人房</td>
                <%--<td class="days">2</td>--%>
                <td class="book_time">2016-10-11 10:00:00</td>
                <td class="amount">400</td>
                <td class="status">已预定</td>
                <td><a class="btn teal" onclick="cancel(this)">退订</a></td>
            </tr>
            </tbody>
        </table>
    </div>
</main>
<%@include file="../commonJSP/script.jsp" %>
</body>
</html>
