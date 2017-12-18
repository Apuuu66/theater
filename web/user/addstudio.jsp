<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/12/15
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>影厅管理</title>

    <%--<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <%--<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>--%>
    <%--<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

    <script src="../js/jquery.min.js"></script>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="/admin/head.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="/admin/navbar.jsp"></jsp:include>
        <div class="col-md-10">
            <h2 style="display: inline-block">添加影厅</h2>
            <form class="form-horizontal" role="form"
                  action="${pageContext.request.contextPath}/studio?method=add" method="post">
                <div class="form-group">
                    <label class="col-sm-1 control-label">影厅名</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="n1" name="studio_name" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-1 control-label">行</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="n2" name="studio_row_count" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-1 control-label">列</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="n3" name="studio_col_count">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-1 control-label">描述</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="n4" name="studio_introduction">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label">状态</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="n5" name="studio_flag">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label">提示信息</label>
                    <div class="col-sm-5">
                        <h4><span class="label label-info" id="errormsg"></span></h4>
                    </div>
                </div>
                <button style="margin-left: 20%" type="submit" class="btn btn-warning" onclick="return check()">添加
                </button>
                <button type="button" class="btn btn-primary" name="back">返回</button>
            </form>
        </div>
    </div>
</div>
</body>
<script>
    $(document).ready(function () {
        $("#item2").attr("class", "list-group-item active");

        $("button[name=back]").click(function () {
            location.href = "${pageContext.request.contextPath}/studio?method=findAll&currPage=1";
        });
    });

    function check() {
        var n1 = $("#n1").val();
        var n2 = $("#n2").val();
        var n3 = $("#n3").val();
        var n4 = $("#n4").val();
        var n5 = $("#n5").val();
        var re = /^[1-9][1-9]*$/;
        if (n1 == "" || n2 == "" || n3 == "" || n4 == "" || n5 == "") {
            $("#errormsg").html("请填写完整信息!").show(300).delay(1000).hide(300);
            return false;
        }
        else if (!re.test(n2)){
            $("#errormsg").html("演出厅行值必须必须为数字且大于0!").show(300).delay(1000).hide(300);
            return false;
        }
        else if (!re.test(n3)){
            $("#errormsg").html("演出厅列值必须必须为数字且大于0!").show(300).delay(1000).hide(300);
            return false;
        }
        else if (n5 != 0 && n5 != 1) {
            $("#errormsg").html("最后一栏填(0|1)").show(300).delay(1000).hide(300);
            return false;
        }
        else {
            $("#errormsg").html("格式正确").show(300).delay(1000).hide(300);
            return true;
        }
    }
</script>
</html>
