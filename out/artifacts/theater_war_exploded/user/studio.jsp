<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/12/7
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    

</head>
<body>
<jsp:include page="/admin/head.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="/admin/navbar.jsp"></jsp:include>
        <div class="col-md-10">
            <div style="margin-top: -2%">
                <form class="form-inline" action="#" method="post">
                    <h2 style="display: inline-block">所有影厅
                        <small>All studio</small>
                    </h2>

                    <div class="form-group" style="margin-left:50% ">
                        <input type="text" class="form-control" placeholder="Search" id="condition">
                    </div>
                    <button type="button" name="query" class="btn btn-primary">查询</button>
                    <button type="button" name="add" class="btn btn-warning">添加</button>
                </form>
            </div>
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>影厅ID</th>
                        <th>影厅名</th>
                        <th>行</th>
                        <th>列</th>
                        <th>描述</th>
                        <th>可用</th>
                        <th style="text-align: center">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty pb.list}">
                        <c:forEach items="${pb.list}" var="stdio">
                            <tr>
                                <td>${stdio.studio_id}</td>
                                <td><input type="text" id="studio_name" value="${stdio.studio_name}" required ></td>
                                <td><input type="text" id="studio_row_count" value="${stdio.studio_row_count}" required>
                                </td>
                                <td><input type="text" id="studio_col_count" value="${stdio.studio_col_count}" required>
                                </td>
                                <td><input type="text" id="studio_introduction" value="${stdio.studio_introduction}"
                                           required>
                                </td>
                                <td><input type="text" id="studio_flag" value="${stdio.studio_flag}" required></td>
                                <td style="text-align: center">
                                    <button class="btn btn-info btn-sm " name="1">修改</button>
                                    <button class="btn btn-danger btn-sm" name="2" id="${stdio.studio_id}">删除</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                </table>

                <%--分页--%>
                <c:if test="${pb.totalCount > 6}">
                    <ul class="pagination" style="margin-left:25%">
                            <%--//判断是否为第一页--%>
                        <c:if test="${pb.currPage == 1}">
                            <li class="disabled"><a href="javascript:void(0);" aria-label="Previous"><span
                                    aria-hidden="true">&laquo;</span></a></li>
                        </c:if>
                        <c:if test="${pb.currPage != 1}">
                            <li>
                                <a href="${pageContext.request.contextPath}/studio?method=findAll&currPage=${pb.currPage-1}"
                                   aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
                        </c:if>
                        <c:forEach begin="${pb.currPage-2>0?pb.currPage-2:1}"
                                   end="${pb.currPage+2>pb.totalPage?pb.totalPage:pb.currPage+2}" var="n">
                            <c:if test="${pb.currPage == n}">
                                <li class="active"><a href="javascript:void(0);">${n}</a></li>
                            </c:if>
                            <c:if test="${pb.currPage != n}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/studio?method=findAll&currPage=${n}">${n}</a>
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
                                <a href="${pageContext.request.contextPath}/studio?method=findAll&currPage=${pb.currPage+1}"
                                   aria-label="Previous"><span aria-hidden="true">&raquo;</span></a></li>
                        </c:if>
                    </ul>
                </c:if>
                <h3 style="display: inline-block"><span class="label label-success" id="errormsg"></span>
                </h3>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    $(document).ready(function () {
        $("td>input").attr("style", "width:160;border-left: 0px;border-top: 0px;border-right: 0px;border-bottom: 1px;");
        $("#item2").attr("class", "list-group-item active");

        $("button[name=1]").click(function () {
            var $td = $(this).parents('tr').children('td');
            var n1 = $td.eq(0).text();
            var n2 = $td.eq(1).find("input").val();
            var n3 = $td.eq(2).find("input").val();
            var n4 = $td.eq(3).find("input").val();
            var n5 = $td.eq(4).find("input").val();
            var n6 = $td.eq(5).find("input").val();
            if (n1 == "" || n2 == "" || n3 == "" || n4 == "" || n5 == "" || n6 == "") {
                $("#errormsg").html("请填写完整信息!").show(300).delay(1000).hide(300);
                return;
            }
            else if (n3 <= 0 || n4 <= 0) {
                $("#errormsg").html("演出厅行列值必须大于0!").show(300).delay(1000).hide(300);
                return;
            }
            else if (n6 != 0 && n6 != 1) {
                $("#errormsg").html("最后一栏填(0|1)").show(300).delay(1000).hide(300);
                return;
            }

            var studio = {
                "studio_id": $td.eq(0).text(),
                "studio_name": $td.eq(1).find("input").val(),
                "studio_row_count": $td.eq(2).find("input").val(),
                "studio_col_count": $td.eq(3).find("input").val(),
                "studio_introduction": $td.eq(4).find("input").val(),
                "studio_flag": $td.eq(5).find("input").val()
            };
            // alert(JSON.stringify(studio));
            $.post("${pageContext.request.contextPath}/studio?method=update", {"studio": JSON.stringify(studio)}, function (flag) {
                if (flag == 1) {
                    //提示修改成功
                    $("#errormsg").html("修改成功!").show(300).delay(1000).hide(300);
                }
                else {
                    $("#errormsg").html("修改失败!").show(300).delay(1000).hide(300);
                }
            });
        });

        $("button[name=2]").click(function () {
            if (confirm("确认删除吗？")) {
                location.href = "${pageContext.request.contextPath}/studio?method=delete&studio_id=" + this.id + "&currPage=" + "${param.currPage}";
            }
        });

        $("button[name=add]").click(function () {
            location.href = "${pageContext.request.contextPath}/user/addstudio.jsp";
        });
    });
</script>
</html>
