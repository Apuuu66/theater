<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/11/29
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="background-image: url(${pageContext.request.contextPath}/images/bg.jpg); height: 50px; margin-bottom:20px;">
    <div style="display: inline-block; font-size: 25px; color:white; width: 90%;text-align: center;">
        <span style="line-height: 50px; ">后台管理中心</span>
    </div>
    <div class="dropdown" style="display: inline-block; float:right; margin-right:10px; margin-top:9px;">
        <a href="${pageContext.request.contextPath}/userInfo.jsp"><img src="${pageContext.request.contextPath}${userlogin.head_path}" alt="未登录"
                         style="display:inline-block;float:right;width: 35px;height: 35px;
                          margin-right:40px; border-radius: 5px;">
        </a>
    </div>
</div>