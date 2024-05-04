<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-TW">
<head>
    <%@ include file="/frontend/head.jsp" %> 
    <%@ include file="/frontend/header.jsp" %>
    
<style> 
        
    
        .about_img img {
            height: 388.59px;
        }

        .content {
            padding-left: 50px;
            padding-right: 50px;
            padding-top: 30px;
        }

        .logo img {
            width: 100%;
            height: 80px;
            margin-top: -10px;
        }
        .bor {
            border-left: 1px #ccb4b0 solid;
        }

        .google-icon path {
            fill: #847674;
        }
        .carousel-caption {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            text-align: center;
            padding: 20px;
            color: #fff;
            width: 80%;
        }
        .carousel-caption h4{
            font-size: 70px;
            font-weight: 800;

        }
         /* 我前面是圖片裡面的文字 */

         .split-layout {
            display: flex;
            background-color: #676363e9; /* 黑色背景 */
            color: #fff; /* 白色文字 */
            padding: 20px;
        }

        .vertical-line {
            border-left: 2px solid #fff; /* 白色中線 */
            margin: 0 20px;
            height: auto; /* 調整至適合內容的高度 */
        }

        .left-column, .right-column {
            flex: 1;
        }

        /*我前面黑框文字 */

        .hover-button {
        border: 2px solid #6f90ff; /* 邊框顏色 */
        border-radius: 50%; /* 圓形邊框 */
        background-color: transparent; /* 透明背景 */
        color: #47bbff; /* 文字顏色 */
        padding: 20px; /* 內邊距，根據需要調整 */
        font-size: 16px; /* 文字大小，根據需要調整 */
        cursor: pointer; /* 鼠標懸停時的指標 */
        transition: background-color 0.3s, color 0.3s; /* 過渡效果 */
        
        }

        .hover-button:hover {
        background-color: #50c3fd; /* 懸停時的背景顏色 */
        color: white; /* 懸停時的文字顏色 */
        }


    </style>
</head>

<body class="main-layout">








<%@ include file="/frontend/footer.jsp" %>
</body>

</html>
