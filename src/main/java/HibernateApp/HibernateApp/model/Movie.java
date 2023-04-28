package HibernateApp.HibernateApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Movie")
public class Movie {

	@Column(name = "movie_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "director_id", referencedColumnName = "director_id")
	private Director directorId;
	@Column(name = "name")
	private String name;
	@Column(name = "year_of_production")
	private int yearOfProduction;

	public Movie(String name, int yearOfProduction) {
		super();
		this.name = name;
		this.yearOfProduction = yearOfProduction;
	}

	public Movie(int id, Director directorId, String name, int yearOfProduction) {
		super();
		this.id = id;
		this.directorId = directorId;
		this.name = name;
		this.yearOfProduction = yearOfProduction;
	}

	public Movie(Director directorId, String name, int yearOfProduction) {
		super();
		this.directorId = directorId;
		this.name = name;
		this.yearOfProduction = yearOfProduction;
	}

	public Movie() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Director getDirectorId() {
		return directorId;
	}

	public void setDirectorId(Director directorId) {
		this.directorId = directorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(int yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", yearOfProduction=" + yearOfProduction + "]";
	}

	


}
