<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/12/17
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>座位管理</title>

    <%--<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <%--<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>--%>
    <%--<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>


</head>
<body>
<jsp:include page="/admin/head.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="/admin/navbar.jsp"></jsp:include>
        <div class="col-md-10">
            <h2 style="display: inline">座位管理
                <small>All seats</small>
            </h2>
            <div style="display: inline">
                <div style="display: inline;margin-left: 50%">
                    <img src="${pageContext.request.contextPath}/images/手指箭头-01-01.png " alt="-->">
                    <select class="form-control" style="width: 20%;display: inline; border-color: red;margin-left: 2%"
                            id="init">
                        <option disabled="disabled" selected="selected" >--请选择影厅--</option>
                    </select>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
<script>

    $(document).ready(function () {
        // $("td>input").attr("style", "width:160;border-left: 0px;border-top: 0px;border-right: 0px;border-bottom: 1px;");
        $("#item4").attr("class", "list-group-item active");

        $.post("${pageContext.request.contextPath}/seat?method=query", function (data) {
            $op = $("#init");
            $(data).each(function () {
                $op.append("<option id="+this.studio_id+">" + this.studio_name + "</option>");
            })
            console.log(data);
        }, "json");
    });
</script>
</html>
