<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>用户新增界面</title>
        <script type="text/javascript" src="${path}/js/main.js"></script>
        <script type="text/javascript" src="${path}/js/date.js"></script>
        <style type="text/css">
            div {
                display: table-cell;
                width: 600px;
                height: 150px;
                vertical-align: middle;
            }
            table {
                border: 1px solid;
                margin: 0px auto;
                width: 500px;
                height: 90px;
            }
            td[colspan="4"] {
                text-align: center;
            }
            select {
                width: 80px;
            }
        </style>
    </head>
    <body onload="getRoomCode();">
        <div>
            <form action="#" method="post" onsubmit="return switchAction();">
                <table>
                    <tr>
                        <td>房间编号:</td>
                        <td>
                            <c:choose>
                                <c:when test="${empty record}">
                                    <select id="selCode" name="roomCode" onchange="getType(this);">
                                        <option value="">-请选择-</option>
                                    </select>
                                </c:when>
                                <c:otherwise>
                                    <input type="text" name="roomCode" value="${record.room.code}" 
                                        readonly="readonly">
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>房间类型:</td>
                        <td>
                            <input type="text" name="roomType" id="roomType" 
                                value="${record.room.roomType}" readonly="readonly">
                        </td>
                    </tr>
                    <tr>
                        <td>入住日期:</td>
                        <td>
                            <input type="text" name="startDate" value="${time}" readonly="readonly">
                        </td>
                        <td colspan="2">
                            <input type="hidden" name="id" value="${record.id}">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <input type="submit" value="保存">
                            <input type="button" value="关闭" onclick="window.close();">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <script type="text/javascript">
            function getRoomCode() {
                var idValue = document.getElementsByName("id")[0].value;
                if (idValue == null || idValue == "" || idValue == undefined) {
                    getOptions("selCode", "${path}/room/getCode");
                }
            }
            function getType(obj) {
                setValueById("roomType", "${path}/room/getSepCode?code="
                        + obj.options[obj.selectedIndex].text, false);
                document.getElementsByName("startDate")[0].value = new Date().format("yyyy-MM-dd hh:mm");
            }
            function switchAction() {
                var idValue = document.getElementsByName("id")[0].value;
                var startDate = document.getElementsByName("startDate")[0].value;
                var roomId = document.getElementsByName("roomCode")[0].value;
                var url;
                var flag = (idValue == null || idValue == "" || idValue == undefined);
                if (flag) {
                    url = "${path}/record/addRecord";
                } else {
                    url = "${path}/record/editRecord";
                }
                var xhr = getHttpObject();
                xhr.open("post", url);
                xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                xhr.send("roomCode="+ roomId + "&startDate=" + startDate 
                        + "&recordId=" + idValue);
                xhr.onreadystatechange = function() {
                    if (xhr.readyState == 4 && xhr.status == 200) {
                        if (xhr.responseText == "success") {
                            if (flag) {
                                alert("保存成功");
                            } else {
                                alert("退房成功");
                            }
                            window.opener.location.reload();
                            window.close();
                        } else {
                            alert("操作失败");
                        }
                    }
                }
                return false;
            }
        </script>
    </body>
</html>