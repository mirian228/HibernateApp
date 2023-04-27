package HibernateApp.HibernateApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {
	@Column(name = "")
	private int id;
	
	private String name;
	
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

	
	
}
