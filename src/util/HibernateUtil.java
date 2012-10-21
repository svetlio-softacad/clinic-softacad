package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate session management utility class.
 * @author Vladimir Tsanev
 */
public final class HibernateUtil {
	
	private HibernateUtil() {
	}

	private static final SessionFactory SESSION_FACTORY;
	
	static {
		try {
			// Try to load the Hibernate settings from hibernate.cfg.xml and
			// hibernate.properties. This creates session factory
			Configuration configuration = new AnnotationConfiguration();
			configuration.configure();
			SESSION_FACTORY = configuration.buildSessionFactory();
		} catch (Throwable e) {
			System.err.println("Initial SessionFactory creation failed." + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Session getSession() {
		return SESSION_FACTORY.getCurrentSession();
	}

	public static void closeSessionFactory() {
		SESSION_FACTORY.close();		
	}
}
