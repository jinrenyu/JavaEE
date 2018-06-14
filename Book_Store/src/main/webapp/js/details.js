function pageUp(){
	var arr1 = ["book10_nav.png","book8_nav.jpg","book9_nav.jpg"];
	var obj = document.getElementById("love");
	var imgs = obj.getElementsByTagName("img");
	for(var i=0;i<imgs.length;i++){
		imgs[i].src="images/"+arr1[i];
	}
}
			
function pageDown(){
	var arr2 = ["book2_nav.jpg","book3_nav.jpg","book4_nav.jpg"];
	var obj = document.getElementById("love");
	var imgs = obj.getElementsByTagName("img");
	
	for(var i=0;i<imgs.length;i++){
		imgs[i].src="images/"+arr2[i];
	}
}

function selectByCount(obj) {
	if(obj.value.trim() == "") {
		obj.value = 1;

	}
}



function addBook(obj){
	
	
	//兼容性写法
	var xmlHttpRequest;
	var buynumber = document.getElementById("buynumber").value;
	if(null==buynumber || ""==buynumber){
		buynumber=1;
	}
	
	//alert(buynumber);
	var url = "/Book_Store/book/addtocart";
	if (window.XMLHttpRequest)
	{
		//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlHttpRequest=new XMLHttpRequest();
	}
	else
	{
		// IE6, IE5 浏览器执行代码
		xmlHttpRequest=new ActiveXObject("Microsoft.XMLHTTP");
	}
	/* //1.创建xmlHttpRequest对象
	var xmlHttpRequest = new XMLHttpRequest(); */
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
				//alert(str);
				//2-5.业务操作.拿到后台返回的数据进行一些操作.
				//采用js的DOM操作.
				document.getElementById("bookcount").innerHTML=str.split(":")[0]+"个商品";
				
				document.getElementById("bookprice").innerHTML="总价共"+str.split(":")[1]+"元";
				
			}
		}
	} 
	//3.设置连接的信息
	xmlHttpRequest.open("post",url,true);
	//设置请求头  为了向后台传中文参数
	xmlHttpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	//4.发送请求.
	xmlHttpRequest.send("buynumber="+buynumber);
}





















