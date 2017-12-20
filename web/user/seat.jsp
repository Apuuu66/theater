<%--
  Created by IntelliJ IDEA.
  User: Fionar
  Date: 2017/12/17
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>座位管理</title>

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
            <h2 style="display: inline">座位管理
                <small>All seats</small>
            </h2>
            <div style="display: inline">
                <div style="display: inline;margin-left: 50%">
                    <img src="${pageContext.request.contextPath}/images/手指箭头-01-01.png " alt="-->">
                    <select class="form-control" style="width: 20%;display: inline; border-color: red;margin-left: 2%"
                            id="init" onchange="displaySeat()">
                        <option disabled="disabled" selected="selected">--请先选择影厅--</option>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="col-md-9">
                    <div>
                        <table class="table" id="tb" style="border-collapse:collapse;border:none;">
                            <thead><h3 style="text-align: center">演出厅座位分布</h3></thead>
                            <tbody id="seatbody"></tbody>
                        </table>
                    </div>
                </div>
                <div class="col-md-3">
                    <div style="margin-top: 25%">
                        <div>
                            <img src="../images/0.png" alt="">
                            <span style="font-size: 10px">可选</span>
                            <img src="../images/1.png" alt="">
                            <span style="font-size: 10px">已售</span>
                            <img src="../images/2.png" alt="">
                            <span style="font-size: 10px">损坏</span>
                        </div>

                        <div style="border: 1px solid grey;width: 187px;height: 140px;margin-top: 9%">
                            <div style="padding-top: 5% ;padding-left: 5%">
                                <img src="../images/-1.png" id="nowimg" name="" alt="">
                                <span>当前</span>
                                <span style="padding-left: 10%" id="nowdesc">未选</span>
                            </div>
                            <div style="margin-left: 30%;margin-top: 8%;margin-bottom: 5%"><span>设置状态</span></div>
                            <button class="btn btn-default btn-sm" style="margin-left: 3%" value="0">未售
                            </button>
                            <button class="btn btn-success btn-sm" style="margin-left: 3%" value="1">已售
                            </button>
                            <button class="btn btn-danger btn-sm" style="margin-left: 3%" value="2">损坏
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>

    $(document).ready(function () {
        $("#item4").attr("class", "list-group-item active")

        $("#seatbody").on("click", "img", function () {
            // console.log(this.name);
            if (this.name == 0) {
                $("#nowimg").attr("src", "../images/0.png");
                $("#nowimg").attr("name", this.id);
            } else if (this.name == 1) {
                $("#nowimg").attr("src", "../images/1.png");
                $("#nowimg").attr("name", this.id);
            } else
                $("#nowimg").attr("src", "../images/2.png");
            $("#nowimg").attr("name", this.id);
            $("#nowdesc").text(this.title);
        });

        $.post("${pageContext.request.contextPath}/seat?method=query", function (data) {
            $op = $("#init");
            $(data).each(function () {
                $op.append("<option row=" + this.studio_row_count + " col=" + this.studio_col_count + " id=" + this.studio_id + ">" + this.studio_name + "</option>");
            });
            // console.log(data);
        }, "json");
        $("button").click(function () {
            $seat_id = $("#nowimg").attr("name");
            // alert($seat_id);
            // alert(this.value);
            // console.log($("#nowimg").attr("name"));
            // alert($seat_id);
            if ($("#nowimg").attr("name") == "") {
                alert("请选择座位后再修改！");
            } else if (this.value == 0) {
                $.post("${pageContext.request.contextPath}/seat?method=update&seat_id=" + $("#nowimg").attr("name") + "&seat_status=0");
                $("#" + $seat_id).attr("src", "../images/0.png");
            } else if (this.value == 1) {
                $.post("${pageContext.request.contextPath}/seat?method=update&seat_id=" + $("#nowimg").attr("name") + "&seat_status=1");
                $("#" + $seat_id).attr("src", "../images/1.png");
            } else {
                $.post("${pageContext.request.contextPath}/seat?method=update&seat_id=" + $("#nowimg").attr("name") + "&seat_status=2");
                $("#" + $seat_id).attr("src", "../images/2.png");
            }


        });
    });

    function displaySeat() {
        $("#seatbody").empty();
        var studioId = $("#init").find("option:selected").attr("id");
        var row = $("#init").find("option:selected").attr("row");
        var col = $("#init").find("option:selected").attr("col");
        $tbd = $("#seatbody");
        $.post("${pageContext.request.contextPath}/seat?method=getSeatByStudioID&studioId=" + studioId, function (data) {
            var k = 0;
            for (var i = 1; i <= row; i++) {
                $tbd.append("<tr></tr>");
                for (var j = 1; j <= col; j++) {
                    //0 表示未售 可用 1 表示已售 2损坏
                    if (data[k].seat_status == 0) {
                        $tt = $("<td align='center' ><img src='${pageContext.request.contextPath}/images/0.png' name=" + data[k].seat_status + " title=" + i + "排" + j + "列 id=" + data[k].seat_id + " ></td>");
                    }
                    else if (data[k].seat_status == 1) {
                        $tt = $("<td align='center' ><img src='${pageContext.request.contextPath}/images/1.png' name=" + data[k].seat_status + " title=" + i + "排" + j + "列 id=" + data[k].seat_id + " ></td>");
                    } else {
                        $tt = $("<td align='center' ><img src='${pageContext.request.contextPath}/images/2.png' name=" + data[k].seat_status + " title=" + i + "排" + j + "列 id=" + data[k].seat_id + " ></td>");
                    }
                    $tt.appendTo($("#tb tr")[i - 1]);
                    k++;
                }
            }
            // console.log(data);
            $("td").attr("style", "border:solid #000 0px;");//清除table边框
        }, "json");
    }
</script>
</html>
