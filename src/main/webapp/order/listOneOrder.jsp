<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.order.model.*"%>
<%@ page import="java.util.*"%>


<%
  OrderVO ordVO = (OrderVO) request.getAttribute("OrderVO"); 

%>

<html>
<head>
<title>�q���� </title>

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


<table id="table-1">
	<tr><td>
		 <h3>���u��� </h3>
		 <h4><a href="select_page.jsp">�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>�q��s��</th>
		<th>�����s��</th>
		<th>�|���K��</th>
		<th>���</th>
		<th>�H��</th>
		<th>�q�檬�A</th>
		<th>�w�w���</th>
		<th>�Ƶ�</th>
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