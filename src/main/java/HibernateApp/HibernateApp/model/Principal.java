package HibernateApp.HibernateApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Principal")
public class Principal {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int principalId;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private int age;
	@OneToOne(mappedBy = "principal")
	private School school;

	public Principal(String name, int age, School school) {
		super();
		this.name = name;
		this.age = age;
		this.school = school;
	}

	public Principal(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Principal(int principalId, String name, int age, School school) {
		super();
		this.principalId = principalId;
		this.name = name;
		this.age = age;
		this.school = school;
	}

	public Principal() {
		super();
	}

	public int getPrincipalId() {
		return principalId;
	}

	public void setPrincipalId(int principalId) {
		this.principalId = principalId;
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

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "Principal [name=" + name + ", age=" + age + "]";
	}

}
