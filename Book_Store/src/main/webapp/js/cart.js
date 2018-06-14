$(function() {
	//每过2秒钟进行一次轮播
	$('#myCarousel').carousel({
		interval: 2000
	});
});

//实现全选功能
function selectAll(obj) {
	//获取所有的checkbox
	var cks = document.getElementsByName("cks");
	if(obj.checked) {
		for(var i = 0; i < cks.length; i++) {
			cks[i].checked = true;
		}
	} else {
		for(var i = 0; i < cks.length; i++) {
			cks[i].checked = false;
		}
	}
}

//删除按钮
function del() {
	//获取first_del
	var fd = document.getElementById("first_del");
	var td = document.getElementById("two_del");
	td.style.display = "none";
	fd.style.display = "none";
	//判断是否选择了商品
	var count = 0;
	//获取所有的checkbox
	var cks = document.getElementsByName("cks");
	//遍历
	for(var i = 0; i < cks.length; i++) {
		if(cks[i].checked) {
			count++;
			
		}
	}
	
	if(count == 0) {
		fd.style.display = "block";
	} else {
		td.style.display = "block";
	
			
	}

}

//显示条数
function displaySize(obj) {
	var num = parseInt(obj.value);
	//获取所有的tables
	var trs = document.getElementsByTagName("tr");

	for(var i = 2; i < trs.length - 1; i++) {
		trs[i].className = "";
	}

	//去掉前两行说明和最后一行.下标是从2-trs.length-1结束.
	for(var i = num + 2; i <= trs.length - 3; i++) {
		trs[i].className = "hidden";
	}
}

//修改数量
function changeNum() {
	var trs = document.getElementById("tby").getElementsByTagName("tr");

	for(var i = 0; i < trs.length; i++) {
		var td = trs[i].getElementsByTagName("td")[5];
		td.onclick = function() {

			var reg = /^[0-9]+$/;

			var oldValue = this.innerHTML;
			var to = this;

			if(!reg.test(oldValue)) {
				return;
			}

			this.innerHTML = "<div class='input-group' style='width: 105px;'>" +
				"<span class='input-group-btn'>" +
				"<button class='btn btn-default' type='button'>-</button>" +
				"</span><input type='text' class='form-control' value='" + oldValue + "'><span class='input-group-btn'>" +
				"<button class='btn btn-default' type='button'>+</button>" +
				"</span>" +
				"</div>";

			this.onclick = "";

			var inp = this.getElementsByTagName("input")[0];
			var bt = this.getElementsByTagName("button")[0];
			var btn = this.getElementsByTagName("button")[1];

			inp.onclick = function(event) {
				var e = window.evnet || event;
				if(window.event) {
					e.cancelBubble = true;
				} else {
					//e.preventDefault(); //在基于firefox内核的浏览器中支持做法stopPropagation
					e.stopPropagation();
				}
				this.select();
			}

			bt.onclick = function(event) {
				var e = window.evnet || event;
				if(window.event) {
					e.cancelBubble = true;
				} else {
					//e.preventDefault(); //在基于firefox内核的浏览器中支持做法stopPropagation
					e.stopPropagation();
				}

				inp.value = parseInt(inp.value.trim()) - 1 <= 0 ? 0 : parseInt(inp.value.trim()) - 1;
				updatenumber(inp.value,to);
			}

			btn.onclick = function(event) {
				var e = window.evnet || event;
				if(window.event) {
					e.cancelBubble = true;
				} else {
					//e.preventDefault(); //在基于firefox内核的浏览器中支持做法stopPropagation
					e.stopPropagation();
				}
				inp.value = parseInt(inp.value.trim()) + 1;
				updatenumber(inp.value,to);
			}

			//inp.select();
			inp.onblur = function() {
				var n = this.value.trim();
				if(!reg.test(n)) {
					n = oldValue;
				}

				to.innerHTML = n;
				to.onclick = changeNum;
				updatenumber(n,to);
			}

			inp.onkeydown = function(event) {
				var e = window.event || event;
				if(e.keyCode == 13) {
					var n = this.value.trim();
					if(!reg.test(n)) {
						n = oldValue;
					}

					to.innerHTML = n;
					to.onclick = changeNum;
					updatenumber(n,to);
				}
			}
			var count = inp.value;
		}
	}
}

function updatenumber(number,to){
	var idkey = to.nextElementSibling.nextElementSibling.value;
	
	//alert(idkey+"就开始"+number);
	//创建url地址
	var url = "/Book_Store/book/number";
	//1.创建xmlHttpRequest对象
	var xmlHttpRequest = new XMLHttpRequest();
	//2.注册一个回调函数,当readystate属性改变时,就会触发该回调函数.
	xmlHttpRequest.onreadystatechange = callback;
	//2-1.自定义回调函数
	function callback(){
		//2-2.当readystate==4的时候,说明响应已经完成.
		if(xmlHttpRequest.readyState==4){
			//2-3.并且http状态码等于200的时候,说明是一次成功的响应
			if(xmlHttpRequest.status==200){
				//2-4.获取服务器返回的文本数据
				var str = xmlHttpRequest.responseText;
				
				//2-5.业务操作.拿到后台返回的数据进行一些操作.
				if("0"!=str){
					alert("更新成功!");
					location.reload();
				}
				document.getElementById("firstCount").innerHTML=str.split(":")[0]+"个商品";
				document.getElementById("firstTotal").innerHTML=str.split(":")[1];
				document.getElementById("twoTotal").innerHTML="总价"+str.split(":")[1]+"元";
				to.nextElementSibling.innerHTML=str.split(":")[2];
			}
		}
	} 
		
	//3.设置连接的信息
	xmlHttpRequest.open("post",url,true);
	//设置请求头  为了向后台传中文参数
	xmlHttpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	//4.发送请求.
	xmlHttpRequest.send("idkey="+idkey+"&number="+number);
	
}














//删除任意行
function delRows(obj){
	
	var cks = document.getElementsByName("cks");
	var tby = document.getElementById("tby");
	//定义一个变量接收
	var ids ="";
	for(var i=cks.length-1;i>=0;i--){
		if(cks[i].checked){
			ids+=cks[i].value+":";
		}
	}
	
	
	//创建url地址
	var url = "/Book_Store/book/delete";
	//1.创建xmlHttpRequest对象
	var xmlHttpRequest = new XMLHttpRequest();
	//2.注册一个回调函数,当readystate属性改变时,就会触发该回调函数.
	xmlHttpRequest.onreadystatechange = callback;
	//2-1.自定义回调函数
	function callback(){
		//2-2.当readystate==4的时候,说明响应已经完成.
		if(xmlHttpRequest.readyState==4){
			//2-3.并且http状态码等于200的时候,说明是一次成功的响应
			if(xmlHttpRequest.status==200){
				//2-4.获取服务器返回的文本数据
				var str = xmlHttpRequest.responseText;
				//调用关闭按钮的单击事件
				obj.previousElementSibling.click();
				
				//2-5.业务操作.拿到后台返回的数据进行一些操作.
				if("1"==str){
					alert("删除成功!");
					window.location="/Book_Store/jsp/cart.jsp";
				}
			}
		}
	} 
		
	//3.设置连接的信息
	xmlHttpRequest.open("post",url,true);
	//设置请求头  为了向后台传中文参数
	xmlHttpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	//4.发送请求.
	xmlHttpRequest.send("ids="+ids);
	
}
