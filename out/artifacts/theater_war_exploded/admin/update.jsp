<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/11/30
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改员工信息</title>

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
            <h2 style="display: inline-block">基本信息 </h2>
            <form class="form-horizontal" role="form"
                  action="${pageContext.request.contextPath}/emp?method=update&page=${param.currPage}" method="post">
                <div class="form-group">
                    <label for="emp_id" class="col-sm-1 control-label">ID</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="emp_id" name="emp_id" readonly
                               value="${emp.emp_id}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="emp_no" class="col-sm-1 control-label">编号</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="emp_no" name="emp_no" value="${emp.emp_no}"
                               readonly>
                    </div>
                </div>
                <div class="form-group">
                    <label for="emp_name" class="col-sm-1 control-label">姓名</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="emp_name" name="emp_name" value="${emp.emp_name}"
                               required onblur="checkEmpName()">
                    </div>
                    <p id="emp_name_tip" class="control-label" style="color:red"></p>
                </div>
                <div class="form-group">
                    <%--@declare id="emp_sex"--%><label for="emp_sex" class="col-sm-1 control-label">性别</label>
                    <div class="col-sm-5">
                        <%--<input type="text" class="form-control" id="emp_sex" value="${emp.emp_sex}">--%>
                        男 &nbsp;<input type="radio" class="radio-inline" name="emp_sex" value="男">
                        女<input type="radio" class="radio-inline" name="emp_sex" value="女">
                    </div>
                </div>
                <div class="form-group">
                    <label for="emp_tel_num" class="col-sm-1 control-label">电话</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="emp_tel_num" name="emp_tel_num" required
                               value="${emp.emp_tel_num}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="emp_addr" class="col-sm-1 control-label">地址</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="emp_addr" name="emp_addr" required
                               value="${emp.emp_addr}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="emp_email" class="col-sm-1 control-label">邮箱</label>
                    <div class="col-sm-5">
                        <input type="email" class="form-control" id="emp_email" name="emp_email" required
                               value="${emp.emp_email}">
                    </div>
                </div>
                <button style="margin-left: 20%" type="submit" class="btn btn-warning btn-sm">确认修改</button>
                <button type="button" class="btn btn-primary btn-sm" name="back">返回</button>
            </form>
        </div>
    </div>
</div>
</body>
<script>
    $(document).ready(function () {
        var sex = "${emp.emp_sex}";
        if (sex == '男') {
            $("input:radio:first").attr("checked", true);
        }
        else {
            $("input:radio:last").attr("checked", true);
        }
    });

    $(document).ready(function () {
        $("button[name=back]").click(function () {
            location.href = "${pageContext.request.contextPath}/emp?method=byPage&currPage=${param.currPage}";
        });
    });
</script>
</html>
