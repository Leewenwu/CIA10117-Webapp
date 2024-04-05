<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.order.model.*"%>
<%@ page import="java.util.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  OrderVO ordVO = (OrderVO) request.getAttribute("OrderVO"); 


%>

<html>
<head>
<title>員工資料 - listOneEmp.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 1000px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁暫練習採用 Script 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>員工資料 - listOneEmp.jsp</h3>
		 <h4><a href="select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>訂單編號</th>
		<th>場次編號</th>
		<th>會員便號</th>
		<th>日期</th>
		<th>人數</th>
		<th>訂單狀態</th>
		<th>預定日期</th>
		<th>備註</th>
	</tr>
	<tr>
		<td><%=ordVO.getOrderid()%></td>
		<td><%=ordVO.getSessionid()%></td>
		<td><%=ordVO.getMemberid()%></td>
		<td><%=ordVO.getOrderdate()%></td>
		<td><%=ordVO.getNumber()%></td>
		<td><%=ordVO.getOrderstate()%></td>
		<td><%=ordVO.getBookingdate()%></td>	
		<td><%=ordVO.getOrdernote()%></td>
	</tr>
</table>

</body>
</html>