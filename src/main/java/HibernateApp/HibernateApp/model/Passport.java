package HibernateApp.HibernateApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Passport")
public class Passport {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne()
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;

	@Column(name = "passport_number")
	private int passportNumber;

	public Passport() {
		super();
	}

	public Passport(int passportNumber) {
		super();
		this.passportNumber = passportNumber;
	}

	public Passport(Person person, int passportNumber) {
		super();
		this.person = person;
		this.passportNumber = passportNumber;
	}

	public Passport(int id, Person person, int passportNumber) {
		super();
		this.id = id;
		this.person = person;
		this.passportNumber = passportNumber;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getPassportNumber() {
		return passportNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPassportNumber(int passportNumber) {
		this.passportNumber = passportNumber;
	}

}
