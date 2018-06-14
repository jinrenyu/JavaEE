Date.prototype.format = function(fmt) {
    var o = {
        "M+": this.getMonth() + 1,
        "d+": this.getDate(),
        "h+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds(),
        "q+": Math.floor((this.getMonth() + 3) / 3),
        "S": this.getMilliseconds()
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(-RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)){
            if (RegExp.$1.length == 1) {
                fmt = fmt.replace(RegExp.$1, o[k]);
            } else {
                fmt = fmt.replace(RegExp.$1, ("00" + o[k]).substr(("" + o[k]).length));
            }
        }
    }
    return fmt;
}