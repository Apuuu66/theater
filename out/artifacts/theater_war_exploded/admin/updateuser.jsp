<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/12/6
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户信息</title>

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
            <h2 style="display: inline-block">修改信息 </h2>
            <form class="form-horizontal" role="form"
                  action="${pageContext.request.contextPath}/admin?method=updateuser&currPage=${param.currPage}" method="post">
                <div class="form-group">
                    <label for="emp_no" class="col-sm-1 control-label">编号</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="emp_no" name="emp_no" value="${user.emp_no}"
                               readonly>
                    </div>
                </div>

                <div class="form-group">
                    <%--@declare id="emp_sex"--%><label for="emp_sex" class="col-sm-1 control-label">身份</label>
                    <div class="col-sm-5" style="margin-top:7PX">
                        <%--<input type="text" class="form-control" id="emp_sex" value="${emp.emp_sex}">--%>
                        管理员 &nbsp;<input type="radio" class="radio-inline" name="role" value="1">
                        普通用户<input type="radio" class="radio-inline" name="role" value="0">
                    </div>
                </div>
                <div class="form-group">
                    <label for="emp_tel_num" class="col-sm-1 control-label">密码</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="emp_tel_num" name="emp_pass" required
                               value="${user.emp_pass}">
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
        var sex = "${user.role}";
        if (sex == '1') {
            $("input:radio:first").attr("checked", true);
        }
        else {
            $("input:radio:last").attr("checked", true);
        }
    });

    $(document).ready(function () {
        $("button[name=back]").click(function () {
            location.href = "${pageContext.request.contextPath}/admin?method=manageLogin&currPage=${param.currPage}";
        });
    });
    $(document).ready(function () {
        $("#item6").attr("class","list-group-item active");
    });
</script>
</html>
