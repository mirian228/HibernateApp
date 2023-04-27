package HibernateApp.HibernateApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Entity Specifies that the class is an entity from database
@Entity
// Table specifies that this class is representation of the table from database
@Table(name = "Person")
public class Person {
	//Column annotation is used by hibernate to bind our field to database column, by name we assign name of column from database, if database column name is same as field @column annotation is not necessary
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;

	public Person() {
		super();
	}

	public Person(int id, String name, int age) {
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

	
	
}
