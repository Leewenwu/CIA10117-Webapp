<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.order.model.*"%>
<%@ page import="java.util.*"%>


<%
  OrderVO ordVO = (OrderVO) request.getAttribute("OrderVO"); 

%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>修改 </title>

<style>
  table#table-1 {
    width: 450px;
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
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>資料修改 </h3>
		 <h4><a href="select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料修改:</h3>

<%-- 錯誤表列 --%>
<%-- <c:if test="${not empty errorMsgs}"> --%>
<!-- 	<font style="color:red">請修正以下錯誤:</font> -->
<!-- 	<ul> -->
<%-- 		<c:forEach var="message" items="${errorMsgs}"> --%>
<%-- 			<li style="color:red">${message.value}</li> --%>
<%-- 		</c:forEach> --%>
<!-- 	</ul> -->
<%-- </c:if> --%>

<FORM METHOD="post" ACTION="order.do" name="form1">
<table>
    <tr>
		<td>訂單編號:<font color=red><b>*</b></font></td>
		<td>${param.orderid}</td>
	</tr>
	
	<tr>
		<td>備註:</td>
		<td><input type="TEXT" name="ordernote" value="${param.ordernote}" size="45"/></td> <td></td>
	</tr>
	
	

</table>
<br>
<input type="hidden" name="action" value="update">
<input type="text" name="orderid" value="${param.orderid}">
<input type="submit" value="送出修改"></FORM>
</body>


	
</html>