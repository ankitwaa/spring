package org.cdac.ankit.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="VEHICLE")
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	
	@Column(name="MODEL_ID")
	private String modelId;
	
	@Column(name="VEHICLE_NUMBER")
	private String vechicleNumber;
	
	@OneToOne
	private UserDetail user;
	
	public UserDetail getUser() {
		return user;
	}
	public void setUser(UserDetail user) {
		this.user = user;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getModelId() {
		return modelId;
	}
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	public String getVechicleNumber() {
		return vechicleNumber;
	}
	public void setVechicleNumber(String vechicleNumber) {
		this.vechicleNumber = vechicleNumber;
	}
	
	

}
