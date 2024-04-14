package com.member;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class MemberDAOimpl implements MemberDAO {

	private SessionFactory factory;

	public MemberDAOimpl() {
		factory = HibernateUtil.getSessionFactory();
	}

	private Session getSession() {
		return factory.getCurrentSession();

	}

	@Override
	public List<Member> getAll() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Member", Member.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int update(Member member) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Session session = getSession();
		try {
			session.beginTransaction();
			session.update(member);
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();

		}

		return 0;
	}

	@Override
	public Member findByPK(Integer memId) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Session session = getSession();
		try {
			session.beginTransaction();
			Member mem = session.get(Member.class, memId);
			session.getTransaction().commit();
			return mem;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return null;

	}

//	@Override
//	public List<Member> getAll() {
//		Session session = getSession();
//		try {
//			session.beginTransaction();
//			List<Member> members = session.createQuery("from Member", Member.class).list();
//			session.getTransaction().commit();
//			return members;
//		} catch (Exception e) {
//			e.printStackTrace();
//			if (session.getTransaction() != null) {
//				session.getTransaction().rollback();
//			}
//		}
//		return null;
//	}
}