<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.order.model.*"%>


<%
    OrderService ordSvc = new OrderService();
    List<OrderVO> list = ordSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>�Ҧ����u���</title>

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
  th, td ,tr{
    padding: 10px;
    
    
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>


<table id="table-1">
	<tr><td>
		 <h3>�Ҧ���� listAllorder.jsp</h3>
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
		<th></th>
		<th></th>
	</tr>

	<c:forEach var="orderVO" items="${list}" >
		
		<tr>
			<td>${orderVO.orderid}</td>
			<td>${orderVO.sessionid}</td>
			<td>${orderVO.memberid}</td>
			<td>${orderVO.orderdate}</td>
			<td>${orderVO.number}</td>
			<td>${orderVO.orderstate}</td>
			<td>${orderVO.bookingdate}</td>
			<td>${orderVO.ordernote}</td> 
			<td>
			
			
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/ord/ord.do" style="margin-bottom: 0px;">
			     <input type="submit" value="�ק�">
			     <input type="hidden" name="empno"  value="${empVO.empno}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/emp/emp.do" style="margin-bottom: 0px;">
			     <input type="submit" value="�R��">
			     <input type="hidden" name="empno"  value="${empVO.empno}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
			
		</tr>
	</c:forEach>
</table>


</body>
</html>