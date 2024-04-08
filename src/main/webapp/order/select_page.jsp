<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<html>
<head>
<title>����</title>

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
   <tr><td><h3>�\�U�q��d��</h3></td></tr>
</table>


<h3>��Ƭd��:</h3>
	
<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllOrder.jsp'>��ܩҦ��q��</a>  <br><br></li>
  
  
  
  <li>
    <FORM METHOD="post" ACTION="order.do" >
        <b>��J�q��s�� (�q2001�}�l):</b>
        <input type="text" name="ordid">
        
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="�e�X">
    </FORM>
  </li>

  <jsp:useBean id="ordSvc" scope="page" class="com.order.model.OrderService" />
   
  <li>
     <FORM METHOD="post" ACTION="order.do" >
       <b>��ܭq��s��:</b>
       <select size="1" name="ordid">
               <c:forEach var="orderVO" items="${ordSvc.all}" > 
       		   <option value="${orderVO.orderid}">
       		   	${orderVO.orderid}
        	 </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
    </FORM>
  </li>
  
  
  <li>
     <FORM METHOD="post" ACTION="order.do" >
       <b>�w�w����d��:</b>
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
       <input type="submit" value="�e�X">
     </FORM>
  </li>
</ul>

<fmt:formatDate value="${orderVO.bookingdate}" pattern="yyyy-MM-dd HH:mm" />

<h3>�s�W</h3>



<ul>
  <li><a href='addOrder.jsp'>�s�W�@���q��</a> </li>
</ul>

</body>
</html>