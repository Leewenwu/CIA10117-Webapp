package com.member;

import static com.member.Constants.PAGE_MAX_RESULT;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

//	@Override
//	public List<Member> getAll() {
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			return session.createQuery("from Member", Member.class).list();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

	@Override
	public List<Member> getAll(int Page) {
		Session session = getSession();
		try {
			session.beginTransaction();
			int first = (Page - 1) * PAGE_MAX_RESULT;
			List<Member> page = session.createQuery("from Member", Member.class).setFirstResult(first)
					.setMaxResults(PAGE_MAX_RESULT).list();
			session.getTransaction().commit();
			return page;

		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		}
		return null;
	}

	@Override
	public List<Member> getAll() {
		Session session = getSession();
		try {
			session.beginTransaction();
			List<Member> members = session.createQuery("from Member", Member.class).list();
			session.getTransaction().commit();
			return members;
		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		}
		return null;
	}

	@Override
	public int update(Member member) {
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

		return -1;
	}

	@Override
	public Member findByPK(Integer memId) {
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

	@Override
	public List<Member> getCompositeQuery(Map<String, String> map) {
		Session session = getSession();
		if (map.size() == 0)
			return getAll(1);

		try {
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Member> query = builder.createQuery(Member.class);
			Root<Member> root = query.from(Member.class);
			List<Predicate> predicates = new ArrayList<>();

			for (Map.Entry<String, String> row : map.entrySet()) {
				if ("mName".equals(row.getKey())) {
					predicates.add(builder.like(root.get("mName"), "%" + row.getValue() + "%"));
				}

				if ("phone".equals(row.getKey())) {
					predicates.add(builder.like(root.get("phone"), "%" + row.getValue() + "%"));
				}

				if ("mState".equals(row.getKey())) {
					predicates.add(builder.equal(root.get("mState"), row.getValue()));
				}
			}

			query.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
			query.orderBy(builder.asc(root.get("memId")));
			TypedQuery<Member> Query = session.createQuery(query);
			List<Member> result = Query.getResultList();
			session.getTransaction().commit();
			return result;

		} catch (Exception e) {
			session.getTransaction().rollback();  
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public long getTotal() {
		Session session = getSession();
		try {
			session.beginTransaction();
			long total = session.createQuery("select count(*) from Member", Long.class).uniqueResult();
			session.getTransaction().commit();
			return total;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return -1;

	}

}
