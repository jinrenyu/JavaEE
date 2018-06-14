<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>级联下拉列表</title>
        <!-- 把公共组件放入到单个的js文件, 方便界面之间复用 -->
        <script type="text/javascript" src="js/pcData.js"></script>
    </head>
    <!-- onload事件会在页面加载完毕的时候触发 -->
    <body onload="initProvince('province');">
        province:
        <!-- 此处的onchange事件需要根据当前被选择的option去设置
        id为city的select列表的值 -->
        <select id="province" onchange="addCity(this);">
        	<option value="">-请选择-</option>
        </select>
        city:
        <select id="city" onchange="addArea(this);">
        	<option value="">-请选择-</option>
        </select>
        district:
        <select id="area">
        	<option value="">-请选择-</option>
        </select>
        <script type="text/javascript">
            function addCity(obj) {
            	addOption("city", "area", obj.value, "/Ajax_basic/CityAction?pCode=" + obj.value);
            }
            function addArea(obj) {
            	addOption("area", "", obj.value, "/Ajax_basic/AreaAction?cCode=" + obj.value);
            }
        </script>
    </body>
</html>