<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="${path}/css/main.css" rel="stylesheet">
        <script type="text/javascript" src="${path}/js/main.js"></script>
        <title>主界面</title>
    </head>
    <body onload="getRoomType();">
        <div>
            <form action="${path}/record/searchData" method="post">
                <table class="first">
                    <tr>
                        <td colspan="4">
                            <input type="submit" value="入住数据查询" />
                            <input type="button" value="新增入住信息" onclick="addInfo();" />
                            <input type="button" value="客房信息" />
                        </td>
                    </tr>
                    <tr>
                        <td>房间编号:</td>
                        <td>
                            <input type="text" name="scode" />
                        </td>
                        <td>房间编号:</td>
                        <td>
                            <select id="typeSel" name="stype">
                                <option value="">-请选择-</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>入住日期:</td>
                        <td>
                            <input type="date" name="ssdate" />
                        </td>
                        <td>至:</td>
                        <td>
                            <input type="date" name="sedate" />
                        </td>
                    </tr>
                    <tr>
                        <td>退房日期:</td>
                        <td>
                            <input type="date" name="esdate" />
                        </td>
                        <td>至:</td>
                        <td>
                            <input type="date" name="eedate" />
                        </td>
                    </tr>
                </table>
            </form>
            <c:if test="${empty records}">
                <table class="second">
                    <tr>
                        <th>房间编号</th>
                        <th>房间类型</th>
                        <th>入住时间</th>
                        <th>退房时间</th>
                        <th>总费用</th>
                        <th>操作</th>
                    </tr>
                </table>
            </c:if>
            <c:forEach items="${records}" var="record" varStatus="status">
                <c:if test="${status.first}">
                    <table class="second">
                        <tr>
                            <th>房间编号</th>
                            <th>房间类型</th>
                            <th>入住时间</th>
                            <th>退房时间</th>
                            <th>总费用</th>
                            <th>操作</th>
                        </tr>
                </c:if>
                <tr>
                    <td>${record.room.code}</td>
                    <td>${record.room.roomType}</td>
                    <td>
                        <fmt:formatDate value="${record.startDate}" pattern="yyyy-MM-dd HH:mm" />
                    </td>
                    <td>
                        <fmt:formatDate value="${record.endDate}" pattern="yyyy-MM-dd HH:mm" />
                    </td>
                    <td>${record.total}</td>
                    <td>
                        <c:if test="${empty record.endDate}">
                            <input type="hidden" value="${record.id}">
                            <input type="button" value="退房" onclick="editInfo(this);" />
                        </c:if>
                    </td>
                </tr>
                <c:if test="${status.last}">
                    </table>
                </c:if>
            </c:forEach>
        </div>
        <script type="text/javascript">
            function getRoomType() {
                getOptions("typeSel", "${path}/room/getType", true);
            }
            function addInfo() {
                var url = "${basePath}record/add";
                var type = "_blank";
                var parameters = "left=30,top=30,width=600,height=150;resizable=no;"
                    + "scrollbars=no;menubar=no;toolbar=no;location=no";
                window.open(url, type, parameters);
            }
            function editInfo(obj) {
                var recordId = obj.previousElementSibling.value;
                var url = "${basePath}record/checkout?id=" + recordId;
                var type = "_blank";
                var parameters = "left=30,top=30,width=600,height=150;resizable=no;"
                    + "scrollbars=no;menubar=no;toolbar=no;location=no";
                window.open(url, type, parameters);
            }
        </script>
    </body>
</html>