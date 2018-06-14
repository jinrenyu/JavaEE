<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
		<script type="text/javascript">
			// JSON数据格式只是在字面量表达方式的基础规定以下一些规则:
			// 如果要表示一个对象, 则最外层必须使用{}进行包裹,
			// 对象内的成员的属性名必须使用""进行包裹,
			// 默认的数组格式就是一种JSON格式
			var data = {
				"name": 123456,
				"age": true,
				"info": [
		           {"n1": "v1"}, 
		           {"n2": "v2"}
				]
			};
			var data2 = ["a", "b", "c"];
			//alert(data.info[1].n2);
			//alert(data2[0]);
			// 只需要提供一种把JSON格式变成字符串的方法, 就可以实现前端->后台的数据传输
			var str = JSON.stringify(data);
			// 成功转换成了字符串
			// alert(typeof str);
			// 可以使用eval对JSON字符串进行解析, 
			// 因为eval可以执行任意的字符串, 容易造成安全性问题
			// 并且解析错会报错
			var data3 = eval("(" + str + ")");
			// alert(data3.name);
			// 无论是从效率还是安全性(该方法只能用于JSON字符串的解析), 推荐
			var data4 = JSON.parse(str);
			alert(data4.age);
		</script>
    </body>
</html>