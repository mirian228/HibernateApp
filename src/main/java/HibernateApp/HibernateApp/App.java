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
			// Getting person with id=1 from database
			Person person = session.get(Person.class, 1);
			System.out.println(person.getName());
			System.out.println(person.getAge());
			// Committing changes from cache
			session.getTransaction().commit();
		} finally {
			// Closing session factory
			sessionFactory.close();
		}

	}
}
