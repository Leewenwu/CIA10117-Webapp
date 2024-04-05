<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.order.model.*"%>

<%
  OrderVO ordVO = (OrderVO) request.getAttribute("OrderVO"); 


%>
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

<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>


	<div class="form-container">
	
    <h2>�s�W�q��</h2>
    <form action="order.do" method="post">
    
        <label for="sessionid">�����s��(101-104):</label>
        <input type="text"    >
        
        
        <label for="memberid">�|���s��:</label>
        <input type="text" >
        
         <label for="orderdate">�q����:</label>
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
        
         <input type="hidden" name="action" value="insert">
        <button type="submit" value="�e�X"> �s�W</button>
        
        
        
   <jsp:useBean id="ordSvc" scope="page" class="com.order.model.OrderService" />
        
        
      
    </form>
</div>
</body>
</html>
