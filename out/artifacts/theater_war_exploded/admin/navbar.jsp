<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/11/29
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-md-2">
    <div style="margin-left: 13%"><a href="#" id="home" style="text-decoration: none;font-size: large;color:#9d9d9d;">&laquo;首页
    </a></div>
    <div class="panel-body" style="margin-top:8%">
        <ul class="list-group">
            <a href="${pageContext.request.contextPath}/admin?method=byPage&currPage=1" class="list-group-item" name="u" id="item1">员工管理</a>
            <a href="${pageContext.request.contextPath}/studio?method=findAll&currPage=1" class="list-group-item" id="item2">影厅管理</a>
            <a href="#" class="list-group-item" name="u" id="item3">影片管理</a>
            <a href="#" class="list-group-item" id="item4">座位管理</a>
            <a href="#" class="list-group-item" name="u" id="item5">售票管理</a>
            <a href="${pageContext.request.contextPath}/admin?method=manageLogin&currPage=1" class="list-group-item" name="u" id="item6">登录管理</a>
            <a href="${pageContext.request.contextPath}/user?method=logout" class="list-group-item">退出系统</a>
        </ul>
    </div>
</div>
<script>
    $(document).ready(function () {
        var role=${userlogin.role}
        if(role==0) {
         $("a[name=u]").hide();
        }
    });
</script>