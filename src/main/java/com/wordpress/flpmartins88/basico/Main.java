package com.wordpress.flpmartins88.basico;

import java.util.List;

import org.hibernate.Session;

public class Main {

	public static void main(String[] args) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		
		session.beginTransaction();
		
		Pessoa p1 = new Pessoa();
		p1.setNome("Felipe");
		session.save(p1);
		
		Pessoa p2 = new Pessoa();
		p2.setNome("Ana");
		session.save(p2);
		
		session.getTransaction().commit();
		
		for (Pessoa p:(List<Pessoa>) session.createCriteria(Pessoa.class).list()) {
			System.out.println(p.getNome());
		}
		
		session.close();
		
		System.exit(0);
	}

}
