package be.costrop.xmas.picker.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_gift")
public class Gift extends AbstractBaseObject {

	@Column
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id", nullable = false)
	private Person person;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
