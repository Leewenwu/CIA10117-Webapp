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


<div>
 <!-- 介紹 -->
    <div class="about" style="padding-top: 40px;">
        <div class="container">
            <h2 class="text-center p-0 lora-type m-0" style="color: #847674;" data-aos="fade-up" data-aos-duration="1000">
                概覽</h2>
            <P class="text-center h5 mb-5 fw-bold" data-aos="fade-up" data-aos-duration="2000"> </P>
            <div class="row">
                <div class="col-lg-6 content">
                    <div class="about-text">
                        <div class="title-frame">
                            <h2 class="noto-serif lora-type" style="color: #847674;" data-aos="fade-right"
                            data-aos-duration="1000">JOYFUL restaurant</h2>
                            <h5 data-aos="fade-right" data-aos-duration="1000">奢華餐飲體驗，極致享受</h5>
                            <p class="" style="color: #847674;" data-aos="fade-right" data-aos-duration="1000">
                            在JOYFUL餐廳，我們提供不僅是餐點，更是一場奢華的感官盛宴。餐廳設計結合了現代與傳統元素，創造出一個既舒適又富有藝術氛圍的空間。每一道菜都由我們的星級主廚精心烹製，從選料到擺盤，每一細節都力求完美，確保為您提供無與倫比的用餐體驗。
                            </p>
                            <h5 data-aos="fade-right" data-aos-duration="1000">專注細節，追求完美</h5>
								<p style="color: #847674;" data-aos="fade-right"
									data-aos-duration="1000">
									我們在JOYFUL餐廳不斷創新菜品，引入國際化的美食元素，同時也重視地方特色，融合本土的新鮮食材。餐廳的服務團隊經過專業培訓，致力於提供細緻入微的服務，從迎賓到送行，每一個環節都讓您感受到尊貴與尊重。
								</p>
							</div>

                        <div style="height: 120px;" data-aos="fade-up" data-aos-duration="1000"> <!-- 可以調整height的值來改變間隔大小 -->
                            <!-- 這個div是空的，用來創造間隔 -->
                         
                        <button onclick="window.location.href='${pageContext.request.contextPath}/reserve/addreserve.jsp'" class="hover-button">我要訂位</button>

                          </div>
     
                    </div>
                </div>

 

                
                <div class="col-md-6">
                    <div class="about_img w-100" data-aos="fade-right" data-aos-duration="1000">
                        <figure><img src="images/restaurant1.jpg" alt="#" /></figure>
                    </div>
                        <p></p>
                    <!-- <div class="about_img w-100" data-aos="fade-right" data-aos-duration="1000">
                        <figure><img src="images/restaurant2.jpg" alt="#" /></figure>
                    </div> -->
                </div>
            </div>

            <div class="split-layout" data-aos="fade-up" data-aos-duration="1000" >
                <div class="left-column" style="flex: 2;"> <!-- 給左側更多空間 -->
                   
                    <div style="margin-right: 50px;"> <!-- 增加右側邊距 -->
                        <h3></h3>
                        <p>午　餐：成人TWD1,290 / 兒童TWD695 </p>
                        <p>晚　餐：週一至週四 成人TWD1,490 / 兒童TWD745<br>
                           週五至週日 成人TWD1,690 / 兒童TWD845</p>
                        <p>以上價格需另加一成服務費，以現場公告為主，不另行通知。</p>
                        <p>兒童收費標準：0-5歲免費，6-12歲以兒童價收費，13歲(含)以上以成人計價。</p>
                        <p>此餐價恕不適用於國定假日、農曆除夕、農曆春節、中西情人節、母親節(前一週週末與當週週末)、父親節、耶誕夜、耶誕節、跨年夜及特殊美食節。</p>
                    </div>
                </div>
                                                                
                <div class="vertical-line"> </div> <!-- 分隔線 -->
                
                <div class="right-column"  style="flex: 1;"   data-aos="fade-up" data-aos-duration="1000" >
                    <p>座位數：50席</p>
                    <p>包廂：4間</p>
                 
                    <p>午　餐：11:30AM-02:00PM</p>
                
                    <p>晚　餐：05:00PM-09:00PM</p>

                    <p>訂位專線：03 457 1234</p>
                    <!-- 在這裡添加更多右側內容 -->
                </div>
            </div>
        </div>
    </div>




</div>

<%@ include file="/frontend/footer.jsp" %>
</body>

</html>
