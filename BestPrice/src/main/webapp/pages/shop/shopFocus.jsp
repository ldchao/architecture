<%@ page import="vo.UserVO" %>
<%@ page import="Entity.Comment" %>
<%@ page import="java.util.ArrayList" %>
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
            <div class="nav-wrapper"><a class="page-title">所有评论</a></div>
        </div>
    </nav>

    <ul id="slide-out" class="side-nav fixed">
        <li>
            <div class="userView">
                <div class="background">
                    <img src="/img/background.jpg">
                </div>
                <a href="#!user"><img class="circle" src="/img/mario.jpg"></a>
                <a href="#!name" style="height: 60px; font-size: 30px;"><span class="white-text name">${sessionScope.get("user").getName()}</span></a>
            </div>
        </li>
        <li class="margin-top-10"><a href="/commentManage" class="waves-effect"><i class="material-icons">business</i>关注信息的评论</a></li>
        <li><a class="waves-effect" href="/adsManage"><i class="material-icons">shopping_cart</i>关注信息的词汇</a></li>
        <%--<li><a class="waves-effect" href="/user/statistics"><i class="material-icons">assessment</i>统计明细</a></li>--%>
        <li>
            <div class="divider"></div>
        </li>
        <li class="margin-top-10"><a class="waves-effect" href="javascript:logout()"><i class="material-icons">open_in_browser</i>退出登录</a></li>
    </ul>

</header>

<main>
    <div class="container" style="min-height: 500px;">
        <table class="highlight">
            <thead>
            <tr>
                <th>id</th>
                <th>评论内容</th>
                <th>时间</th>
                <th>删除</th>
                <th>发布</th>
            </tr>
            </thead>
            <tbody id="record_container">
            <%--<%--%>
                <%--ArrayList<Comment> comments = (ArrayList<Comment>) request.getAttribute("senComments");--%>
                <%--for (int i = 0; i < comments.size(); i++) {--%>
            <%--%>--%>
            <%--<tr class="">--%>
                <%--<td class="id"><%=comments.get(i).getId()%></td>--%>
                <%--<td class="content"><%=comments.get(i).getContent()%></td>--%>
                <%--<td class="productId none"><%=comments.get(i).getProductid()%></td>--%>
                <%--<td class="userId none"><%=comments.get(i).getUserid()%></td>--%>
                <%--<td class="replyId none"><%=comments.get(i).getReplyid()%></td>--%>
                <%--<td class="time"><%=comments.get(i).getTime()%></td>--%>
                <%--<td><a class="btn teal" onclick="cancel(this)">删除</a></td>--%>
                <%--<td><a class="btn teal" onclick="publish(this)">发布</a></td>--%>
            <%--</tr>--%>
            <%--<%--%>
                <%--}--%>
            <%--%>--%>
            </tbody>
        </table>
    </div>
</main>
<%@include file="../commonJSP/script.jsp" %>
<script>
    function cancel(obj){
        var id = obj.parentNode.parentNode.getElementsByClassName("id")[0].innerHTML;
        $.ajax({
            method: "post",
            url: "/comment/comment/delete",
            async: false,
            data: {
                "comId": id
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

    function publish(obj){
        var parent = obj.parentNode.parentNode;
        var content = parent.getElementsByClassName("content")[0].innerHTML;
        var productId = parent.getElementsByClassName("productId")[0].innerHTML;
        var userId = parent.getElementsByClassName("userId")[0].innerHTML;
        var replyId = parent.getElementsByClassName("replyId")[0].innerHTML;

        $.ajax({
            method: "post",
            url: "/comment/comment/publish",
            async: false,
            data: {
                "content": content,
                "productid": productId,
                "userid": userId,
                "replyid": replyId
            },
            success: function (result) {
                if (result == "success") {
                    Materialize.toast('操作成功!', 1800);
                    setInterval((function () {
                        window.location.reload();
                    }()), 1800);
                }else{
                    Materialize.toast('操作失败!', 1800);
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
