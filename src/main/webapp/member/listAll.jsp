<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.member.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<html>
<head>
<title>�Ҧ��q����</title>

<style>
table#table-1 {
	background-color: #ADD8E6; /* �H�Ŧ�I�� */
	border: 2px solid black;
	text-align: center;
	width: 90%; /* ���e�׺��� */
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
				<h3>�Ҧ����</h3>
				<h4>
					<a href="index.jsp">�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>�|���s��</th>
			<th>�|���m�W</th>
			<th>�b��</th>
			<th>�K�X</th>
			<th>�H�c</th>
			<th>�q��</th>
			<th>�a�}</th>
			<th>�b�����A</th>
			<th>�ʧO</th>

			<th>�ͤ�</th>
			<th>�ϥΪ̷Ӥ�</th>
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
		            �k
		        </c:when>
						<c:otherwise>
		            �k
		        </c:otherwise>
					</c:choose></td>
				<td>${member.birthday}</td>
				<td>${member.image}</td>
				<td><a
					href="${pageContext.request.contextPath}/member/member.do?action=getOne&memId=${member.memId}">�ק�</a>
				</td>


			</tr>
		</c:forEach>
	</table>
</body>
</html>