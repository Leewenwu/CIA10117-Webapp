package com.order.controller;

import java.io.IOException;
import java.util.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

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
			String str = req.getParameter("orderid");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入訂單編號");
			}
			// Send the use back to the form, if there were errors
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

		if ("getOne_For_Update".equals(action)) { //

			List<String> errorMsgs = new LinkedList<String>();

			req.setAttribute("errorMsgs", errorMsgs);
		}

		// 新增
		if ("insert".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 **************************/
			Integer orderid = Integer.valueOf(req.getParameter("orderid").trim());
			Integer orderstate = Integer.valueOf(req.getParameter("orderstate").trim());

			String str = req.getParameter("sessionid");
			Integer sessionid = null;
			if (str == null || str.trim().length() == 0) {
				errorMsgs.add("請輸入訂單編號!");
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
					sessionid = Integer.valueOf(str1.trim());

				} catch (NumberFormatException e) {

					errorMsgs.add("必須是數字");
				}
			}

			java.sql.Date orderdate = null;
			try {
				orderdate = java.sql.Date.valueOf(req.getParameter("orderdate").trim());
			} catch (IllegalArgumentException e) {
				orderdate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請選擇當天日期!");
			}

			String numberstr = req.getParameter("number");
			Integer number = null;
			if (numberstr == null || numberstr.trim().length() == 0) {
				errorMsgs.add("請輸入人數!");
			} else {
				try {
					number = Integer.valueOf(str1.trim());

				} catch (NumberFormatException e) {

					errorMsgs.add("必須是數字");
				}
			}

			java.sql.Date bookingdate = null;
			try {
				bookingdate = java.sql.Date.valueOf(req.getParameter("bookingdate").trim());
			} catch (IllegalArgumentException e) {
				bookingdate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請選擇日期!");
			}

			OrderVO ordvo = new OrderVO();
			ordvo.setOrderid(orderid);
			ordvo.setSessionid(sessionid);
			ordvo.setMemberid(memberid);
			ordvo.setOrderdate(orderdate);
			ordvo.setNumber(number);
			ordvo.setBookingdate(bookingdate);
			ordvo.setOrderstate(orderstate);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("ordvo", ordvo);
				RequestDispatcher failureView = req.getRequestDispatcher("/order/update_order_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/order/listAllOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("updateOrder".equals(action))

		{
			//

		}

		if ("deleteOrder".equals(action)) {
			//

		}
	}

}