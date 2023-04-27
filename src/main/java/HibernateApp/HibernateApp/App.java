package HibernateApp.HibernateApp;

import java.util.List;

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
				
			List<Person> people = session.createQuery("FROM Person").getResultList();
			for (int i = 0; i < people.size(); i++) {
				System.out.println(people.get(i));
			}
			
			// Committing changes from cache
			session.getTransaction().commit();
			// We can get id of person from database via hibernate after committing
			
		} finally {
			// Closing session factory
			sessionFactory.close();
		}

	}
}
