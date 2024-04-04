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
			String str = req.getParameter("ordid");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入訂單編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/order/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer ordid = null;
			try {
				ordid = Integer.valueOf(str);
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
			OrderVO ordVO =ordSvc.getOneOrd(ordid);
			if (ordVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/order/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
		}

		if ("addOrder".equals(action)) {
			//

		}
		if ("updateOrder".equals(action)) {
			//

		}

		if ("deleteOrder".equals(action)) {
			//

		}
	}

}