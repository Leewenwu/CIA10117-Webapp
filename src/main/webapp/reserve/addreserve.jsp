<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.reserve.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>

<!-- �ޤJflatpickr CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css"
	rel="stylesheet">
<!-- �ޤJflatpickr JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>

<title>�q��</title>
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

		<h2>�s�W�q��</h2>


		<c:if test="${not empty errorMsgs}">
			<font style="color: red"></font>
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li style="color: red">${message}</li>
				</c:forEach>
			</ul>
		</c:if>

		<form action="reserve.do" method="post">
		
			<label>���եη|���s��</label>
			<input type="text"  name="memId" value="1" > 
	
	
			<label for="sessionId">�����s��:�̹w�w�ɶ��۰ʿ��</label> 
			<input type="text"	id="sessionId" name="sessionId" > 
			<label	for="memId">�|���s��:</label>
			<label for="OrderDate">�q����:</label>
			<input type="date" name="OrderDate" id="OrderDate">

			<script>
				// �����e���
				var today = new Date();
				var dd = String(today.getDate()).padStart(2, '0');
				var mm = String(today.getMonth() + 1).padStart(2, '0'); // ����O�q0�}�l��
				var yyyy = today.getFullYear();

				today = yyyy + '-' + mm + '-' + dd;

				// �]�minput�������Ȭ���e���
				document.getElementById('OrderDate').value = today;
			</script>



			<label for="reserveNumber">�H��:</label> <input type="text" name="reserveNumber">

			<label for="bookingDate">�w�w���:(�п��)</label> <input
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


			<label for="Note">�Ƶ�:</label> <input type="TEXT"	name="Note"> 
				
				
				
			<input type="hidden" name="action"	value="insert">
			<button type="submit" value="�e�X">�s�W</button>

			<h4>
				<a href="${pageContext.request.contextPath}/reserve/reserve.do?action=getAll">�^����</a>
			</h4>





		</form>
	</div>
</body>
</html>