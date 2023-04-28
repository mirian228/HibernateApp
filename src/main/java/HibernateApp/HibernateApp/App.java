package HibernateApp.HibernateApp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HibernateApp.HibernateApp.model.Item;
import HibernateApp.HibernateApp.model.Person;

public class App {
	public static void main(String[] args) {
		// Reads configuration from file named "hibernate.properties" by default
		Configuration configuration = new Configuration();
		// Added class for hibernate to see
		configuration.addAnnotatedClass(Person.class);
		configuration.addAnnotatedClass(Item.class);
		// Building session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		// Getting session
		Session session = sessionFactory.getCurrentSession();

		try {
			// Transaction Beginning
			session.beginTransaction();
			
			Person person = session.get(Person.class, 3);
			System.out.println(person);
			List<Item> items = person.getItems();
			System.out.println(items);
			
			
			// Committing changes from cache
			session.getTransaction().commit();
			
			
		} finally {
			// Closing session factory
			sessionFactory.close();
		}

	}
}
