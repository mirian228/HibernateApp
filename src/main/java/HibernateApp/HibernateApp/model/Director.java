package HibernateApp.HibernateApp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Director")
public class Director {

	@Column(name = "director_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private int age;

	@OneToMany(mappedBy = "directorId")
	private List<Movie> movies;

	public Director() {
		super();
	}

	public Director(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Director(String name, int age, List<Movie> movies) {
		super();
		this.name = name;
		this.age = age;
		this.movies = movies;
	}

	public Director(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Director [name=" + name + ", age=" + age + "]";
	}


	

}
