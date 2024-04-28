package com.session.model;

import java.util.List;

import org.hibernate.Session;

import com.member.HibernateUtil;

public class SionDAOHibernateimpl implements SionDAO {

	@Override
	public int insert(Sion sion) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Integer id = (Integer) session.save(sion);
			session.getTransaction().commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();

		}

		return 0;

	}

	@Override
	public int delete(Integer SionId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Sion ord = session.get(Sion.class, SionId);
			if (ord != null) {
				session.delete(ord);
			}
			session.getTransaction().commit();

			return 1;

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public List<Sion> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<Sion> list = session.createQuery("from Sion", Sion.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

}
