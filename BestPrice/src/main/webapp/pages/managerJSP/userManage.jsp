<%@ page import="vo.UserVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Entity.User" %>
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
            <div class="nav-wrapper"><a class="page-title">所有用户</a></div>
        </div>
    </nav>

    <%@ include file="../commonJSP/managerNav.jsp" %>

</header>

<main>
    <div class="container" style="min-height: 500px;">
        <table class="highlight">
            <thead>
            <tr>
                <th>用户id</th>
                <th>用户名</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="record_container">
            <%
                ArrayList<User> users = (ArrayList<User>) request.getAttribute("waterUser");
                for (int i = 0; i < users.size(); i++) {
            %>
            <tr class="">
                <td class="id"><%=users.get(i).getUserid()%></td>
                <td class="name"><%=users.get(i).getName()%></td>
                <td class="email"><%=users.get(i).getEmail()%></td>
                <td><a class="btn teal" onclick="freeze(this)">冻结</a></td>
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
    function freeze(obj){
        var id = obj.parentNode.parentNode.getElementsByClassName("id")[0].innerHTML;
        $.ajax({
            method: "post",
            url: "/user/freezeUser",
            async: false,
            data: {
                "userId": id
            },
            success: function (result) {
                if (result == "success") {
                    Materialize.toast('操作成功!', 1800);
                    setInterval((function () {
                        window.location.reload();
                    }()), 1800);
                }
            },
            error: function () {
                Materialize.toast('请求出错!', 1200);
            }
        });
    }
</script>
</body>
</html>
