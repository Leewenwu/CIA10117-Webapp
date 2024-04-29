<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.member.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<html>
<head>
<title>�Ҧ��q����</title>
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
        <h2>���D</h2>
        <a href="${pageContext.request.contextPath}/member/member.do?action=getAll">�|���޲z</a>
        <a href="${pageContext.request.contextPath}/reserve/reserve.do?action=getAll">�\�U�q��޲z</a>
     
        <a href="${pageContext.request.contextPath}/member/index.jsp">�^����</a>
   
    </div>
 
 
 
 
 <div class="main-content">
 <h1>�|���޲z�t��</h1>
<br>
	
 <form method="post" action="${pageContext.request.contextPath}/member/member.do">	
 	
 		<label>�|���m�W�G</label>
 		<input type="text" name="mName"> 	
 		<label>�q�ܡG</label>
 		<input type="text" name="phone"> 
 		<label>�b�����A�G</label>
 		<select name="mState" >
	<option value="" >����</option>
	<option value="0" ${member.mState == 0 ? 'selected' : ''}>���{��</option>
	<option value="1" ${member.mState == 1 ? 'selected' : ''}>�q�L�{��</option>
	<option value="2" ${member.mState == 2 ? 'selected' : ''}>���v</option>
		</select>
		&nbsp;
		<input size="30" type="submit" value="�d��" style="width:50px">
 		  <br>
	<c:if test="${memberPageQty > 0}">
  		<b><font color=red>��${currentpage}/${memberPageQty}��</font></b>
	</c:if> 
		
	<c:if test="${currentpage - 1 != 0}">
		<a href="${pageContext.request.contextPath}/member/member.do?action=getAll&page=${currentpage - 1}">�W�@��</a>&nbsp;
	</c:if>
	
	<c:if test="${currentpage + 1 <= memberPageQty}"> ${currentpage}
		<a href="${pageContext.request.contextPath}/member/member.do?action=getAll&page=${currentpage + 1}">�U�@��</a>&nbsp;
	</c:if>

    <input type="hidden" name="action" value="compositeQuery">
 
 
<!--  ======================================================================= -->
<%-- 	<c:if test="${currentpage + 1 <= QmemberPageQty}">  --%>
<%-- 		<a href="${pageContext.request.contextPath}/member/member.do?action=compositeQuery&page=${Qcurrentpage + 1}">�U�@��</a>&nbsp; --%>
<%-- 	</c:if> --%>



   
</form>		






	
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
			<th>�Ϥ�</th>
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
				<td><c:choose>
				    <c:when test="${member.mState == 0}">
				      ���{��
				    </c:when>
				    <c:when test="${member.mState == 1}">
				      �q�L�{��
				    </c:when>
				    <c:when test="${member.mState == 2}">
				      ���v
				    </c:when>
				    <c:otherwise>
				      ���`!
				    </c:otherwise>
				  </c:choose></td>
		
				<td><c:choose>
						<c:when test="${member.gender}">
		            �k
		        </c:when>
						<c:otherwise>
		            �k
		        </c:otherwise>
					</c:choose></td>
				<td>${member.birthday}</td>
				


 <td>
 <img src="${pageContext.request.contextPath}/member/DBGifReader?memId=${member.memId}" width="100px">
 </td> 
			<td>
<form method="post" action="${pageContext.request.contextPath}/member/member.do">
    <input type="hidden" name="action" value="getOne">
    <input type="hidden" name="memId" value="${member.memId}">
    <input type="submit" value="�ק�">
</form>			
			</td>		
			</tr>
		</c:forEach>
		
		
		
		
	</table>
	   </div>
</body>
</html>