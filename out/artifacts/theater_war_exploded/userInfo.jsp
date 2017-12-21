<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/12/20
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>

    <%--<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <%--<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>--%>
    <%--<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fileinput.min.css">
    <script src="${pageContext.request.contextPath}/js/fileinput.min.js"></script>
</head>
<body>
<jsp:include page="/admin/head.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="/admin/navbar.jsp"></jsp:include>
        <div class="col-md-10">
            <%--${userlogin.emp_no}--%>
            <%--<form action="www.baidu.com" method="post" enctype="multipart/form-data">--%>
            <%--<div class="file-loading">--%>
            <%--<input id="file-0c" class="file" type="file" multiple data-min-file-count="1">--%>
            <%--</div>--%>
            <%--</form>--%>
            <div class="row">
                <div class="col-md-8">

                    <div class="page-header">
                        <h3 style="text-align: center"> 个人中心</h3>
                    </div>

                    <form class="form-horizontal" role="form" style="text-align: center" action="${pageContext.request.contextPath}/user?method=replace" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="name" value="${userlogin.emp.emp_name}"
                                       readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="no" class="col-sm-2 control-label">编号</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="no" value="${userlogin.emp_no}" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="role" class="col-sm-2 control-label">身份</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="role" value="${userlogin.role}" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">头像</label>
                            <div class="col-sm-9">
                                <%--<input type="text" class="form-control" id="head" value="${userlogin.role}" readonly>--%>
                                <img class="img-rounded img-responsive" style="width: 22%"
                                     src="${pageContext.request.contextPath}${userlogin.head_path}" alt="头像">
                            </div>

                            <a class="btn btn-hollow" style="border: 1px solid rgba(59,194,29,.7);color: #42c02e!important;border-radius: 25px;margin-top: -10%">
                                <input unselectable="on" type="file" style="position: absolute;display: block!important;width: 82px;opacity: 0;" name="part">
                                更改头像
                            </a>

                        </div>

                        <div class="form-group">
                            <label for="sex" class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="sex" value="${userlogin.emp.emp_sex}"
                                       readonly>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="tel" class="col-sm-2 control-label">电话</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="tel" value="${userlogin.emp.emp_tel_num}"
                                       readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-sm-2 control-label">邮箱</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="email" value="${userlogin.emp.emp_email}"
                                       readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="address" class="col-sm-2 control-label">地址</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="address" value="${userlogin.emp.emp_addr}"
                                       readonly>
                            </div>
                        </div>

                    </form>
                </div>
                <div class="col-md-4"></div>

            </div>


        </div>
    </div>
</div>
</body>
<script>
    $(document).ready(function () {
        if ($("#role").attr("value") == 1) {
            $("#role").attr("value", "管理员");
        } else
            $("#role").attr("value", "员工");


        $("input").change(function(){
          $("form")[0].submit();
        });
    })
</script>
</html>
