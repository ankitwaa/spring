package org.cdac.ankit.hibernate.model;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity(name="User_Details")
public class UserDetail {
	
	@Id
	@GeneratedValue
	@Column(name="User_ID")
	private int userId;
	
	@Column(name="User_Name")
	private String userName;
	
	@Column(name="Contact_Number")
	private String contanctNumber;
	
	@Column(name="Email_ID")
	private String emailId;
	
	@Transient // This Tag Mean Not to be saved in database
	@Column(name="Login_Status") // Mapping to table column name
	private boolean status;
	
	@Lob   // to indicate a very large object, might be Clob(Text Data) or Blob(Binary Data)
	@Column(name="Description")
	private String description;
	
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name="street",column=@Column(name="Home_Street_Name")),
			@AttributeOverride(name="city",column=@Column(name="Home_City_Name")),
			@AttributeOverride(name="state",column=@Column(name="Home_State_Name")),
			@AttributeOverride(name="country",column=@Column(name="Home_Country_Name"))
			}
	)
	private Address homeAddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street",column=@Column(name="Office_Street_Name")),
		@AttributeOverride(name="city",column=@Column(name="Office_City_Name")),
		@AttributeOverride(name="state",column=@Column(name="Office_State_Name")),
		@AttributeOverride(name="country",column=@Column(name="Office_Country_Name"))
		}
    )
	private Address officeAddress;
	
	@ElementCollection
	@JoinTable(name="User_Address",joinColumns=@JoinColumn(name="User_Name"))
	@GenericGenerator(name="hilo-gen",strategy="hilo")
	@CollectionId(columns = { @Column(name="Address_ID")}, generator = "hilo-gen", type = @Type(type="long"))
	private Collection<Address> previousHomeAddresses=new ArrayList<Address>();
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="USER_VECHICLE",joinColumns=@JoinColumn(name="USER_ID"))
	private List<Vehicle> vechicles=new ArrayList<Vehicle>();
	
	
	public List<Vehicle> getVechicles() {
		return vechicles;
	}
	public void setVechicles(List<Vehicle> vechicles) {
		this.vechicles = vechicles;
	}
	public Collection<Address> getPreviousHomeAddresses() {
		return previousHomeAddresses;
	}
	public void setPreviousHomeAddresses(Collection<Address> previousHomeAddresses) {
		this.previousHomeAddresses = previousHomeAddresses;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="Join_Date")
	private Date joinDate;
	
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContanctNumber() {
		return contanctNumber;
	}
	public void setContanctNumber(String contanctNumber) {
		this.contanctNumber = contanctNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String toString(){
		return userId + " , " + userName;
	}
}
