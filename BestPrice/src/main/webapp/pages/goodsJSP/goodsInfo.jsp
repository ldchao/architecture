<%--
  Created by IntelliJ IDEA.
  User: LIUXUANLIN
  Date: 17/4/13
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <title>商品信息</title>
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

        <!-- Menu -->
        <div class="menu">
            <ul class="tabs">
                <li><a href="#profile" class="tab-profile">商品信息</a></li>
                <li><a href="#resume" class="tab-resume">商品评价</a></li>
                <li><a href="#contact" class="tab-contact">发表评价</a></li>
            </ul>
        </div>
        <!-- /Menu -->

        <!-- Profile -->
        <div id="profile">
            <!-- About section -->
            <div class="about">
                <%
                    String goodid = (String)request.getServletContext().getAttribute("goodid");
                    String price = (String)request.getServletContext().getAttribute("price");
                    String description = (String)request.getServletContext().getAttribute("description");
                    String product_name = (String)request.getServletContext().getAttribute("product_name");
                    String seller_name = (String)request.getServletContext().getAttribute("seller_name");
                    String platform = (String)request.getServletContext().getAttribute("platform");
                    String isJoin = (String)request.getServletContext().getAttribute("isJoin");
                    String sales_volume=(String)request.getServletContext().getAttribute("sales_volume");
                    String comments_volume=(String)request.getServletContext().getAttribute("comments_volume");

                %>
                <div class="photo-inner"><img src="/img/shop.jsp" height="180" width="180" /></div>

            </div>
            <!-- /About section -->

            <!-- Personal info section -->
            <ul class="personal-info">
                <li><label>商品id</label><span><%=goodid%> </span></li>
                <li><label>商品名称</label><span><%=product_name%></span></li>
                <li><label>价格</label><span><%=price%> </span></li>
                <li><label>商品类型</label><span><%=description%></span></li>
                <li><label>出售商家</label><span><%=seller_name%></span></li>
                <li><label>平台</label><span><%=platform%></span></li>
                <li><label>是否加入平台</label><span><%=isJoin%></span></li>
                <li><label>销售数量</label><span><%=sales_volume%></span></li>
                <li><label>评论数量</label><span><%=comments_volume%></span></li>
                <a href=""class="button gray medium" style="float:right;">去购买</a>
            </ul>
            <!-- /Personal info section -->
        </div>
        <!-- /Profile -->

        <!-- Resume -->
        <div id="resume">
            <div class="timeline-section">
                <!-- Timeline for Employment  -->
                <h3 class="main-heading"><span>商品评价</span></h3>
                <ul class="timeline">
                    <%

                        String[] comment_UsersId= (String[])request.getServletContext().getAttribute("comment_UsersId");
                        String[] comment_date= (String[])request.getServletContext().getAttribute("comment_date");
                        String[] comment_content= (String[])request.getServletContext().getAttribute("comment_content");
                        int num_comment= (Integer)request.getServletContext().getAttribute("num_comment");
                        for(int i = 0;i<num_comment;i++){
                    %>
                    <li>
                        <div class="timelineUnit">
                            <h4>客户id：<span><%=comment_UsersId[i]%></span></h4>
                            <h4>商品评价：<span class="timelineDate"><%=comment_date[i] %></span></h4>
                            <h5><%=comment_content[i] %></h5>
                            <!--  <h4><a href=""><span>回复</span></a></h4>-->
                        </div>
                    </li>
                    <%
                        }
                    %>
                    <div class="clear"></div>
                </ul>
                <!-- /Timeline for Employment  -->

                <!-- Timeline for Education  -->
                <h3 class="main-heading"><span>购买记录</span></h3>
                <ul class="timeline">
                    <%
                        String[] buy_UserId = (String[])request.getServletContext().getAttribute("buy_UserId");
                        String[] buy_date= (String[])request.getServletContext().getAttribute("buy_date");
                        String[] buy_price = (String[])request.getServletContext().getAttribute("buy_price");
                        String[] buy_num= (String[])request.getServletContext().getAttribute("buy_num");
                        int num_buy = (Integer)request.getServletContext().getAttribute("num_buy");
                        for(int i = 0;i<num_buy ;i++){
                    %>
                    <li>
                        <div class="timelineUnit">
                            <h4>购买客户id：<span><%=buy_UserId[i]%></span></h4>
                            <h4>数量：<span><%=buy_num[i]%></span></h4>
                            <h4>价格：<span class="timelineDate"><%=buy_date[i] %></span></h4>
                            <h5><%=buy_price [i] %></h5>
                        </div>
                    </li>
                    <%
                        }
                    %>
                    <div class="clear"></div>
                </ul>
            </div>
        </div>
        <!-- /Resume -->
        <!-- Contact -->
        <div id="contact">
            <!-- Contact Info -->
            <div class="contact-info">
                <h3 class="main-heading"><span>温馨提示</span></h3>
                <ul>
                    <li>请注意评论规范 <br/><br/></li>
                    <li>文明用语 <br/><br/></li>
                </ul>
            </div>
            <!-- /Contact Info -->

            <!-- Contact Form -->
            <div class="contact-form">
                <h3 class="main-heading"><span>发表评论</span></h3>
                <div id="contact-status"></div>
                <form action="/comment/makeComment" method="post" id="contactform">
                    <p>
                        <label>评论内容</label>
                        <input type="text" name="content" class="input">
                    </p>
                    <input type="submit" name="submit" value="确认评论" class="submit">
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