<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/11/16
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<div><a href="${pageContext.request.contextPath}/regist.jsp">注册</a></div>${user.emp_no}

<form action="${pageContext.request.contextPath}/users?method=login" method="post">
    <div>
        <h2>登 录</h2>
        <hr/>

        <div>
            <label>账号</label>
            <input type="text" id="account" name="emp_no" required/>
        </div>

        <div>
            <lable>密码</lable>
            <input type="password" id="password" name="emp_pass" required/>
        </div>

        <button class='btn btn-primary ' type="submit">登录</button>

    </div>
</form>
</body>


</html>