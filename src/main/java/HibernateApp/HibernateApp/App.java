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
			
			
			Person person = session.get(Person.class, 2);
			Person person1 = new Person("Some name ", 60);
			
			session.save(person1);
			
		
			
			// Committing changes from cache
			session.getTransaction().commit();
			// We can get id of person from database via hibernate after committing
			System.out.println(person1.getId());
		} finally {
			// Closing session factory
			sessionFactory.close();
		}

	}
}
