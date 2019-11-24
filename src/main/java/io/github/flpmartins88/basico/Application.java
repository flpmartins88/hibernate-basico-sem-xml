package io.github.flpmartins88.basico;

import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;

public class Application {

	public static void main(String[] args) {

		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(new Pessoa("Felipe"));
		session.save(new Pessoa("Ana"));

		session.getTransaction().commit();

		CriteriaQuery<Pessoa> criteria = session.getCriteriaBuilder().createQuery(Pessoa.class);
		criteria.from(Pessoa.class);

		for (Pessoa p : session.createQuery(criteria).getResultList()) {
			System.out.println(p.getNome());
		}

		session.close();

		System.exit(0);
	}

}
