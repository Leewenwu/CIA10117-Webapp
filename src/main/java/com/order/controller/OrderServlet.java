package com.order.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.order.model.*;

public class OrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("ordid");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入訂單編號");
			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/order/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer orderid = null;
			try {
				orderid = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("員工編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/order/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			OrderService ordSvc = new OrderService();
			OrderVO ordVO = ordSvc.getOneOrd(orderid);
			if (ordVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/order/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("OrderVO", ordVO);
			String url = "/order/listOneOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); //
			successView.forward(req, res);
		}
		if ("getOne_for_update".equals(action)) { //

			List<String> errorMsgs = new LinkedList<String>();

			req.setAttribute("errorMsgs", errorMsgs);

			/***************************1.接收請求參數****************************************/
			Integer order = Integer.valueOf(req.getParameter("orderid"));
			
			/***************************2.開始查詢資料****************************************/
			OrderService ordsvc = new OrderService();
			OrderVO orderVO = ordsvc.getOneOrd(order);
							
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			String param =  "?orderid="  +orderVO.getOrderid()+
							"&sessionid=" +orderVO.getSessionid()+
							"&memberid=" +orderVO.getMemberid()+
							"&orderdate="+orderVO.getOrderid()+
							"&number=" +orderVO.getNumber()+
							"&orderstate=" +orderVO.getOrderdate()+
							"&bookingdate=" +orderVO.getBookingdate()+
							"&ordernote=" +orderVO.getOrdernote();
			
			String url = "/order/update_order_input.jsp"+param;
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
	}
		
			


		if ("update".equals(action)) { //

			List<String> errorMsgs = new LinkedList<String>();

			req.setAttribute("errorMsgs", errorMsgs);

			String ordernote = req.getParameter("ordernote");
			if (ordernote == null) {
				ordernote = "";
			}	

			String str = req.getParameter("orderid");
			if (str == null || str.trim().length() == 0) {
				errorMsgs.add("請輸入訂單編號");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/order/update_order_input.jsp");
				failureView.forward(req, res);
				return;//
			}

			Integer orderid = null;
			try {
				orderid = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("格式錯誤!");

			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/order/update_order_input.jsp");
				failureView.forward(req, res);
				return;//
			}

			// ------------------------------------
			OrderService ordsvc = new OrderService();
			OrderVO ordvo = ordsvc.updateOrder(orderid, ordernote);
			

			// -----------------------------------------
			req.setAttribute("OrderVO", ordvo);// 資料庫取出OrderVO,存入req
			String url = "/order/listOneOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);

		}

		
		
		if ("insert".equals(action))

		{
			// 新增部分
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 **************************/

			String str = req.getParameter("sessionid");
			Integer sessionid = null;
			if (str == null || str.trim().length() == 0) {
				errorMsgs.add("請輸入場次編號!");
			} else {
				try {
					sessionid = Integer.valueOf(str.trim());

				} catch (NumberFormatException e) {

					errorMsgs.add("必須是數字");
				}
			}

			String str1 = req.getParameter("memberid");
			Integer memberid = null;
			if (str1 == null || str1.trim().length() == 0) {
				errorMsgs.add("請輸入會員編號!");
			} else {
				try {
					memberid = Integer.valueOf(str1.trim());

				} catch (NumberFormatException e) {

					errorMsgs.add("必須是數字");

				}
			}

//			java.sql.Date orderdate = null;
//			try {
//				orderdate = java.sql.Date.valueOf(req.getParameter("orderdate").trim());
//			} catch (IllegalArgumentException e) {
//				orderdate = new java.sql.Date(System.currentTimeMillis());
//				errorMsgs.add("請選擇當天日期!");

//			java.sql.Date bookingdate = null;
//			try {
//				bookingdate = java.sql.Date.valueOf(req.getParameter("bookingdate").trim());
//			} catch (IllegalArgumentException e) {
//				bookingdate = new java.sql.Date(System.currentTimeMillis());
//				errorMsgs.add("請選擇日期!");
//			}			
//			}

			String orderdateStr = req.getParameter("orderdate");
			java.sql.Date orderdate = null;

			if (orderdateStr == null || orderdateStr.trim().isEmpty()) {
				errorMsgs.add("請選擇訂單日期!");
			} else {
				try {

					orderdate = java.sql.Date.valueOf(orderdateStr.trim());
				} catch (IllegalArgumentException e) {

					errorMsgs.add("日期格式不正確，請使用YYYY-MM-DD格式!");
				}
			}

			String numberstr = req.getParameter("number");
			Integer number = null;
			if (numberstr == null || numberstr.trim().length() == 0) {
				errorMsgs.add("請輸入人數!");
			} else {
				try {
					number = Integer.valueOf(numberstr.trim());

				} catch (NumberFormatException e) {

					errorMsgs.add("請輸入正確數字!");
				}
			}

			String bookingdateStr = req.getParameter("bookingdate");
			java.sql.Date bookingdate = null;

			if (bookingdateStr == null || bookingdateStr.trim().isEmpty()) {
				errorMsgs.add("請選擇預定日期!");
			} else {
				try {

					bookingdate = java.sql.Date.valueOf(bookingdateStr.trim());
				} catch (IllegalArgumentException e) {

					errorMsgs.add("日期格式不正確，請使用YYYY-MM-DD格式!");
				}

			}

			String ordernote = req.getParameter("ordernote");
			if (ordernote == null) {
				ordernote = "";
			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/order/addOrder.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}
			/*************************** 2.開始新增資料 ***************************************/
			OrderService ordSvc = new OrderService();
			ordSvc.addOrder(sessionid, memberid, orderdate, number, bookingdate, ordernote);
			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/order/listAllOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("deleteOrder".equals(action)) {
			// 刪除部分
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			Integer ordid = Integer.valueOf(req.getParameter("orderid"));

			OrderService ordsvc = new OrderService();
			ordsvc.deleteOrder(ordid);

			String url = "/order/listAllOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
	}

}