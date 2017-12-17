<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/11/29
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>员工管理</title>

    <%--<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <%--<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>--%>
    <%--<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

    <script src="../js/jquery.min.js"></script>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="navbar.jsp"></jsp:include>
        <div class="col-md-10">
            <h2 style="display: inline-block">添加员工</h2>
            <form class="form-horizontal" role="form"
                  action="${pageContext.request.contextPath}/admin?method=addEmp" method="post">
                <div class="form-group">
                    <label for="emp_no" class="col-sm-1 control-label">编号</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="emp_no" name="emp_no" onblur="checkNo()" required>
                    </div>
                    <spqn id="emp_no_tip" class="control-label" style="color:red"></spqn>
                </div>
                <div class="form-group">
                    <label for="emp_name" class="col-sm-1 control-label">姓名</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="emp_name" name="emp_name">
                    </div>
                    <p id="emp_name_tip" class="control-label" style="color:red"></p>

                </div>
                <div class="form-group">
                    <%--@declare id="emp_sex"--%><label for="emp_sex" class="col-sm-1 control-label">性别</label>
                    <div class="col-sm-5" style="margin-top:7PX">
                        男 &nbsp;<input type="radio" class="radio-inline" name="emp_sex" value="男">
                        女<input type="radio" class="radio-inline" name="emp_sex" value="女">
                    </div>
                </div>
                <div class="form-group">
                    <label for="emp_tel_num" class="col-sm-1 control-label">电话</label>
                    <div class="col-sm-5">
                        <input type="tel" class="form-control" id="emp_tel_num" name="emp_tel_num" required>
                    </div>
                    <p id="emp_tel_num_tip" class="control-label" style="color:red"></p>

                </div>

                <div class="form-group">
                    <label for="emp_addr" class="col-sm-1 control-label">地址</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="emp_addr" name="emp_addr">
                    </div>
                    <p id="emp_addr_tip" class="control-label" style="color:red"></p>

                </div>

                <div class="form-group">
                    <label for="emp_email" class="col-sm-1 control-label">邮箱</label>
                    <div class="col-sm-5">
                        <input type="email" class="form-control" id="emp_email" name="emp_email">
                    </div>
                    <p id="emp_email_tip" class="control-label" style="color:red"></p>
                </div>
                <button style="margin-left: 20%" type="submit" class="btn btn-warning" onsubmit="checkNo()">添加</button>
                <button type="button" class="btn btn-primary" name="back">返回</button>

            </form>
        </div>
    </div>
</div>
</body>
<script>
    function checkNo() {
        var reg = /^\w{6,15}$/;
        if (!reg.test($("#emp_no").val())) {
            $("#emp_no_tip").html("<img src='images/error.png'>请输入6-15位单词组合");
            return false;
        } else {
            $.get("${pageContext.request.contextPath}/admin?method=checkNo&emp_no=" + $("#emp_no").val(), function (date) {
                if (date != "true") {
                    $("#emp_no_tip").html("");
                } else {
                    $("#emp_no_tip").html("用户名已占用");
                    $("#emp_no").focus();
                }
            });
            return true;
        }
    }

    $(document).ready(function () {
        $("button[name=back]").click(function () {
            location.href = "${pageContext.request.contextPath}/admin?method=byPage&currPage=1";
        });
    });
    $(document).ready(function () {
        $("#item1").attr("class","list-group-item active");
    });
</script>
</html>
