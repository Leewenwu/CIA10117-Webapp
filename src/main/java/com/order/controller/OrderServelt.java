package com.order.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.model.OrderService;
import com.order.model.OrderVO;

public class OrderServelt extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 req.setCharacterEncoding("UTF-8");
	        String action = req.getParameter("action");
	        
	        if ("getOne_For_Display".equals(action)) {
	            // 
	            getOneForDisplay(req, res);
	        } else if ("addOrder".equals(action)) {
	            //
	            addOrder(req, res);
	        } else if ("updateOrder".equals(action)) {
	            //
	            updateOrder(req, res);
	        } else if ("deleteOrder".equals(action)) {
	            //
	            deleteOrder(req, res);
	        }
	    }

	private void updateOrder(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
			
	}

	private void deleteOrder(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	private void addOrder(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		try {
            // 从请求中获取订单相关信息
            String memberid = req.getParameter("memberid");
            Integer number = Integer.parseInt(req.getParameter("number"));
            // 假设其他必要的参数也已经被获取...
            
            OrderService orderSvc = new OrderService();
            OrderVO orderVO = orderSvc.addOrder(null, memberid, new java.sql.Date(System.currentTimeMillis()), number, 1, new java.sql.Date(System.currentTimeMillis()), 1);
            
            req.setAttribute("orderVO", orderVO);
            RequestDispatcher successView = req.getRequestDispatcher("/order/listAllOrders.jsp");
            successView.forward(req, res);
        } catch (Exception e) {
            throw new ServletException(e);
        }	
    }

	private void getOneForDisplay(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}
}