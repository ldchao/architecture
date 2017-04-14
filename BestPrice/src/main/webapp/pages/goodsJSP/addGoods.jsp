<%--
  Created by IntelliJ IDEA.
  User: LIUXUANLIN
  Date: 17/4/14
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
    <script type="text/javascript">
        function show()
        {

            alert("success!");

        }
    </script>
    <title>订单</title>
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
        <!-- /Logo -->

    </div>
    <!-- /Top -->

    <!-- Content -->
    <div id="content" >

        <!-- Profile -->

        <!-- /Profile -->

        <!-- Menu -->
        <div class="menu">
            <ul class="tabs">
                <li><a href="#contact" class="tab-contact">加入购物车</a></li>
            </ul>
        </div>
        <!-- /Menu -->

        <!-- Contact -->
        <div id="contact">
            <!-- Contact Info -->
            <div class="contact-info">
                <h3 class="main-heading"><span>温馨提示</span></h3>
                <ul>
                    <li>请输入购买数量 <br/><br/></li>
                </ul>
            </div>
            <!-- /Contact Info -->

            <!-- Contact Form -->
            <div class="contact-form">
                <h3 class="main-heading"><span>加入购物车</span></h3>
                <div id="contact-status"></div>
                <form action="/goods/addGoods" method="post" id="contactform">

                    <p>
                        <label>添加数量</label>
                        <input type="text" name="num" class="input">
                    </p>
                    <input type="submit" onclick="show()" name="submit" value="确认添加" class="submit">
                </form>
            </div>
            <!-- /Contact Form -->
        </div>
        <!-- /contact -->

    </div>
    <!-- /Content -->

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