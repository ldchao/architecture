<%@ page import="vo.UserVO" %>
<%@ page import="Entity.Comment" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Entity.ADs" %>
<%@ page isELIgnored="false" %>

<%--
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
                <th>类型</th>
                <th>目标链接</th>
                <th>图片链接</th>
                <th>开始时间</th>
            </tr>
            </thead>
            <tbody id="record_container">
            <%
                ArrayList<ADs> ads = (ArrayList<ADs>) request.getAttribute("ads");
                for (int i = 0; i < ads.size(); i++) {
            %>
            <tr class="">
                <td class="id"><%=ads.get(i).getId()%></td>
                <td class="type"><%=ads.get(i).getType()%></td>
                <td class="targetlink"><%=ads.get(i).getTargetlink()%></td>
                <td class="piclink"><%=ads.get(i).getPiclink()%></td>
                <td class="starttime"><%=ads.get(i).getStarttime()%></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</main>
<%@include file="../commonJSP/script.jsp" %>
<script>
</script>
</body>
</html>
