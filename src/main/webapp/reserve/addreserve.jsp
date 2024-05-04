<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.reserve.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>

<!-- 引入flatpickr CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css"
	rel="stylesheet">
<!-- 引入flatpickr JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>

<title>訂位</title>
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

		<form action="reserve.do" method="post">
		
			<label>測試用會員編號</label>
			<input type="text"  name="memId" value="1" > 
	
	
			<label for="sessionId">場次編號:依預定時間自動選擇</label> 
			<input type="text"	id="sessionId" name="sessionId" > 
			<label	for="memId">會員編號:</label>
			<label for="OrderDate">訂單日期:</label>
			<input type="date" name="OrderDate" id="OrderDate">

			<script>
				// 獲取當前日期
				var today = new Date();
				var dd = String(today.getDate()).padStart(2, '0');
				var mm = String(today.getMonth() + 1).padStart(2, '0'); // 月份是從0開始的
				var yyyy = today.getFullYear();

				today = yyyy + '-' + mm + '-' + dd;

				// 設置input元素的值為當前日期
				document.getElementById('OrderDate').value = today;
			</script>



			<label for="reserveNumber">人數:</label> <input type="text" name="reserveNumber">

			<label for="bookingDate">預定日期:(請選擇)</label> <input
				type="datetime-local" name="bookingDate" id="bookingDate">


			<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
			<script>
				flatpickr(
						"#bookingDate",
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
								document.getElementById("sessionId").value = sessionidValue;

								req.setAttribute("sessionId", sessionId);
							}
						});
			</script>


			<label for="Note">備註:</label> <input type="TEXT"	name="Note"> 
				
				
				
			<input type="hidden" name="action"	value="insert">
			<button type="submit" value="送出">新增</button>

			<h4>
				<a href="${pageContext.request.contextPath}/reserve/reserve.do?action=getAll">回首頁</a>
			</h4>





		</form>
	</div>
</body>
</html>