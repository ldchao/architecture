<%--
  Created by IntelliJ IDEA.
  User: LIUXUANLIN
  Date: 17/4/14
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
    <title>购物车</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="../../css/goods/reset.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/goods/style2.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/goods/fancybox.css"/>
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Open+Sans:400,600,300,800,700,400italic|PT+Serif:400,400italic"/>
    <script type="text/javascript" src="../../js/goods/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/goods/jquery.easytabs.min.js"></script>
    <script type="text/javascript" src="../../js/goods/respond.min.js"></script>
    <script type="text/javascript" src="../../js/goods/jquery.easytabs.min.js"></script>
    <script type="text/javascript" src="../../js/goods/jquery.adipoli.min.js"></script>
    <script type="text/javascript" src="../../js/goods/jquery.fancybox-1.3.4.pack.js"></script>
    <script type="text/javascript" src="../../js/goods/jquery.isotope.min.js"></script>
    <script type="text/javascript" src="../../js/goods/jquery.gmap.min.js"></script>
    <script type="text/javascript" src="../../js/goods/custom.js"></script>
    <style>


    </style>
</head>
<body>
<!-- Container -->
<div id="container">

    <!-- Top -->
    <div class="top">
        <!-- Logo -->
        <div id="logo">
            <a href="index.jsp"><img src="../images/logo.png" alt="" /></a>
        </div>
        <!-- /Logo -->

    </div>
    <!-- /Top -->

    <!-- Content -->
    <div id="content" >

        <!-- Menu -->
        <div class="menu">
            <ul class="tabs">
                <li><a href="#profile" class="tab-profile">购物车信息</a></li>

            </ul>
        </div>
        <!-- /Menu -->
        <!-- Profile -->
        <div id="profile">
            <!-- About section -->
            <div class="about">
                <%

                    String account = (String)request.getServletContext().getAttribute("account");
                    String tel = (String)request.getServletContext().getAttribute("tel");


                %>
                <div class="photo-inner"><img src="../images/shop.jpg" height="180" width="180" /></div>

            </div>
            <!-- /About section -->

            <!-- Personal info section -->
            <ul class="personal-info">
                <li><label>用户id</label><span><%=tel %></span></li>
                <li><label>价格</label><span><%=account %></span></li>
                <a href=""class="button gray medium" style="float:right;">去付款</a>

            </ul>
            <!-- /Personal info section -->
        </div>
        <!-- /Profile -->




    </div>
    <!-- /contact -->



    <!-- Footer -->
    <div class="footer">
        <div class="copyright">Copyright &copy; 2017.  &nbsp; &nbsp; &nbsp; LiuXuanlin____QAQ  &nbsp; &nbsp; &nbsp;All rights reserved.</div>
    </div>
    <!-- /Footer -->

</div>
<!-- /Container -->

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>