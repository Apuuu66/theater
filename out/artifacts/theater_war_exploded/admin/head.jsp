<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/11/29
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<nav class="navbar navbar-default" style="background-image:url(${pageContext.request.contextPath}/images/bg.jpg)">--%>
<%--<div class="container-fluid">--%>
<%--<!-- Brand and toggle get grouped for better mobile display -->--%>
<%--<div class="navbar-header" style="margin-left: 42%">--%>

<%--<li class="navbar-brand list-unstyled" href="#" style="font-size:30px;color: antiquewhite;font-family:幼圆" >影院管理中心</li>--%>
<%--</div>--%>
<%--<img src="${pageContext.request.contextPath}/images/user.jpg" alt="" class=" radius-circle rotate rotate-hover">--%>
<%--<style>--%>
<%--.radius-circle {--%>
<%--border-radius: 50%;--%>
<%--}--%>
<%--.rotate, .rotate-hover:hover {--%>
<%---webkit-animation-name: a-rotate;--%>
<%---moz-animation-name: a-rotate;--%>
<%---ms-animation-name: a-rotate;--%>
<%--animation-name: a-rotate;--%>
<%--}--%>
<%--.rotate, .rotate-hover {--%>
<%---webkit-animation: 2s infinite linear;--%>
<%---moz-animation: 2s infinite linear;--%>
<%---ms-animation: 2s infinite linear;--%>
<%--animation: 2s infinite linear;--%>
<%--}--%>
<%--</style>--%>
<%--</div>--%>

<%--</nav>--%>

<%--<style>*{margin:0;}</style>--%>

<%--1--%>
<%--<div style="height:60px;width: 100%; background-image: url(${pageContext.request.contextPath}/images/bg.jpg); margin-top:-20px;--%>
<%--color:white;text-align: center; margin-bottom: 20px;">--%>
<%--<h1 style="line-height: 60px;">后台管理中心</h1>--%>
<%--</div>--%>


<%--<div class="dropdown">--%>
<%--<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">--%>
<%--Dropdown--%>
<%--<span class="caret"></span>--%>
<%--</button>--%>
<%--<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">--%>
<%--<li><a href="#">Action</a></li>--%>
<%--<li><a href="#">Another action</a></li>--%>
<%--<li><a href="#">Something else here</a></li>--%>
<%--<li role="separator" class="divider"></li>--%>
<%--<li><a href="#">Separated link</a></li>--%>
<%--</ul>--%>
<%--</div>--%>


<div style="background-image: url(${pageContext.request.contextPath}/images/bg.jpg); height: 50px; margin-bottom:20px;">
    <div style="display: inline-block; font-size: 25px; color:white; width: 90%;text-align: center;">
        <span style="line-height: 50px; ">后台管理中心</span>
    </div>
    <div class="dropdown" style="display: inline-block; float:right; margin-right:10px; margin-top:9px;">
        <a href="#"><img src="${pageContext.request.contextPath}/${user.head_path}" alt="未登录"
                         style="display:inline-block;float:right;width: 35px;height: 35px;
                          margin-right:40px; border-radius: 5px;">
        </a>
    </div>
</div>