<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-TW">
<head>
<meta charset="UTF-8">
<title>後台管理首頁</title>
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

    .content {
        margin-left: 200px;
        padding: 20px;
    }

    .content h1 {
        color: #333;
    }

    .content p {
        color: #666;
        line-height: 1.6;
    }
</style>
</head>
<body>
    <div class="sidebar">
        <h2>標題</h2>
        <a href="${pageContext.request.contextPath}/member/member.do?action=getAll">會員管理</a>
        <a href="${pageContext.request.contextPath}/reserve/reserve.do?action=getAll">餐廳訂位管理</a>
        <a href="${pageContext.request.contextPath}/reserve/addreserve.jsp">我要訂位</a>
        <a href="#">4</a>

    </div>

    <div class="content">
        <h1>歡迎進入後台管理系統</h1>
        <p>在這裡，你可以進行員工管理、產品管理、訂單處理和查看報表統計等操作。</p>
        <!-- 其他管理信息或統計圖表等... -->
    </div>
</body>
</html>
