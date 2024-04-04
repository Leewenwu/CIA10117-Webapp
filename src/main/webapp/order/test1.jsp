<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="Big5"%>
<%@ page import="com.order.controller.*"%>
<html>
<head>
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
    <form action="someServletURL" method="post">
        <label for="Sessionid">場次編號(101-104):</label>
        <input type="text"  value=""  >
        
        <label for="Memberid">會員編號:</label>
        <input type="text" name="empId">
        
          <label for="Orderdate">訂單日期:</label>
        <input type="date"  id="Orderdate" name="Orderdate">
        
        <script>
		  // 獲取當前日期
		  var today = new Date();
		  var dd = String(today.getDate()).padStart(2, '0');
		  var mm = String(today.getMonth() + 1).padStart(2, '0'); // 月份是從0開始的
		  var yyyy = today.getFullYear();
		
		  today = yyyy + '-' + mm + '-' + dd;
		  
		  // 設置input元素的值為當前日期
		  document.getElementById('Orderdate').value = today;
		</script>
        
        
        
        <label for="Number">人數:</label>
        <input type="text"  name="">
        
        <label for="Bookingdate">預定日期:</label>
        <input type="date" name="">
        	
        <label for="Ordernote">備註:</label>
        <input type="TEXT"  name="">
        
        <button type="submit">Add Employee</button>
    </form>
</div>
</body>
</html>
