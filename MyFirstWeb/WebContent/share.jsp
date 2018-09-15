<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="lzz.com.vo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Share</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript">
	
	
	
	
	addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); 
   	function hideURLbar(){
   	 	window.scrollTo(0,1); 
	}




</script>
<script type="application/x-javascript">
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
	 function hideURLbar(){ 
		 window.scrollTo(0,1); 
		 } 




</script>
<!-- bootstrap-css -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!--// bootstrap-css -->
<!-- css -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<!--// css -->
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome icons -->
<!-- font -->
<link href='https://fonts.googleapis.com/css?family=Oswald:400,700,300'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Pacifico'
	rel='stylesheet' type='text/css'>
<!-- //font -->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<!-- parallax -->
<script src="js/SmoothScroll.min.js"></script>
<script src="js/jarallax.js"></script>
<!-- //parallax -->
<script>
	function forward2(obj) {
		var pagenum = obj.value;
		//值不为空
		//是数值
		//大于0
		//小于pageCount
		var pageCount = document.getElementById("pageCount").value;
		var pagesize = 4;
		if (pagenum != "" && !isNaN(pagenum) && parseInt(pagenum) > 0
				&& parseInt(pagenum) <= parseInt(pageCount)) {
			location.href = "PagesQueryServlet?pagenum=" + pagenum
					+ "&pagesize=" + pagesize;
		} else {
			alert("请输入正确的页数");
			obj.value = "";
		}
	}
</script>
</head>
<body>
	<!-- banner -->
	<div class="banner about-bg">
		<div class="header">
			<div class="container">
				<div class="logo">
					<h1>
						<a href="index.html" target="_blank">Our Trips</a>
					</h1>
				</div>
				<div class="top-nav">
					<nav class="navbar navbar-default">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">Menu
					</button>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li><a href="index.jsp">Home</a></li>
							<li><a href="destination.jsp">Destination</a></li>
							<li><a href="PagesQueryServlet">Share</a></li>
							<li><a href="login.jsp">Login In</a></li>
						</ul>
					</div>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!-- //banner -->
	<!-- a-about -->
	<div class="share-bc">
		<div class="a-grid">
			<div class="container">
				<h4>这里有最全面的旅游攻略</h4>
			</div>
		</div>
		<!-- //a-about -->

		<!-- team -->
		<div class="more-bottom">
			<div class="more-bottom-left">
				<div class="top-ten">
					<ol>
						<li><span><a href="#">北京</a></span></li>
						<li><span><a href="#">上海</a></span></li>
						<li><span><a href="#">东京</a></span></li>
						<li><span><a href="#">巴黎</a></span></li>
						<li><span><a href="#">伊斯坦布尔</a></span></li>
						<li><span><a href="#">漠河</a></span></li>
						<li><span><a href="#">三亚</a></span></li>
						<li><span><a href="#">张家界</a></span></li>
						<li><span><a href="#">莫斯科</a></span></li>
						<li><span><a href="#">纽约</a></span></li>
					</ol>
				</div>
				<div class="search-more">
					<span></span><input type="text"  id="destination" name="destination"
						placeholder=" : You can search here" onKeyPress="go(event)"/>
				</div>
			</div>
			<div class="container">
				<div class="more-bottom-grids">
					<%
						Page page1 = (Page) request.getAttribute("page");
					%>
					<input type="hidden" id="pageCount" value="${page1.pageCount}" />
					<table>
						<%
							List<Pages> list1 = (List<Pages>) request.getAttribute("list");
						%>
						<%
							for (Pages p : list1) {
						%>

						<tr class="tr1">
							<td>
								<div class="showpage">
									<span class="imgspan"><img src="images/<%=p.getImgname() %>" height="100%" width="100%"></span>
									<div class="show-title">
										<a class="page-a" href="SingleServlet?id=<%=p.getId()%>" color="black"><h3><%=p.getTitle()%></h3></a>
									</div>
									<div class="show-text"><%=p.getMaintxt()%></div>
								</div>
							</td>
						</tr>

						<%
							}
						%>
						<tr class="tr2" font-famaily="serif">
							<td align="center">共<%=page1.getRecordCount()%>条记录， 共<%=page1.getPageCount()%>页，
								每页显示 4 条记录 <%
								if (page1.getPagenum() == 1) {
							%> 首页 上一页 <%
								} else {
							%> <a href="PagesQueryServlet?pagenum=1&pagesize=4">首页</a>
								<a
								href="PagesQueryServlet?pagenum=<%=page1.getPagenum() - 1%>&pagesize=4">上一页</a>
								<%
									}
									if (page1.getPagenum() == page1.getPageCount()) {
								%> 下一页 尾页 <%
									} else {
								%>
								<a href="PagesQueryServlet?pagenum=<%=page1.getPagenum() + 1%>&4">下一页</a>
								<a href="PagesQueryServlet?pagenum=<%=page1.getPageCount()%>&4">尾页</a>
								<%
									}
								%>
								，当前为第<%=page1.getPagenum()%>页
							</td>
						</tr>
					</table>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- //team -->
	<!-- footer -->
	<div class="footer">
		<div class="foot-area">
			<div class="foot-txt">
				<h4>Copyright @ 啥都不会的新人 2018/7</h4>
			</div>
		</div>
	</div>
	<script>
	function go(event) {
        event = event || window.event;
        if (event.keyCode == 13) {
            if ($('#destination').val() == '') {
                return false;
            }           
            window.location.href = 'servlet?keyword= '+ $('#destination').val() ;
        }
    }
	</script>
</body>
</html>