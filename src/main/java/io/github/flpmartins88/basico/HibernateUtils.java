package io.github.flpmartins88.basico;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

	private static SessionFactory sessionFactory;

	static {
		Configuration c = new Configuration();

		c.addAnnotatedClass(Pessoa.class);
		c.addPackage(Pessoa.class.getPackage().getName());

		c.setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQLDialect");
		c.setProperty(AvailableSettings.DRIVER, "com.mysql.jdbc.Driver");
		c.setProperty(AvailableSettings.USER, "root");
		c.setProperty(AvailableSettings.PASS, "root");
		c.setProperty(AvailableSettings.URL, "jdbc:mysql://localhost:3306/test");

		c.setProperty(AvailableSettings.HBM2DDL_AUTO, "create");

		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();

		sessionFactory = c.buildSessionFactory(registry);

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
