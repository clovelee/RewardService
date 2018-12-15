$(function() {
	getOrgPoints("1");
});

/**
 * 获取机构详情
 * @param account
 * @returns
 */
function getOrgPoints(id) {
	var param = {};
	param["id"] = id;
	//alert(JSON.stringify(param));
	$.ajax({
        type: "POST",  
        url: "points/getOrgPoints.do",   
        data: param,
		datatype: "json",
		async: false,
        success: function(data) { 
        	//alert(data);
        	//loadInfo(JSON.parse(data));
        	loadInfo(data);
        },
        error: function () {
        	$.jBox.error("获取机构详情异常，请联系管理员", '提示');
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
