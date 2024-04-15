<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.member.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



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
        <a href="${pageContext.request.contextPath}/member/member.do?action=getAll">員工管理</a>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="index.jsp">回首頁</a>
   
    </div>

 <div class="main-content">
 <h1>員工管理系統</h1>
	<table>
	
		<tr>
			<th>會員編號</th>
			<th>會員姓名</th>
			<th>帳號</th>
			<th>密碼</th>
			<th>信箱</th>
			<th>電話</th>
			<th>地址</th>
			<th>帳號狀態</th>
			<th>性別</th>

			<th>生日</th>
			<th></th>
<!-- 			<th></th> -->


		</tr>

		<c:forEach var="member" items="${memberList}">

			<tr>
				<td>${member.memId}</td>
				<td>${member.mName}</td>
				<td>${member.mAccount}</td>
				<td>${member.mPassword}</td>
				<td>${member.email}</td>
				<td>${member.phone}</td>
				<td>${member.address}</td>
				<td>${member.mState}</td>
		
				<td><c:choose>
						<c:when test="${member.gender}">
		            女
		        </c:when>
						<c:otherwise>
		            男
		        </c:otherwise>
					</c:choose></td>
				<td>${member.birthday}</td>
<%--圖片再開	 			<td>${member.image}</td> --%>


				<td>
<form method="post" action="${pageContext.request.contextPath}/member/member.do">
    <input type="hidden" name="action" value="getOne">
    <input type="hidden" name="memId" value="${member.memId}">
    <input type="submit" value="修改">
</form>			
				</td>
				
				
			</tr>
		</c:forEach>
	</table>
	   </div>
</body>
</html>