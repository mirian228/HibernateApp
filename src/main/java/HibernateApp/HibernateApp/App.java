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
			Person person1 = new Person("Test1", 30);
			Person person2	= new Person("Test2", 40);
			Person person3 = new Person("Test3", 50);
			
			
			session.save(person1);
			session.save(person2);
			session.save(person3);
			
			
			
			// Committing changes from cache
			session.getTransaction().commit();
		} finally {
			// Closing session factory
			sessionFactory.close();
		}

	}
}
