package be.costrop.xmas.picker.bootstrap;

import be.costrop.xmas.picker.model.Gift;
import be.costrop.xmas.picker.model.Person;

import java.util.ArrayList;
import java.util.List;

public final class PersonBuilder {
	private String name;
	private String email;
	private String mobile;
	private List<Gift> wantedItems = new ArrayList<>();

	private PersonBuilder() {
	}

	public static PersonBuilder aPerson() {
		return new PersonBuilder();
	}

	public PersonBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public PersonBuilder withEmail(String email) {
		this.email = email;
		return this;
	}

	public PersonBuilder withMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public PersonBuilder withWantedItems(List<Gift> wantedItems) {
		this.wantedItems = wantedItems;
		return this;
	}

	public Person build() {
		final Person person = new Person();
		person.setName(name);
		person.setEmail(email);
		person.setMobile(mobile);
		person.setWantedItems(wantedItems);
		return person;
	}
}
