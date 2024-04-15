<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.member.*"%>

<html>
<head>
<title>�ק�|�����</title>
<style>
table {
	width: 60%;
	margin: 20px; /* �~���B���ѤW�U���j */
	border-collapse: collapse;
	background-color: #f9f9f9;
}

th {
	width: 100px;
}

th, td {
	padding: 10px;
	border: 1px solid #ddd;
}

body {
	font-family: 'Arial', sans-serif;
	background-color: #f4f4f4;
}

.error-message {
	color: red;
	position: absolute; /* �ϥε���w�� */
	font-size: 0.8em; /* ���p����r�j�p */
	margin-left: 5px; /* �P��J�دd�@�Ƕ��j */
}

.input {
	width: 100%;
	box-sizing: border-box; /* �T�Opadding���|�������W�X���w�e�� */
}
</style>
</head>
<body>
	<h2>�ק�|�����</h2>
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
				<th>�|���s��:</th>
				<td>${param.memId}</td>
			</tr>
			<tr>
				<th>�m�W:</th>
				<td><input type="text" name="mName" class="input-field"
					value="${param.mName}"> <span class="error-message">${errorMsgs.mName}</span>
				</td>
			</tr>
			<tr>
				<th>�b��:</th>
				<td><input type="hidden" name="mAccount"
					value="${param.mAccount}"> ${param.mAccount}</td>
			</tr>
			<tr>
				<th>�K�X:</th>
				<td><input type="text" name="mPassword" class="input-field" 
					value="${param.mPassword}"> <span class="error-message">${errorMsgs.mPassword}</span>
				</td>
			</tr>
			<tr>
				<th>�H�c:</th>
				<td><input type="email" name="email" class="input-field"   style="width:300px"
					value="${param.email}"> <span class="error-message">${errorMsgs.email}</span>
				</td>
			</tr>
			<tr>
				<th>�q��:</th>
				<td><input type="text" name="phone" class="input-field"
					value="${param.phone}"> <span class="error-message">${errorMsgs.phone}</span>
				</td>
			</tr>
			<tr>
				<th>�a�}:</th>
				<td><input type="text" name="address" class="input-field"
					value="${param.address}"> <span class="error-message">${errorMsgs.address}</span>
				</td>
			</tr>
			<tr>
				<th>�b�����A:</th>
				<td><select name="mState">
						<option value="0" ${param.mState == 0 ? 'selected' : ''}>���{��</option>
						<option value="1" ${param.mState == 1 ? 'selected' : ''}>�q�L�{��</option>
						<option value="2" ${param.mState == 2 ? 'selected' : ''}>���v</option>
				</select></td>
			</tr>
			<tr>
				<th>�ʧO:</th>
				<td><select name="gender">

						<option value="false" ${param.gender ? 'selected' : ''}>�k</option>
						<option value="true" ${param.gender ? 'selected' : ''}>�k</option>
				</select></td>
			</tr>
			<tr>
				<th>�ͤ�:</th>
				<td><input type="date" name="birthday"
					value='${param.birthday}' pattern='yyyy-MM-dd' /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="�e�X�ק�"> <input
					type="hidden" name="action" value="getUpdate"> <input
					type="hidden" name="memId" value="${param.memId}"> <input
					type="button" value="����"
					onclick="location.href='${pageContext.request.contextPath}/member/member.do?action=getAll'">

				</td>
			</tr>
		</table>
	</form>
</body>
</html>
