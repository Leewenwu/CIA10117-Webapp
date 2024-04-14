package com.session.model;

import java.util.List;

public class TestDAO {

	public static void main(String[] args) {
	 
		SionDAO dao = new SionDAOHibernateimpl();

		Sion sion1 = new Sion();
		sion1.setTime("練習2");
		dao.insert(sion1);

//		dao.delete(112);
//		dao.delete(114);
//		dao.delete(115);
//		dao.delete(116);
		

//		List<Sion> list = dao.getAll();
//		for (Sion sion : list) {
//			System.out.println(sion.getSionId());
//			System.out.println(sion.getMax());
//			System.out.println(sion.getTime());
//		}
	}

}
