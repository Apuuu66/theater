<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/12/1
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>员工管理</title>

    <%--<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <%--<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>--%>
    <%--<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="navbar.jsp"></jsp:include>
        <div class="col-md-10">
            <div style="margin-top: -2%">

                <form class="form-inline" action="#" method="post">
                    <h2 style="display: inline-block">查询结果
                        <small>All results</small>
                    </h2>
                    <div class="form-group" style="margin-left:49%">
                        <input type="text" class="form-control" placeholder="Search" id="condition">
                    </div>
                    <button type="button" name="query" class="btn btn-primary">查询</button>
                    <button type="button" name="add" class="btn btn-warning">添加</button>
                </form>
            </div>
            <div class="table-responsive">
                <c:if test="${empty pb.list}">
                    <div style="margin-left: 35%"><label><h1 style="color: #761c19">无查询结果</h1></label></div>
                </c:if>
                <table class="table table-bordered table-hover">
                    <c:if test="${not empty pb.list}">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>编号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>电话</th>
                        <th>地址</th>
                        <th>邮箱</th>
                        <th style="text-align: center">操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${pb.list}" var="emp">
                        <tr>
                            <td>${emp.emp_id}</td>
                            <td>${emp.emp_no}</td>
                            <td>${emp.emp_name}</td>
                            <td>${emp.emp_sex}</td>
                            <td>${emp.emp_tel_num}</td>
                            <td>${emp.emp_addr}</td>
                            <td>${emp.emp_email}</td>
                            <td style="text-align: center">
                                <button class="btn btn-info btn-sm" name="1" id="${emp.emp_id}">修改</button>
                                <button class="btn btn-danger btn-sm" name="2" id="${emp.emp_id}">删除</button>
                            </td>
                        </tr>
                    </c:forEach>
                    </c:if>
                    </tbody>
                </table>

                <%--分页--%>
                <c:if test="${pb.totalCount>6}">
                    <c:if test="${not empty pb.list}">
                        <ul class="pagination" style="margin-left:25%">
                                <%--//判断是否为第一页--%>
                            <c:if test="${pb.currPage == 1}">
                                <li class="disabled"><a href="javascript:void(0);" aria-label="Previous"><span
                                        aria-hidden="true">&laquo;</span></a></li>
                            </c:if>
                            <c:if test="${pb.currPage != 1}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin?method=getEmps&condition=${param.condition}&currPage=${pb.currPage-1}"
                                       aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
                            </c:if>
                            <c:forEach begin="${pb.currPage-2>0?pb.currPage-2:1}"
                                       end="${pb.currPage+2>pb.totalPage?pb.totalPage:pb.currPage+2}" var="n">
                                <c:if test="${pb.currPage == n}">
                                    <li class="active"><a href="javascript:void(0);">${n}</a></li>
                                </c:if>
                                <c:if test="${pb.currPage != n}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/admin?method=getEmps&condition=${param.condition}&currPage=${n}">${n}</a>
                                    </li>
                                </c:if>
                            </c:forEach>


                                <%--//判断是否为最后一页--%>
                            <c:if test="${pb.currPage == pb.totalPage}">
                                <li class="disabled"><a href="javascript:void(0);" aria-label="Previous"><span
                                        aria-hidden="true">&raquo;</span></a></li>
                            </c:if>
                            <c:if test="${pb.currPage != pb.totalPage}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin?method=getEmps&condition=${param.condition}&currPage=${pb.currPage+1}"
                                       aria-label="Previous"><span aria-hidden="true">&raquo;</span></a></li>
                            </c:if>
                        </ul>
                    </c:if>
                </c:if>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    $(document).ready(function () {
        $("button[name=1]").click(function () {
            location.href = "${pageContext.request.contextPath}/admin?method=getEmp&emp_id=" + this.id + "&currPage=" + "${param.currPage}";
        });
    });
    $(document).ready(function () {
        $("button[name=2]").click(function () {
            if (confirm("确认删除吗？")) {
                location.href = "${pageContext.request.contextPath}/admin?method=delEmp&emp_id=" + this.id + "&currPage=" + "${param.currPage}";
            }
        });
    });
    $(document).ready(function () {
        $("button[name=query]").click(function () {
            console.log($("#condition").val());
            location.href = "${pageContext.request.contextPath}/admin?method=getEmps&condition=" + $("#condition").val() + "&currPage=1";
        });
    });
    $(document).ready(function () {
        $("button[name=add]").click(function () {
            location.href = "${pageContext.request.contextPath}/admin/add.jsp";
        });
    });
    $(document).ready(function () {
        $("#item1").attr("class","list-group-item active");
    });
</script>
</html>
