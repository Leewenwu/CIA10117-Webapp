package com.session.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardServiceRegistry regisrty = new StandardServiceRegistryBuilder().configure().build();

		SessionFactory factory = new MetadataSources(regisrty).buildMetadata().buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Sion sion = new Sion(null,  null, "測試");
		sion.setMax(100);
		
		session.save(sion);
		
		
		tx.commit();
		session.close();
		factory.close();
	}

}
