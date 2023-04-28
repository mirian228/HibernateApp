package HibernateApp.HibernateApp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HibernateApp.HibernateApp.model.Director;
import HibernateApp.HibernateApp.model.Item;
import HibernateApp.HibernateApp.model.Movie;
import HibernateApp.HibernateApp.model.Person;

public class App {
	public static void main(String[] args) {
		// Reads configuration from file named "hibernate.properties" by default
		Configuration configuration = new Configuration();
		// Added class for hibernate to see
		configuration.addAnnotatedClass(Person.class);
		configuration.addAnnotatedClass(Item.class);
		configuration.addAnnotatedClass(Movie.class);
		configuration.addAnnotatedClass(Director.class);
		// Building session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		// Getting session
		Session session = sessionFactory.getCurrentSession();

		try {
			// Transaction Beginning
			session.beginTransaction();

			Movie movie = session.get(Movie.class, 1);
			System.out.println(movie);
			Director director = movie.getDirector();
			System.out.println(director);
			// Committing changes from cache
			session.getTransaction().commit();

		} finally {
			// Closing session factory
			sessionFactory.close();
		}

	}
}
