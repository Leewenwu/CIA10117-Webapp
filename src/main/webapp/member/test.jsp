<%-- <%@ page language="java" contentType="text/html; charset=BIG5" --%>
<%--     pageEncoding="BIG5"%> --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>會員管理系統</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        .btn-edit {
            color: #ffa500;
            cursor: pointer;
        }
        .btn-delete {
            color: red;
            cursor: pointer;
        }
    </style>
</head>
<body>

<h2 style="text-align: center;">會員管理系統</h2>

<!-- 會員列表 -->
<table>
    <tr>
        <th>會員ID</th>
        <th>姓名</th>
        <th>電子郵件</th>
        <th>操作</th>
    </tr>
    <!-- 假設這裡有從數據庫獲取的會員資料 -->
    <tr>
        <td>1</td>
        <td>張三</td>
        <td>zhangsan@example.com</td>
        <td>
            <span class="btn-edit">編輯</span> | 
            <span class="btn-delete">刪除</span>
        </td>
    </tr>
    <!-- 更多會員資料 -->
</table>

<!-- 新增會員表單（可以放在這個頁面或另一個頁面） -->
<!-- 表單代碼 -->

</body>
</html>
