var provinces = ["江苏省", "浙江省"];
var cities = [["苏州市", "无锡市"], ["杭州市", "温州市"]];
// json数据格式


// 它需要根据select元素的id去为这个元素动态的添加
// option节点
function initProvince(selId) {
	// 1. 拿到需要添加option节点对象的select元素
	var selTag = document.getElementById(selId);
	for (var i = 0; i < provinces.length; i++) {
		// 2. 循环的去创建option节点DOM对象, 并添加给selTag
		// 作为其子节点
		// Option构造函数有两个参数: 参数1(展示值) 参数2(value)
		var option = new Option(provinces[i], i);
		selTag.appendChild(option);
	}
}

// 参数1: 需要添加市信息的select列表的id
// 参数2: 省级下拉框所选项的value值(数组的下标)
function addCities(selId, value) {
	// 1. 获取到需要被添加的select列表对象
	var selTag = document.getElementById(selId);
	// 清空, 数组的length是可以动态改变的
	selTag.options.length = 1;
	if (value != "" && value != undefined) {
		for (var i = 0; i < cities[value].length; i++) {
			var option = new Option(cities[value][i], i);
			selTag.appendChild(option);
		}
	}
}