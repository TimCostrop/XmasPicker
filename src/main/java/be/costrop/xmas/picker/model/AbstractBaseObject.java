package be.costrop.xmas.picker.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractBaseObject implements Serializable, Comparable<Object> {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;

	@Column(name = "created_timestamp")
	@NotNull
	private LocalDateTime createdOn;

	@Column(name = "last_modified_timestamp")
	@NotNull
	private LocalDateTime lastModifiedOn;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getLastModifiedOn() {
		return lastModifiedOn;
	}

	public void setLastModifiedOn(LocalDateTime lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}

	@PrePersist
	public void onCreate() {
		if(this.createdOn == null) { // here for testing purposes.
			this.createdOn = LocalDateTime.now();
		}
		this.lastModifiedOn = this.createdOn;
	}

	@PreUpdate
	public void onUpdate() {
		if(!lastModifiedOn.isEqual(this.createdOn)){ // also here for testing purposes
			this.lastModifiedOn = LocalDateTime.now();
		}
	}

	@Override
	public String toString() {
		return getId();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		AbstractBaseObject that = (AbstractBaseObject) o;

		return !(id != null ? !id.equals(that.id) : that.id != null);
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public int compareTo(Object o) {
		return getCreatedOn().compareTo(((AbstractBaseObject) o).getCreatedOn());
	}
}
