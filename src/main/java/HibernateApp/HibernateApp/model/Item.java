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
@Table(name = "Item")
public class Item {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "item_name")
	private String itemName;

	@ManyToOne
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person owner;

	public Item() {
		super();
	}

	public Item(int id, String itemName) {
		super();
		this.id = id;
		this.itemName = itemName;
	}

	public Item(String itemName, Person owner) {
		super();
		this.itemName = itemName;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return "Item [itemName=" + itemName + "]";
	}

}
