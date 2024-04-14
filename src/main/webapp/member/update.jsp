<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.member.*"%>

<html>
<head>
<title>修改會員資料</title>
<style>
table {
	width: 90%;
	background-color: #87CEFA;
	margin-top: 5px;
	margin-bottom: 5px;
	border-collapse: collapse;
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 15px;
	text-align: left;
}

body {
	background-color: #ADD8E6;
}
</style>
</head>
<body>
	<h2>修改會員資料</h2>
	<form
		action="${pageContext.request.contextPath}/member/member.do"
		method="post">
		<input type="hidden" name="action" value="getUpdate"> 
		<input type="hidden" name="memId" value="${member.memId}">
		<table>
			<tr>
				<th>會員編號:</th>
				<td>${member.memId}</td>
			</tr>
			<tr>
				<th>姓名:</th>
				<td><input type="text" name="mName" value="${member.mName}"></td>
			</tr>
			<tr>
				<th>帳號:</th>
				<td><input type="hidden" name="mAccount"
					value="${member.mAccount}"> ${member.mAccount}</td>
			</tr>
			<tr>
				<th>密碼:</th>
				<td><input type="password" name="mPassword"
					value="${member.mPassword}"></td>
			</tr>
			<tr>
				<th>信箱:</th>
				<td><input type="email" name="email" value="${member.email}"></td>
			</tr>
			<tr>
				<th>電話:</th>
				<td><input type="text" name="phone" value="${member.phone}"></td>
			</tr>
			<tr>
				<th>地址:</th>
				<td><input type="text" name="address" value="${member.address}"></td>
			</tr>
			<tr>
				<th>帳號狀態:</th>
				<td><input type="text" name="mState" value="${member.mState}"></td>
			</tr>
			<tr>
				<th>性別:</th>
				<td><select name="gender">
						<option value="M" ${member.gender == 'M' ? 'selected' : ''}>男</option>
						<option value="F" ${member.gender == 'F' ? 'selected' : ''}>女</option>
				</select></td>
			</tr>
			<tr>
				<th>生日:</th>
				<td><input type="date" name="birthday"
					value="<fmt:formatDate value='${member.birthday}' pattern='yyyy-MM-dd'/>"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="保存修改"> <input
					type="button" value="取消"
					onclick="location.href='${pageContext.request.contextPath}/member/member.do?action=getAll'">




				</td>
			</tr>
		</table>
	</form>
</body>
</html>
