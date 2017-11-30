<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/11/17
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>注册</title>
</head>
<body class="back">
<div>

    <div>
        <h2>注 册</h2>
        <hr/>
        <form name="myform" id="formId"action="${pageContext.request.contextPath}/users?method=regist" method="post">
            <div>
                <label for="emp_no">用户名</label>
                <div>
                    <input type="text" id="emp_no" name="emp_no" onblur="checkNo()" required>
                </div>
                <p id="emp_no_tip" style="color:red"></p>
            </div>

            <div>
                <label for="emp_name" >昵称</label>
                <div>
                    <input type="text" class="form-control" id="emp_name" name="emp_name" onblur="checkEmpName()">
                </div>
                <p id="emp_name_tip" class="control-label" style="color:red"></p>

            </div>

            <div>
                <label for="emp_tel_num">电话</label>
                <div class="col-sm-5">
                    <input type="tel"  id="emp_tel_num" name="emp_tel_num" onblur="checkEmpTelNum()"
                           required>
                </div>
                <p id="emp_tel_num_tip"  style="color:red"></p>

            </div>

            <div>
                <label for="emp_addr" >地址</label>
                <div>
                    <input type="text" id="emp_addr" name="emp_addr" onblur="checkAddr()">
                </div>
                <p id="emp_addr_tip"  style="color:red"></p>

            </div>

            <div >
                <label for="emp_email" >邮箱</label>
                <div >
                    <input type="email"  id="emp_email" name="emp_email" onblur="checkEmpEmail()">
                </div>
                <p id="emp_email_tip"  style="color:red"></p>

            </div>


            <div>
                <label>密码</label>
                <div class="col-sm-5">
                    <input type="password" id="password" onblur="checkPass()" required>
                </div>

            </div>

            <div>
                <label>确认密码</label>
                <div>
                    <input type="password" id="confirmPassword" name="emp_pass"
                           onblur="checkPass()" required>
                </div>
                <p id="password_tip" style="color:red"></p>
            </div>

            <button  onclick="checkAll()">注册</button>

        </form>

    </div>

</div>
<script type="text/javascript">
    function checkNo() {
        var reg = /^\w{6,15}$/;
        if (!reg.test($("#emp_no").val())) {
            $("#emp_no_tip").html("<img src='images/error.png'>请输入6-15位单词组合");
        } else {
            $.get("${pageContext.request.contextPath}/users?method=checxEmpno&emp_no=" +$("#emp_no").val(), function (date) {
                if (date != "true") {
                    $("#emp_no_tip").html("<img src='images/right.png'>");
                } else {
                    $("#emp_no_tip").html("<img src='images/error.png'>用户名已占用");
                    $("#emp_no").focus();
                }
            });
        }
    }

    function checkEmpName() {
        var reg = /^[\u4e00-\u9fa5]{2,10}$/;
        var emp_name = document.myform.emp_name;
        if (!reg.test(emp_name.value)) {
            document.getElementById("emp_name_tip").innerHTML = "<img src='images/error.png'>请输入10字以内中文!";
            emp_name.focus();
            return false;
        }
        else {
            document.getElementById("emp_name_tip").innerHTML = "<img src='images/right.png'>";
            return true;
        }
    }

    function checkEmpTelNum() {
        var reg = /^1[3-8][0-9]{9}$/;
        var emp_tel_num = document.myform.emp_tel_num;
        if (!reg.test(emp_tel_num.value)) {
            document.getElementById("emp_tel_num_tip").innerHTML = "<img src='images/error.png'>请输入11位手机号码!";
            emp_tel_num.focus();
            return false;
        }
        else {
            document.getElementById("emp_tel_num_tip").innerHTML = "<img src='images/right.png'>";
            return true;
        }
    }

    function checkEmpEmail() {
        var reg = /^([a-zA-Z0-9_-])+@[a-zA-Z0-9_-]+((\.[a-z]{2,3}){1,2})$/;
        var emp_email = document.myform.emp_email;
        if (!reg.test(emp_email.value)) {
            document.getElementById("emp_email_tip").innerHTML = "<img src='images/error.png'>请输入正确格式Email!";
            emp_email.focus();
            return false;
        }
        else {
            document.getElementById("emp_email_tip").innerHTML = "<img src='images/right.png'>";
            return true;
        }
    }

    function checkPass() {
        if ($("#password").val() != $("#confirmPassword").val()) {
            $("#password_tip").html("<img src='images/error.png'>两次密码输入不一致");
            return false;
        } else {
            $("#password_tip").html("<img src='images/right.png'>");
            return true;
        }

    }
    function checkAddr() {
        var reg = /^.{2,30}$/;
        var emp_addr = document.myform.emp_addr;
        if (!reg.test(emp_addr.value)) {
            document.getElementById("emp_addr_tip").innerHTML = "<img src='images/error.png'>请输入地址,30字以内!";
            emp_addr.focus();
            return false;
        }
        else {
            document.getElementById("emp_addr_tip").innerHTML = "<img src='images/right.png'>";
            return true;
        }
    }

    function checkAll() {
        if (!checkNo() || !checkEmpName() || !checkEmpTelNum() || !checkEmpAddr() || !checkEmpEmail() || !checkPass()) {
            return false;
        }else {
            document.getElementById("formId").submit();
        }

    }
</script>
</body>


</html>
