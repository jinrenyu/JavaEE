function getHttpObject() {
    var xhr;
    if (window.XMLHttpRequest) {
        // 针对于IE7以及现在高版本其他的浏览器
        xhr = new XMLHttpRequest();
    } else {
        // 针对IE6之前的浏览器
        xhr = new ActiveXObject("Microsoft.XMLHTTP");
    }
    return xhr;
}

function getOptions(nodeId, url) {
    var node = document.getElementById(nodeId);
    var xhr = getHttpObject();
    xhr.open("get", url);
    xhr.send();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            // 获取返回的json格式的省份列表信息并转换成省份对象
            var options = JSON.parse(xhr.responseText);
            // 循环省份列表对象的信息把对应的信息变成选项卡添加到select组件中
            for (var i = 0; i < options.length; i++) {
                // Option构造函数具有两个参数:
                // 参数1: option中展示的值, 参数2: option的value值
                var opt = new Option(options[i].label, options[i].value);
                node.appendChild(opt);
            }
        }
    }
}