package HibernateApp.HibernateApp;

import java.util.ArrayList;
import java.util.Collections;

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

			Person person = new Person("Test person", 30);

			Item newItem = new Item("Item from hibernate 2", person);

			person.setItems(new ArrayList<>(Collections.singletonList(newItem)));
			session.save(person);
			session.save(newItem);

			// Committing changes from cache
			session.getTransaction().commit();

		} finally {
			// Closing session factory
			sessionFactory.close();
		}

	}
}
