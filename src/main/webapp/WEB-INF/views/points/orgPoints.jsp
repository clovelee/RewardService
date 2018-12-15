<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
    String path1 = request.getContextPath();
    String basePath1 = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort() + path1 + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>我的积分-机构中心</title>
<base href="<%=basePath1 %>" />
<!--[if lt IE 9]>
<script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
<![endif]-->
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/general.css">
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/core.css">
    <link rel="stylesheet" href="js/kkpager/kkpager_blue.css">
    <link rel="stylesheet" href="js/zTree_v3/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="js/jbox/jbox.css">
    <script type="text/javascript" src="js/jquery-2.1.4.js"></script>
    <script type="text/javascript" src="js/validate/jquery.validate.min.js"></script>
    <script type="text/javascript" src="js/validate/additional-methods.min.js"></script>
    <script type="text/javascript" src="js/validate/messages_zh.js"></script>
    <script type="text/javascript" src="js/kkpager/kkpager.min.js"></script>
    <script type="text/javascript" src="js/modal/bootstrap-modal.js"></script>
    <script type="text/javascript" src="js/modal/bootstrap-modalmanager.js"></script>
    <script type="text/javascript" src="js/zTree_v3/js/jquery.ztree.core-3.5.js"></script>
    <script type="text/javascript" src="resources/js/organize/managerOrganize.js"></script>
    <script type="text/javascript" src="resources/easyui13/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="resources/easyui13/locale/easyui-lang-en.js"></script>
    <script type="text/javascript" src="resources/artDialog4.1.7/jquery.artDialog.js?skin=chrome"></script>
    <script type="text/javascript" src="js/jbox/jquery.jBox-2.3.min.js"></script>
    <script type="text/javascript" src="js/jbox/jquery.jbox-zh-cn.js"></script>
    
    <script type="text/javascript" src="js/views/points/orgPoints.js"></script>

    <!--[if IE 6]>
<script type="text/javascript" src="Lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('.pngfix,.icon');</script>
<![endif]-->
</head>
<body>
<!-------------------------CONT---------------------------->
<form id="userForm" method="post">
<div class="Edit-cont box-cont">
    <div class="panel panel-default">
        <div class="panel-header">
            <h4>我的积分</h4>
        </div>

        <div class="panel-body">
            <div class="panel panel-primary">
                <div class="panel-header">
                   	<h4>详情</h4>
                </div>
                <div class="panel-body">
                    <div class="user-form">
                         <div class="form-group">
                             <label class="form-label" for="">名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：</label>
                             <span name="name" id="name" style="line-height: 25px;width: 100px;text-align: right;margin-right: 10px;color:#999;vertical-align: middle;">
                             	
                             </span>
                          </div>
                         <div class="form-group">
                             <label class="form-label" for="">账户总额：</label>
                             <span name="totalnumber" id="totalnumber" style="line-height: 25px;width: 100px;text-align: right;margin-right: 10px;color:#999;vertical-align: middle;">
                             	
                             </span>
                         </div>
                         <div class="form-group">
                             <label class="form-label" for="">账户余额：</label>
                             <span name="restnumber" id="restnumber" style="line-height: 25px;width: 100px;text-align: right;margin-right: 10px;color:#999;vertical-align: middle;">
                             	
                             </span>
                         </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</form>
</body>
</html>