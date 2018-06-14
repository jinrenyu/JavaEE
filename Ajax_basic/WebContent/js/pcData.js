// json数据格式
function getXHR() {
	// 该方法用于获取Ajax通信对象
	var xhr = null;
	// 如果如下表示, 在进行判断前会调用Boolean进行隐式转换
	if (window.XMLHttpRequest) {
		xhr = new XMLHttpRequest();
	} else {
		// 兼容早期的IE浏览器
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xhr;
}

// 它需要根据select元素的id去为这个元素动态的添加
// option节点
function initProvince(selId) {
	var xhr = getXHR();
	xhr.open("get", "/Ajax_basic/province/getAll");
	xhr.send();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			// alert(xhr.responseText);
			var provinces = JSON.parse(xhr.responseText);
			// 1. 拿到需要添加option节点对象的select元素
			var selTag = document.getElementById(selId);
			for (var i = 0; i < provinces.length; i++) {
				// 2. 循环的去创建option节点DOM对象, 并添加给selTag
				// 作为其子节点
				// Option构造函数有两个参数: 参数1(展示值) 参数2(value)
				var option = new Option(provinces[i].name, provinces[i].code);
				selTag.appendChild(option);
			}
		}
	}
}

// 参数1: 需要添加市信息的select列表的id
// 参数2: 省级下拉框所选项的value值(数组的下标)
function addOption(subId1, subId2, value, url) {
	var xhr = getXHR();
	xhr.open("get", url);
	xhr.send();
	if (subId1) {
		var selTag = document.getElementById(subId1);
		// 去清空city下拉选项
		selTag.options.length = 1;
	}
	if (subId2) {
		var selTag2 = document.getElementById(subId2);
		// 去清空area下拉选项
		selTag2.options.length = 1;
	}
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			// alert(xhr.responseText);
			var cities = JSON.parse(xhr.responseText);
			if (value != "" && value != undefined) {
				for (var i = 0; i < cities.length; i++) {
					var option = new Option(cities[i].name, cities[i].code);
					selTag.appendChild(option);
				}
			}
		}
	}
	
}