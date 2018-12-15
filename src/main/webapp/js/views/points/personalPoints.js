$(function() {
	getPersonalPoints("1");
});

/**
 * 获取用户详情
 * @param account
 * @returns
 */
function getPersonalPoints(id) {
	var param = {};
	param["id"] = id;
	//alert(JSON.stringify(param));
	$.ajax({
        type: "POST",  
        url: "points/getPersonalPoints.do",   
        data: param,
		datatype: "json",
		async: false,
        success: function(data) { 
        	//alert(data);
        	//loadInfo(JSON.parse(data));
        	loadInfo(data);
        },
        error: function () {
        	$.jBox.error("获取用户详情异常，请联系管理员", '提示');
        }
	});	
}

/**
 * 渲染页面
 * @returns
 */
function loadInfo(data) {
	$("#name").html(data.name);
	$("#totalnumber").html(data.totalnumber);
	$("#restnumber").html(data.restnumber);
}
