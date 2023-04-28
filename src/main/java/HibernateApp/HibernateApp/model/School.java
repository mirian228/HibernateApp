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
@Table(name = "School")
public class School {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int schoolId;
	@Column(name = "school_number")
	private int schoolNumber;
	@OneToOne
	@JoinColumn(name = "principal_id", referencedColumnName = "id")
	private Principal principal;

	public School(int schoolNumber) {
		super();
		this.schoolNumber = schoolNumber;
	}

	public School(int schoolNumber, Principal principal) {
		super();
		this.schoolNumber = schoolNumber;
		this.principal = principal;
	}

	public School(int schoolId, int schoolNumber, Principal principal) {
		super();
		this.schoolId = schoolId;
		this.schoolNumber = schoolNumber;
		this.principal = principal;
	}

	public School() {
		super();
	}

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public int getSchoolNumber() {
		return schoolNumber;
	}

	public void setSchoolNumber(int schoolNumber) {
		this.schoolNumber = schoolNumber;
	}

	public Principal getPrincipal() {
		return principal;
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}

	@Override
	public String toString() {
		return "School [schoolNumber=" + schoolNumber + "]";
	}

}
