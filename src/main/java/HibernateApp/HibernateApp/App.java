package HibernateApp.HibernateApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HibernateApp.HibernateApp.model.Actor;
import HibernateApp.HibernateApp.model.Director;
import HibernateApp.HibernateApp.model.Item;
import HibernateApp.HibernateApp.model.Movie;
import HibernateApp.HibernateApp.model.Passport;
import HibernateApp.HibernateApp.model.Person;
import HibernateApp.HibernateApp.model.Principal;
import HibernateApp.HibernateApp.model.School;

public class App {
	public static void main(String[] args) {
		// Reads configuration from file named "hibernate.properties" by default
		Configuration configuration = new Configuration();
		// Added class for hibernate to see
		configuration.addAnnotatedClass(Person.class);
		configuration.addAnnotatedClass(Item.class);
		configuration.addAnnotatedClass(Movie.class);
		configuration.addAnnotatedClass(Director.class);
		configuration.addAnnotatedClass(Passport.class);
		configuration.addAnnotatedClass(Principal.class);
		configuration.addAnnotatedClass(School.class);
		configuration.addAnnotatedClass(Actor.class);
		// Building session factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		try (sessionFactory) {
			// Getting session
			Session session = sessionFactory.getCurrentSession();

			// Beginning transaction
			session.beginTransaction();

			Movie movie = new Movie("Pulp Fiction", 1994);
			Actor actor1 = new Actor("Harvey Keitel", 81);
			Actor actor2 = new Actor("Samuel L. Jackson", 72);

			movie.setActors(new ArrayList<>(List.of(actor1, actor2)));
			actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
			actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));

			session.save(movie);
			session.save(actor1);
			session.save(actor2);

			// Committing changes
			session.getTransaction().commit();
		}

	}
}
