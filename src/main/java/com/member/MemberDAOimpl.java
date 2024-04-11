package com.member;

import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;

public class MemberDAOimpl implements MemberDAO {

	@Override
	public int update(Member member) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
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
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
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

	@Override
	public List<Member> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<Member> list = session.createQuery("from Member", Member.class).list();
			session.getTransaction();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

}
