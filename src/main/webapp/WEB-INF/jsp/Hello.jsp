<%@page import="java.util.List"%>

<%@page import="com.teamsankya.ekart.dto.EkartBean"%>
<%@ page contentType="text/html; charset = UTF-8"%>
<html>
<head>
<title>Hello World</title>
<style>

* {
	box-sizing: border-box;
}

body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
	/* background-image: url("imagebg.jpg"); */
	background-color: lightblue; 
}
.topnav {
	overflow: hidden;
	background-color: #333/* #e9e9e9 */;
}

.topnav a {
	float: left;
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd ;
	color: black;
}

.topnav a.active {
	background-color:#4CAF50/*  #2196F3 */;
	color: white;
}
.column {
	float: left;
	width: 33.33%;
	padding: 5px;
}

/* Clearfix (clear floats) */
.row::after {
	content: "";
	clear: both;
	display: table;
}

.pagination {
	display: inline-block;
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	font-size: 12px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}
.pagination
 
a
:hover
:not
 
(
.active
 
)
{
background-color
:
 
#ddd
;


}
</style>
</head>

<body >
<!-- <div class="bg"> -->
		<div class="topnav">
			<a class="active" href="/ekart/index.jsp">Home</a> <a href="#about">About</a> <a
				href="#contact">Contact</a></div>
	<%-- <h2>${productdetail}</h2> --%>


	<%
		List<EkartBean> beans = (List<EkartBean>) request.getAttribute("productdetail");
	%>
	<div class="row">
		<%
			for (EkartBean bean : beans) {
		%>
		<div class="column">
			<tr><img src="rorito.jpeg"/>
				Id:<%=bean.getProductid()%><br> Name:<%=bean.getProductname()%><br>
				Company:<%=bean.getProductcompanyname()%><br> Type:<%=bean.getProductcategory()%><br>
				Price:<%=bean.getProductprice()%>
			</tr>
		</div>

		<%
			}
		%>
	</div>
	<footer>
		<div class="pagination">
			<a href="#">&laquo;</a> <a href="#" class="active">1</a> <a
				href="./2?pid=pen">2</a> <a href="./3?pid=pen">3</a> <a
				href="./4?pid=pen">4</a> <a href="./5?pid=pen">5</a> <a
				href="./6?pid=pen">6</a> <a href="#">&raquo;</a> <br>
			<p>
				Developed by: Nikhil MI <a href="mailto:nikhilmi1994@gmail.com">nikhilmi1994@gmail.com</a>
			</p>
		</div>
	</footer>
</body>
</html>