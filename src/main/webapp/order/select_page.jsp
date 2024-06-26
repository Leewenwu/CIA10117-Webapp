<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<html>
<head>
<title>首頁</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: yellow;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: yellow;
    display: inline;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>餐廳訂單查詢</h3></td></tr>
</table>


<h3>資料查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllOrder.jsp'>顯示所有訂單</a>  <br><br></li>
  
  
  
  <li>
    <FORM METHOD="post" ACTION="order.do" >
        <b>輸入訂單編號 (從2001開始):</b>
        <input type="text" name="ordid">
        
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="ordSvc" scope="page" class="com.order.model.OrderService" />
   
  <li>
     <FORM METHOD="post" ACTION="order.do" >
       <b>選擇訂單編號:</b>
       <select size="1" name="ordid">
               <c:forEach var="OrderVO" items="${ordSvc.all}" > 
       		   <option value="${OrderVO.orderid}">
       		   	${OrderVO.orderid}
        	 </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  
  <li>
     <FORM METHOD="post" ACTION="order.do" >
       <b>預定日期查詢:</b>
       <select size="1" name="ordid">
       
       
         <c:forEach var="orderVO" items="${ordSvc.all}" > 
   <!--   	<option  value="${orderVO.orderid}">
       			 	  ${orderVO.bookingdate} -->
			   <option value="${orderVO.orderid}">
				  <fmt:formatDate value="${orderVO.bookingdate}" pattern="yyyy-MM-dd HH:mm" />
			   </option>
			   
			   
         </c:forEach>   	
         
         
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>

<fmt:formatDate value="${orderVO.bookingdate}" pattern="yyyy-MM-dd HH:mm" />

<h3>新增</h3>



<ul>
  <li><a href='addOrder.jsp'>新增一筆訂單</a> </li>
</ul>

</body>
</html>