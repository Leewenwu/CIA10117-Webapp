//package filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//
//import org.hibernate.SessionFactory;
//
//import util.HibernateUtil;
//
//@WebFilter(urlPatterns = { "/*" })
//public class OpenSessionInViewFilter implements Filter {
//
//	@Override
//	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
//			throws IOException, ServletException {
//		SessionFactory factory = HibernateUtil.getSessionFactory();
//		try {
//			System.out.println("濾器開啟交易!");
//			factory.getCurrentSession().beginTransaction();
//			chain.doFilter(req, res);
//			factory.getCurrentSession().getTransaction().commit();
//		} catch (Exception e) {
//			factory.getCurrentSession().getTransaction().rollback();
//			e.printStackTrace();
////			 throw new ServletException(e); 
//			chain.doFilter(req, res);
//		}
//	}
//
//}
