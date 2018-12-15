$(function() {
	getTransactions("1");
});

/**
 * 获取用户账单列表
 * @param id
 * @returns
 */
function getTransactions(issueOrgId) {
	var param = {};
	param["issueOrgId"] = issueOrgId;
	//alert(JSON.stringify(param));
	$.ajax({
        type : "POST",  
        url : "points/getTransactions.do",   
        data : param,
		datatype : "json",
		async:false,
        success : function(data) { 
        	//alert(data);
        	//alert(JSON.stringify(data));
        	loadList(data)
        },
        error : function () {
        	$.jBox.error("获取用户账单列表异常，请联系管理员", '提示');
        }
	});	
}

/**
 * 渲染页面
 * @returns
 */
function loadList(data) {
	html = "";
	for (var i = 0 ; i < data.length ; i++) {
		html += "<tr>";
		html += "<td>"+data[i].Record.id+"</td>";
		html += "<td>"+data[i].Record.issueorgname+"</td>";
	    html += "<td>"+data[i].Record.fromname+"</td>";
	    if (data[i].Record.fromrole == "0") {
	    	html += "<td>发行机构</td>";
	    }else if (data[i].Record.fromrole == "1") {
	    	html += "<td>服务机构</td>";
	    }else if (data[i].Record.fromrole == "2") {
	    	html += "<td>用户</td>";
	    }else {
	    	html += "<td>错误的角色</td>";
	    }
	    html += "<td>"+data[i].Record.toname+"</td>";
	    if (data[i].Record.torole == "0") {
	    	html += "<td>发行机构</td>";
	    }else if (data[i].Record.torole == "1") {
	    	html += "<td>服务机构</td>";
	    }else if (data[i].Record.torole == "2") {
	    	html += "<td>用户</td>";
	    }else {
	    	html += "<td>错误的角色</td>";
	    }
		html += "<td>"+data[i].Record.number+"</td>";
		html += "<td>"+data[i].Record.time+"</td>";
	    html += "</tr>";
	}
	$("#userList").html(html);
}