
//show variables like 'max_allowed_packet'
//set global max_allowed_packet=33554432
//jdbc.driverClassName = com.mysql.jdbc.Driver
  //      jdbc.url = jdbc:mysql://localhost:3306/bcsb_db?
    //    jdbc.username = root
      //  jdbc.password = harith
      //  hibernate.dialect = org.hibernate.dialect.MySQLDialect
     //   hibernate.show_sql = true
     //   hibernate.format_sql = true



       // server.port: 8443
       // server.ssl.key-store: keystore.p12
       // server.ssl.key-store-password: mypassword
       // server.ssl.keyStoreType: PKCS12
       // server.ssl.keyAlias: tomcat

        //# multipart
        //multipart.enabled=true
        //spring.http.multipart.max-file-size=500000KB
        //spring.http.multipart.max-request-size=500000KB

package com.bcsp.project.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name="APP_Dimensions")
public class Dimensions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private Date createdOn;

	@Column
	private String createdBy;

	@Column
	private Date updatedOn;

	@Column
	private String updatedBy;

	//@NotEmpty
	@Column(name = "DIMENSION_ID", unique = true)
	private String dimensionId;

	private String dimensionName;

	@Lob
	@Column(name = "FILE_DATA", columnDefinition="BLOB" ,length = Integer.MAX_VALUE, nullable = true)
	private byte[] data;

	//@Temporal(TemporalType.DATE)
	//@NotNull
	//@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfIdea;

	@Column
	@NotNull
	private String personalOrInstitute;   // form:radiobutton - radio button//Personal, Inistitute.

	@NotEmpty
	@Column(unique = true, nullable = false)
	private String name;

	@NotEmpty
	@Column(unique = true, nullable = false)
	private String mobileNumber;

	@NotEmpty
	@Column(nullable = false)
	private String email;

	//@NotEmpty
	//@Column(nullable = false)
	private String country; //Norway, Sweeden, USA.

	@Column
	private String dimensiondescription;

	//Dimensions
	private int dControl;
	private int dMeaning;
	private int dExposure;
	private int dEncouragement;
	private int dTiming;
	private int dEmpathy;
	private int dObtrusiveness;
	private int dImportance;
	private int dDirection;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getDimensionId() {
		return dimensionId;
	}

	public void setDimensionId(String dimensionId) {
		this.dimensionId = dimensionId;
	}

	public String getDimensionName() {
		return dimensionName;
	}

	public void setDimensionName(String dimensionName) {
		this.dimensionName = dimensionName;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Date getDateOfIdea() {
		return dateOfIdea;
	}

	public void setDateOfIdea(Date dateOfIdea) {
		this.dateOfIdea = dateOfIdea;
	}

	public String getPersonalOrInstitute() {
		return personalOrInstitute;
	}

	public void setPersonalOrInstitute(String personalOrInstitute) {
		this.personalOrInstitute = personalOrInstitute;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDimensiondescription() {
		return dimensiondescription;
	}

	public void setDimensiondescription(String dimensiondescription) {
		this.dimensiondescription = dimensiondescription;
	}

	public int getdControl() {
		return dControl;
	}

	public void setdControl(int dControl) {
		this.dControl = dControl;
	}

	public int getdMeaning() {
		return dMeaning;
	}

	public void setdMeaning(int dMeaning) {
		this.dMeaning = dMeaning;
	}

	public int getdExposure() {
		return dExposure;
	}

	public void setdExposure(int dExposure) {
		this.dExposure = dExposure;
	}

	public int getdEncouragement() {
		return dEncouragement;
	}

	public void setdEncouragement(int dEncouragement) {
		this.dEncouragement = dEncouragement;
	}

	public int getdTiming() {
		return dTiming;
	}

	public void setdTiming(int dTiming) {
		this.dTiming = dTiming;
	}

	public int getdEmpathy() {
		return dEmpathy;
	}

	public void setdEmpathy(int dEmpathy) {
		this.dEmpathy = dEmpathy;
	}

	public int getdObtrusiveness() {
		return dObtrusiveness;
	}

	public void setdObtrusiveness(int dObtrusiveness) {
		this.dObtrusiveness = dObtrusiveness;
	}

	public int getdImportance() {
		return dImportance;
	}

	public void setdImportance(int dImportance) {
		this.dImportance = dImportance;
	}

	public int getdDirection() {
		return dDirection;
	}

	public void setdDirection(int dDirection) {
		this.dDirection = dDirection;
	}


	@Override
	public String toString() {
		return "Dimensions{" +
				"id=" + id +
				", createdOn=" + createdOn +
				", createdBy='" + createdBy + '\'' +
				", updatedOn=" + updatedOn +
				", updatedBy='" + updatedBy + '\'' +
				", dimensionId='" + dimensionId + '\'' +
				", dimensionName='" + dimensionName + '\'' +
				", data=" + Arrays.toString(data) +
				", dateOfIdea=" + dateOfIdea +
				", personalOrInstitute='" + personalOrInstitute + '\'' +
				", name='" + name + '\'' +
				", mobileNumber='" + mobileNumber + '\'' +
				", email='" + email + '\'' +
				", country='" + country + '\'' +
				", dimensiondescription='" + dimensiondescription + '\'' +
				", dControl=" + dControl +
				", dMeaning=" + dMeaning +
				", dExposure=" + dExposure +
				", dEncouragement=" + dEncouragement +
				", dTiming=" + dTiming +
				", dEmpathy=" + dEmpathy +
				", dObtrusiveness=" + dObtrusiveness +
				", dImportance=" + dImportance +
				", dDirection=" + dDirection +
				'}';
	}
}