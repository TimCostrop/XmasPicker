package be.costrop.xmas.picker.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_person")
public class Person extends AbstractBaseObject {

	@Column
	private String name;

	@Column
	private String email;

	@Column
	private String mobile;

	@OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
	private List<Gift> wantedItems = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<Gift> getWantedItems() {
		return wantedItems;
	}

	public void setWantedItems(List<Gift> wantedItems) {
		this.wantedItems = wantedItems;
	}
}
