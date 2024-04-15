<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.member.*"%>

<html>
<head>
<title>�ק�|�����</title>
<style>
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

body {
       font-family: 'Arial', sans-serif;
        background-color: #f4f4f4;
	
	
	
}
</style>
</head>
<body>
	<h2>�ק�|�����</h2>
	<form
		action="${pageContext.request.contextPath}/member/member.do?action=getUpdate"
		method="post">
		<input type="hidden" name="action" value="getUpdate"> 
		<input type="hidden" name="memId" value="${member.memId}">
		<table>
			<tr>
				<th>�|���s��:</th>
				<td>${member.memId}</td>
			</tr>
			<tr>
				<th>�m�W:</th>
				<td><input type="text" name="mName" value="${member.mName}"></td>
			</tr>
			<tr>
				<th>�b��:</th>
				<td><input type="hidden" name="mAccount"
					value="${member.mAccount}"> ${member.mAccount}</td>
			</tr>
			<tr>
				<th>�K�X:</th>
				<td><input type="password" name="mPassword"
					value="${member.mPassword}"></td>
			</tr>
			<tr>
				<th>�H�c:</th>
				<td><input type="email" name="email" value="${member.email}"></td>
			</tr>
			<tr>
				<th>�q��:</th>
				<td><input type="text" name="phone" value="${member.phone}"></td>
			</tr>
			<tr>
				<th>�a�}:</th>
				<td><input type="text" name="address" value="${member.address}"></td>
			</tr>
			<tr>
				<th>�b�����A:</th>
				<td>
			 <select name="mState">
            <option value="0" ${member.mState == 0 ? 'selected' : ''}>���{��</option>
            <option value="1" ${member.mState == 1 ? 'selected' : ''}>�q�L�{��</option>
            <option value="2" ${member.mState == 2 ? 'selected' : ''}>���v</option>
     	   </select>			
     	   	</td>
			</tr>
			<tr>
				<th>�ʧO:</th>
				<td><select name="gender">
						<option value="M" ${member.gender == 'M' ? 'selected' : ''}>�k</option>
						<option value="F" ${member.gender == 'F' ? 'selected' : ''}>�k</option>
				</select></td>
			</tr>
			<tr>
				<th>�ͤ�:</th>
				<td><input type="date" name="birthday"
					value="<fmt:formatDate value='${member.birthday}' pattern='yyyy-MM-dd'/>"></td>
			</tr>
			<tr>
				<td colspan="2">
				
				
				<input type="submit" value="�O�s�ק�"> 
				
				<input
					type="button" value="����"
					onclick="location.href='${pageContext.request.contextPath}/member/member.do?action=getAll'">




				</td>
			</tr>
		</table>
	</form>
</body>
</html>
