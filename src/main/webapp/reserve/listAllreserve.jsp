<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.reserve.*"%>
<html>
<head>
<title>所有訂單資料</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: 'Arial', sans-serif;
	background-color: #f4f4f4;
}

.sidebar {
	width: 200px;
	background: #333;
	color: #fff;
	height: 100vh;
	position: fixed;
}

.sidebar h2 {
	padding: 20px;
	background-color: #444;
}

.sidebar a {
	padding: 10px 20px;
	display: block;
	color: #ddd;
	text-decoration: none;
}

.sidebar a:hover {
	background: #555;
}

.main-content {
	margin-left: 200px;
	padding: 20px;
	background: #eaeaea;
}

table {
	width: 100%;
	border-collapse: collapse;
	background: white;
	margin-top: 20px;
}

th, td {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

th {
	background-color: #f2f2f2;
}

tr:nth-child(even) {
	background-color: #f9f9f9;
}

.button-group {
	text-align: right;
}

.button-group button {
	padding: 8px 16px;
	margin: 5px;
	border: none;
	background-color: #5cb85c;
	color: white;
	border-radius: 4px;
	cursor: pointer;
}

.button-group button:hover {
	background-color: #4cae4c;
}
</style>
</head>

<body bgcolor='#ADD8E6'>



	<div class="sidebar">
		<h2>標題</h2>

		<a href="#">2</a> <a href="index.jsp">回首頁</a>

	</div>




	<div class="main-content">
		<h1>訂單管理系統</h1>
		<c:if test="${resPageQty > 0}">
			<b><font color=red>第${currentPage}/${resPageQty}頁</font></b>
		</c:if>
		<br>

		<table>
			<tr>
				<th>餐廳訂單編號</th>
				<th>餐廳場次編號</th>
				<th>會員編號</th>
				<th>訂單日期</th>
				<th>訂單人數</th>
				<th>訂單狀態</th>
				<th>預訂日期</th>
				<th>訂單備註</th>
				<th></th>

			</tr>

			<c:forEach var="ReserveOrder" items="${resList}">

				<tr>
					<td>${ReserveOrder.reserveOrderId}</td>
					<td>${ReserveOrder.reserveSession.reserveSessionId},${ReserveOrder.reserveSession.sessionTime}</td>
					<td>${ReserveOrder.memberId}</td>
					<td>${ReserveOrder.reserveOrderDate}</td>
					<td>${ReserveOrder.reserveNumber}</td>
					<td>${ReserveOrder.reserveOrderState}</td>
					<td><fmt:formatDate value="${ReserveOrder.bookingDate}" pattern="yyyy-MM-dd HH:mm" /></td>
					<td>${ReserveOrder.orderNote}</td>



					<td>





						<form method="post"
							action="${pageContext.request.contextPath}/reserve/reserve.do">
							<input type="hidden" name="action" value="getOne"> <input
								type="hidden" name="" value="${member.memId}"> <input
								type="submit" value="修改">
						</form>
					</td>
				</tr>
			</c:forEach>




		</table>
	</div>
</body>
</html>