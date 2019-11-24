package io.github.flpmartins88.basico;

import org.h2.Driver;
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

		c.setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.H2Dialect");
		c.setProperty(AvailableSettings.DRIVER, "org.h2.Driver");
		c.setProperty(AvailableSettings.USER, "sa");
		c.setProperty(AvailableSettings.PASS, "");
		c.setProperty(AvailableSettings.URL, "jdbc:h2:mem:banco");

		c.setProperty(AvailableSettings.HBM2DDL_AUTO, "create");

		c.setProperty(AvailableSettings.SHOW_SQL, "true");
        c.setProperty(AvailableSettings.FORMAT_SQL, "true");
        c.setProperty(AvailableSettings.GENERATE_STATISTICS, "true");

		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();

		sessionFactory = c.buildSessionFactory(registry);

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
