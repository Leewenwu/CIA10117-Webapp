<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.member.*"%>

<html>
<head>
<title>修改會員資料</title>
<style>
table {
	width: 50%;
	border-collapse: collapse;
	background: white;
	margin-top: 20px;
}

th, td {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
	border-width: 3px;
}

body {
	font-family: 'Arial', sans-serif;
	background-color: #f4f4f4;
}

.error-message {
	color: red;
	font-size: 0.8em;
	margin-top: 10px;
	
}

.input {
	flex: 1;
	margin-right: 10px;
	white-space: nowrap;
}
</style>
</head>
<body>
	<h2>修改會員資料</h2>
<%-- 		<c:if test="${not empty errorMsgs}"> --%>
<!-- 			<font style="color: red"></font> -->
<!-- 			<ul> -->
<%-- 				<c:forEach var="message" items="${errorMsgs}"> --%>
<%-- 					<li style="color: red">${message}</li> --%>
<%-- 				</c:forEach> --%>
<!-- 			</ul> -->
<%-- 		</c:if> --%>
	<form action="member.do" method="post">

		<table>
			<tr>
				<th>會員編號:</th>
				<td>${param.memId}</td>
			</tr>
			<tr>
				<th>姓名:</th>
				
				<td>
				<input type="text" name="mName" class="input" size="20"
					value="${param.mName}"> 
				</td>
			</tr>
	
			<tr>
				<th>帳號:</th>
				<td><input type="hidden" name="mAccount"
					value="${param.mAccount}"> ${param.mAccount}</td>
			</tr>
			<tr>
				<th>密碼:</th>
				<td><input type="text" name="mPassword"
					value="${param.mPassword}"></td>
			</tr>
			<tr>
				<th>信箱:</th>
				<td><input type="email" name="email" value="${param.email}"></td>
			</tr>
			<tr>
				<th>電話:</th>
				<td><input type="text" name="phone" value="${param.phone}"></td>
			</tr>
			<tr>
				<th>地址:</th>
				<td><input type="text" name="address" value="${param.address}"></td>
			</tr>
			<tr>
				<th>帳號狀態:</th>
				<td><select name="mState">
						<option value="0" ${param.mState == 0 ? 'selected' : ''}>未認證</option>
						<option value="1" ${param.mState == 1 ? 'selected' : ''}>通過認證</option>
						<option value="2" ${param.mState == 2 ? 'selected' : ''}>停權</option>
				</select></td>
			</tr>
			<tr>
				<th>性別:</th>
				<td><select name="gender">
				
						<option value="false" ${param.gender ? 'selected' : ''}>男</option>
						<option value="true" ${param.gender ? 'selected' : ''}>女</option>
				</select></td>
			</tr>
			<tr>
				<th>生日:</th>
				<td>
				<input  type="date" name="birthday"	 value='${param.birthday}' pattern='yyyy-MM-dd'/>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="送出修改"> <input
					type="hidden" name="action" value="getUpdate"> <input
					type="hidden" name="memId" value="${param.memId}"> <input
					type="button" value="取消"
					onclick="location.href='${pageContext.request.contextPath}/member/member.do?action=getAll'">




				</td>
			</tr>
		</table>
	</form>
</body>
</html>
