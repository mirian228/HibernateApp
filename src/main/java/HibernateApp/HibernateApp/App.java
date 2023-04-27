package HibernateApp.HibernateApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HibernateApp.HibernateApp.model.Person;

public class App {
	public static void main(String[] args) {
		// Reads configuration from file named "hibernate.properties" by default
		Configuration configuration = new Configuration();
		// Added class for hibernate to see
		configuration.addAnnotatedClass(Person.class);
		// Building session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		// Getting session
		Session session = sessionFactory.getCurrentSession();

		try {
			// Transaction Beginning
			session.beginTransaction();
			// Get person from db whose name starts with 'T'	
			session.createQuery("delete from Person where age < 30").executeUpdate();
			
			
			// Committing changes from cache
			session.getTransaction().commit();
			// We can get id of person from database via hibernate after committing
			
		} finally {
			// Closing session factory
			sessionFactory.close();
		}

	}
}
