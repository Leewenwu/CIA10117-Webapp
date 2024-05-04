<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.order.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
OrderVO ordVO = (OrderVO) request.getAttribute("OrderVO");
%>
<html>
<head>

<!-- 引入flatpickr CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css"
	rel="stylesheet">
<!-- 引入flatpickr JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<title>新增訂單</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
}

.form-container {
	width: 400px;
	margin: 50px auto;
	padding: 20px;
	background-color: #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h2 {
	text-align: center;
	color: #333;
}

form {
	display: flex;
	flex-direction: column;
}

label {
	margin-top: 10px;
}

input[type="text"], input[type="email"] {
	padding: 10px;
	margin-top: 5px;
	border: 1px solid #ddd;
	border-radius: 5px;
}

button {
	padding: 10px;
	margin-top: 20px;
	background-color: #0056b3;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

button:hover {
	background-color: #004494;
}
</style>
</head>
<body>




	<div class="form-container">

		<h2>新增訂單</h2>


		<c:if test="${not empty errorMsgs}">
			<font style="color: red"></font>
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li style="color: red">${message}</li>
				</c:forEach>
			</ul>
		</c:if>

		<form action="order.do" method="post">

			<label for="sessionid">場次編號:依預定時間自動選擇</label> <input type="text"
				id="sessionid" name="sessionid" readonly> <label
				for="memberid">會員編號1001-1007:</label> <select name="memberid"
				id="memberid">
				<option value="1001">1001</option>
				<option value="1002">1002</option>
				<option value="1003">1003</option>
				<option value="1004">1004</option>
				<option value="1005">1005</option>
				<option value="1006">1006</option>
				<option value="1007">1007</option>
			</select>

			<!--Bean選單  
				<jsp:useBean id="ordSvc" scope="page"
				class="com.order.model.OrderService" />	
			</select> <label for="memberid">會員編號1001-1007:</label> <select name="memberid"
				id="memberid">
				<c:forEach var="orderVO" items="${ordSvc.all}">
					<option value="${orderVO.memberid}">${orderVO.memberid}
				</c:forEach>
			</select>
 -->

			<!--  <label for="memberid">會員編號:</label>
    <jsp:useBean id="ordSvc1" scope="page" class="com.order.model.OrderService" />        
       <select size="3" name="memberid">
         <c:forEach var="orderVO" items="${ordSvc1.all}" > 
          <option value="${orderVO.memberid}">${orderVO.memberid}
         </c:forEach>   
       </select>          -->





			<label for="orderdate">訂單日期:</label> <input type="date"
				name="orderdate" id="orderdate">

			<script>
				// 獲取當前日期
				var today = new Date();
				var dd = String(today.getDate()).padStart(2, '0');
				var mm = String(today.getMonth() + 1).padStart(2, '0'); // 月份是從0開始的
				var yyyy = today.getFullYear();

				today = yyyy + '-' + mm + '-' + dd;

				// 設置input元素的值為當前日期
				document.getElementById('orderdate').value = today;
			</script>



			<label for="Number">人數:</label> <input type="text" name="number">

			<label for="Bookingdate">預定日期:(請選擇)</label> <input
				type="datetime-local" name="bookingdate" id="bookingdate">


			<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
			<script>
				flatpickr(
						"#bookingdate",
						{
							enableTime : true,
							noCalendar : false,
							dateFormat : "Y-m-d H:i",
							time_24hr : true,
							minuteIncrement : 30,
							inline : true,
							defaultDate : "10:00",
							minTime : "10:00",
							maxTime : "19:00",
							minDate : new Date().fp_incr(3),
							maxDate : new Date().fp_incr(60),
							onChange : function(selectedDates, dateStr,
									instance) {
								const minutes = selectedDates[0].getMinutes();
								if (minutes !== 0 && minutes !== 30) {
									const adjustedDate = new Date(
											selectedDates[0]
													.setMinutes(minutes < 30 ? 0
															: 30));
									instance.setDate(adjustedDate, false);
								}

								const hour = selectedDates[0].getHours();
								const sessionidValue = hour < 14 ? "101"
										: "102";
								document.getElementById("sessionid").value = sessionidValue;

								req.setAttribute("sessionid", sessionid);
							}
						});
			</script>


			<label for="Ordernote">備註:</label> 
			<input type="TEXT"	name="ordernote"> 
			
			
			
			<input type="hidden" name="action"				value="insert">
			<button type="submit" value="送出">新增</button>

			<h4>
				<a href="select_page.jsp">回首頁</a>
			</h4>





		</form>
	</div>
</body>
</html>