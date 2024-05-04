package com.reserve;

import java.util.List;

public class ResTest {

	public static void main(String[] args) {
	 
		ReserveDAO dao= new ReserveDAOimpl();
		

		List<ReserveOrder> list = dao.getAll();
		
		for (ReserveOrder res :list) {
			System.out.println(res.getReserveSession()+",");
		}
	}

}
