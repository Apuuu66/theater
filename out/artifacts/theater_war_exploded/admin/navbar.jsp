<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/11/29
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-md-2">
    <%--<ul class="list-group">--%>
        <%--<li class="list-group-item list-group-item-info">导航</li>--%>
        <%--<a href="${pageContext.request.contextPath}/emp?method=byPage&currPage=1" class="list-group-item active">员工管理</a>--%>
        <%--<a href="#" class="list-group-item">影厅管理</a>--%>
        <%--<a href="#" class="list-group-item">影片管理</a>--%>
        <%--<a href="#" class="list-group-item">座位管理</a>--%>
        <%--<a href="#" class="list-group-item">售票管理</a>--%>
        <%--<a href="#" class="list-group-item">登录管理</a>--%>
        <%--<a href="#" class="list-group-item">退出系统</a>--%>
    <%--</ul>--%>


        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">导航</h3>
            </div>
            <div class="panel-body">
                <ul class="list-group">
                <a href="${pageContext.request.contextPath}/emp?method=byPage&currPage=1" class="list-group-item">员工管理</a>
                <a href="#" class="list-group-item">影厅管理</a>
                <a href="#" class="list-group-item">影片管理</a>
                <a href="#" class="list-group-item">座位管理</a>
                <a href="#" class="list-group-item">售票管理</a>
                <a href="#" class="list-group-item">登录管理</a>
                <a href="#" class="list-group-item">退出系统</a>
                </ul>
            </div>
        </div>

</div>