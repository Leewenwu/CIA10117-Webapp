<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-TW">
<head>
    <%@ include file="/frontend/head.jsp" %>
</head>
<body class="main-layout">
    <%@ include file="/frontend/header.jsp" %>
    

<div>
   <!-- 最新消息 -->
   <div class="news-section">
      <div class="container">
         <h2>最新消息</h2>
         <!-- 新聞項目 -->
         <div class="news-item">
            <img src="path-to-your-image.jpg" alt="news image">
            <div class="news-content">
               <h3>新聞標題一</h3>
               <p class="date">2024.04.15 - 2024.12.31</p>
               <p>這裡是關於新聞標題一的簡要內容，點擊查看全文。</p>
               <a href="link-to-full-article.html" class="read-more">觀看全文</a>
            </div>
         </div>
         <!-- 更多新聞項目... -->
      </div>
   </div>
</div>

    <%@ include file="/frontend/footer.jsp" %>
</body>
</html>
