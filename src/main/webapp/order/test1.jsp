<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="Big5"%>
<%@ page import="com.order.controller.*"%>
<html>
<head>
<title>�s�W�q��</title>
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
    <form action="someServletURL" method="post">
        <label for="Sessionid">�����s��(101-104):</label>
        <input type="text"  value=""  >
        
        <label for="Memberid">�|���s��:</label>
        <input type="text" name="empId">
        
          <label for="Orderdate">�q����:</label>
        <input type="date"  id="Orderdate" name="Orderdate">
        
        <script>
		  // �����e���
		  var today = new Date();
		  var dd = String(today.getDate()).padStart(2, '0');
		  var mm = String(today.getMonth() + 1).padStart(2, '0'); // ����O�q0�}�l��
		  var yyyy = today.getFullYear();
		
		  today = yyyy + '-' + mm + '-' + dd;
		  
		  // �]�minput�������Ȭ���e���
		  document.getElementById('Orderdate').value = today;
		</script>
        
        
        
        <label for="Number">�H��:</label>
        <input type="text"  name="">
        
        <label for="Bookingdate">�w�w���:</label>
        <input type="date" name="">
        	
        <label for="Ordernote">�Ƶ�:</label>
        <input type="TEXT"  name="">
        
        <button type="submit">Add Employee</button>
    </form>
</div>
</body>
</html>
