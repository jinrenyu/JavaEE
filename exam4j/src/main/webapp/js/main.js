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

function getOptions(nodeId, url, valueType) {
    var node = document.getElementById(nodeId);
    var xhr = getHttpObject();
    xhr.open("get", url);
    xhr.send();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var options = JSON.parse(xhr.responseText);
            for (var i = 0; i < options.length; i++) {
                // Option构造函数具有两个参数:
                // 参数1: option中展示的值, 参数2: option的value值
                var opt = null;
                if (valueType == true) {
                    opt = new Option(options[i].label, options[i].value);
                } else {
                    opt = new Option(options[i].label, options[i].intValue);
                }
                node.appendChild(opt);
            }
        }
    }
}

function setValueById(nodeId, url) {
    var node = document.getElementById(nodeId);
    var xhr = getHttpObject();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            node.value = xhr.responseText;
        }
    }
    xhr.open("get", url);
    xhr.send();
}