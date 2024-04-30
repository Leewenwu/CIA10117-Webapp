package com.reserve;

import static com.reserve.Constants.PAGE_MAX_RESULT;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.member.Member;

import util.HibernateUtil;

public class ReserveDAOimpl implements ReserveDAO {
	private SessionFactory factory;

	public ReserveDAOimpl() {
		factory = HibernateUtil.getSessionFactory();
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int insert(ReserveOrder entity) {
		Session session = getSession();

		try {
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return -1;
		}
	}

	@Override
	public int update(ReserveOrder entity) {
		Session session = getSession();

		try {
			session.beginTransaction();
			session.update(entity);
			session.getTransaction().commit();

			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return -1;
		}

	}

	@Override
	public long getTotal() {
		Session session = getSession();
		try {
			session.beginTransaction();
			long total = session.createQuery("select count(*) from ReserveOrder", Long.class).uniqueResult();
			session.getTransaction().commit();
			return total;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return -1;

	}

	@Override
	public ReserveOrder findPK(Integer id) {
		Session session = getSession();
		try {
			session.beginTransaction();
			ReserveOrder orderid = session.get(ReserveOrder.class, id);
			session.getTransaction().commit();
			return orderid;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return null;

	}
	
	@Override
	public ReserveSession findsessionPK(Integer id) {
		Session session = getSession();
		try {
			session.beginTransaction();
			ReserveSession sessionid = session.get(ReserveSession.class, id);
			session.getTransaction().commit();
			return sessionid;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return null;

	}
		
 
	

	@Override
	public List<ReserveOrder> getAll() {
		Session session = getSession();
		try {
			session.beginTransaction();
			List<ReserveOrder> reserve = session.createQuery("from ReserveOrder", ReserveOrder.class).list();
			session.getTransaction().commit();
			return reserve;
		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		}
		return null;
	}
//
//	@Override
//	public List<ReserveOrder> getAll(int Page) {
//		
//		int first = (Page - 1) * PAGE_MAX_RESULT;
//		return getSession().createQuery("from ReserveOrder", ReserveOrder.class).setFirstResult(first)
//				.setMaxResults(PAGE_MAX_RESULT).list();
//
//	}

	@Override
	public List<ReserveOrder> getAll(int Page) {
		Session session = getSession();
		try {
			session.beginTransaction();
			int first = (Page - 1) * PAGE_MAX_RESULT;
			List<ReserveOrder> page = session.createQuery("from ReserveOrder", ReserveOrder.class).setFirstResult(first)
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
	public List<ReserveOrder> getCompositeQuery(Map<String, String> map, int Page) {
		if (map.size() == 0)
			return getAll();

		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<ReserveOrder> criteria = builder.createQuery(ReserveOrder.class);
		Root<ReserveOrder> root = criteria.from(ReserveOrder.class);

		List<Predicate> predicates = new ArrayList<>();

		return null;
	}
}
