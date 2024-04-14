<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.member.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<html>
<head>
<title>所有訂單資料</title>

<style>
table#table-1 {
	background-color: #ADD8E6; /* 淡藍色背景 */
	border: 2px solid black;
	text-align: center;
	width: 90%; /* 表格寬度滿版 */
}

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
	width: 90%;
	background-color: #87CEFA;
	margin-top: 5px;
	margin-bottom: 5px;
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td, tr {
	padding: 15px;
	text-align: center;
}
</style>

</head>

<body bgcolor='#ADD8E6'>


	<table id="table-1">
		<tr>
			<td>
				<h3>所有資料</h3>
				<h4>
					<a href="index.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

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
			<th>使用者照片</th>
			<th></th>


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
		            男
		        </c:when>
						<c:otherwise>
		            女
		        </c:otherwise>
					</c:choose></td>
				<td>${member.birthday}</td>
				<td>${member.image}</td>
				<td><a
					href="${pageContext.request.contextPath}/member/member.do?action=getOne&memId=${member.memId}">修改</a>
				</td>


			</tr>
		</c:forEach>
	</table>
</body>
</html>