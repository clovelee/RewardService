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
<title>Products</title>
<base href="<%=basePath1 %>" />
<link href="js/views/points/shop/css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/views/points/shop/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="js/views/points/shop/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="BOX SHOP Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<!-- start menu -->
<link href="js/views/points/shop/css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/views/points/shop/js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<!-- start slider -->
<script src="js/views/points/shop/js/responsiveslides.min.js"></script>
 <script>
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true,
      });
    });
    
    function buy(number) {
    	var param = {};
    	param["issueorgid"] = "1";
    	param["fromrole"] = "2";
    	param["torole"] = "1";
    	param["toid"] = "10001";
    	param["number"] = number;
    	//alert(JSON.stringify(param));
    	$.ajax({
            type : "POST",  
            url : "points/buy.do",   
            data : JSON.stringify(param),
    		datatype : "json",
    		async:false,
    		contentType : 'application/json',
            success : function(data) { 
            	alert("SUCCESS");
            },
            error : function () {
            	alert("ERROR");
            }
    	});	
    }
  </script>
<!--end slider -->
<link rel="stylesheet" href="js/views/points/shop/css/flexslider.css" type="text/css" media="screen" />
				<script type="text/javascript">
			$(window).load(function() {
				$("#flexiselDemo").flexisel({
					visibleItems: 5,
					animationSpeed: 1000,
					autoPlay: true,
					autoPlaySpeed: 3000,    		
					pauseOnHover: true,
					enableResponsiveBreakpoints: true,
			    	responsiveBreakpoints: { 
			    		portrait: { 
			    			changePoint:480,
			    			visibleItems: 1
			    		}, 
			    		landscape: { 
			    			changePoint:640,
			    			visibleItems: 2
			    		},
			    		tablet: { 
			    			changePoint:768,
			    			visibleItems: 3
			    		}
			    	}
			    });
			    
			});
		</script>
		<script type="text/javascript" src="js/views/points/shop/js/jquery.flexisel.js"></script>
</head>
<body>
	<div class="header">
		<div class="wrap">
			<div class="header-bottom">
				<div class="search">
					<div class="search2">
					  <form>
						 <input type="text" value="Search for a product, category or brand" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search for a product, category or brand';}"/>
					  </form>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- header-section-ends -->
	<div class="wrap">

	<div class="main">
    <div class="content">
    	<div class="content_top">
    		<div class="heading">
    		<h3>Feature Products</h3>
    		</div>
    		<div class="clearfix"></div>
    	</div>
	      <div class="section group">
				<div class="grid_1_of_4 images_1_of_4">
					 <img src="js/views/points/shop/images/new-pic3.jpg" alt="" />
					 <h2>HTC</h2>
					 <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit</p>
					 <p><span class="price">Points：50</span></p>
				     <div class="button"><span><a onclick="buy('50')" class="details">Buy</a></span></div>
				</div>
				<div class="grid_1_of_4 images_1_of_4">
					 <img src="js/views/points/shop/images/feature-pic2.jpg" alt="" />
					 <h2>HUAWEI</h2>
					 <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit</p>
					 <p><span class="price">Points：198</span></p>
				     <div class="button"><span><a onclick="buy('198')" class="details">Buy</a></span></div>
				</div>
				<div class="grid_1_of_4 images_1_of_4">
					 <img src="js/views/points/shop/images/feature-pic3.jpg" alt="" />
					 <h2>SAMSUNG</h2>
					 <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit</p>
					 <p><span class="price">Points：10</span></p>
				     <div class="button"><span><a onclick="buy('10')" class="details">Buy</a></span></div>
				</div>
				<div class="grid_1_of_4 images_1_of_4">
					 <img src="js/views/points/shop/images/new-pic2.jpg" alt="" />
					 <h2>APPLE4</h2>
					 <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit</p>
					 <p><span class="price">Points：998</span></p>
				     <div class="button"><span><a onclick="buy('998')" class="details">Buy</a></span></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	</div>

</body>
</html>