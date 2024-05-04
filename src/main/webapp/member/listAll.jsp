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
        <a href="${pageContext.request.contextPath}/member/member.do?action=getAll">會員管理</a>
        <a href="${pageContext.request.contextPath}/reserve/reserve.do?action=getAll">餐廳訂位管理</a>
     
        <a href="${pageContext.request.contextPath}/member/index.jsp">回首頁</a>
   
    </div>
 
 
 
 
 <div class="main-content">
 <h1>會員管理系統</h1>
<br>
	
 <form method="post" action="${pageContext.request.contextPath}/member/member.do">	
 	
 		<label>會員姓名：</label>
 		<input type="text" name="mName"> 	
 		<label>電話：</label>
 		<input type="text" name="phone"> 
 		<label>帳號狀態：</label>
 		<select name="mState" >
	<option value="" >全部</option>
	<option value="0" ${member.mState == 0 ? 'selected' : ''}>未認證</option>
	<option value="1" ${member.mState == 1 ? 'selected' : ''}>通過認證</option>
	<option value="2" ${member.mState == 2 ? 'selected' : ''}>停權</option>
		</select>
		&nbsp;
		<input size="30" type="submit" value="查詢" style="width:50px">
 		  <br>
	<c:if test="${memberPageQty > 0}">
  		<b><font color=red>第${currentpage}/${memberPageQty}頁</font></b>
	</c:if> 
		
	<c:if test="${currentpage - 1 != 0}">
		<a href="${pageContext.request.contextPath}/member/member.do?action=getAll&page=${currentpage - 1}">上一頁</a>&nbsp;
	</c:if>
	
	<c:if test="${currentpage + 1 <= memberPageQty}"> ${currentpage}
		<a href="${pageContext.request.contextPath}/member/member.do?action=getAll&page=${currentpage + 1}">下一頁</a>&nbsp;
	</c:if>

    <input type="hidden" name="action" value="compositeQuery">
 
 
<!--  ======================================================================= -->
<%-- 	<c:if test="${currentpage + 1 <= QmemberPageQty}">  --%>
<%-- 		<a href="${pageContext.request.contextPath}/member/member.do?action=compositeQuery&page=${Qcurrentpage + 1}">下一頁</a>&nbsp; --%>
<%-- 	</c:if> --%>



   
</form>		






	
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
			<th>圖片</th>
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
				      未認證
				    </c:when>
				    <c:when test="${member.mState == 1}">
				      通過認證
				    </c:when>
				    <c:when test="${member.mState == 2}">
				      停權
				    </c:when>
				    <c:otherwise>
				      異常!
				    </c:otherwise>
				  </c:choose></td>
		
				<td><c:choose>
						<c:when test="${member.gender}">
		            女
		        </c:when>
						<c:otherwise>
		            男
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
    <input type="submit" value="修改">
</form>			
			</td>		
			</tr>
		</c:forEach>
		
		
		
		
	</table>
	   </div>
</body>
</html>