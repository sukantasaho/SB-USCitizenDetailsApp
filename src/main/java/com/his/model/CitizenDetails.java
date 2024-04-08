package com.his.model;

import java.time.LocalDate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "US_CITIZEN_DETAILS")
public class CitizenDetails 
{
	 @Id
	 @SequenceGenerator(name = "gen1", sequenceName = "HIS_SEQ1", initialValue = 500000, allocationSize = 1)
	 @GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	 @Column(name = "SSN_ID")
     private Long citizenSsnId;
	 
	 @Column(name = "FULLNAME", length = 30)
     private String fullName;
	 
	 @Column(name = "EMAIL", length = 50)
	 private String email;
	 
	 @Column(name = "MOBILE_NO")
	 private Long mobNo;
	 
	 @Column(name = "GENDER")
	 private Character gender;
	 
	 @CreationTimestamp
	 private LocalDate createdDate;
	 
	 @UpdateTimestamp
	 private LocalDate modifiedDate;
	 
	 private String createdBy;
	 
	 private String modifiedBy;
	 
	 @Column(name = "STATE", length = 30)
     private String citizenState;

	public Long getCitizenSsnId() {
		return citizenSsnId;
	}

	public void setCitizenSsnId(Long citizenSsnId) {
		this.citizenSsnId = citizenSsnId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobNo() {
		return mobNo;
	}

	public void setMobNo(Long mobNo) {
		this.mobNo = mobNo;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getCitizenState() {
		return citizenState;
	}

	public void setCitizenState(String citizenState) {
		this.citizenState = citizenState;
	}
	 
	 
     
	 
	 
     
     
}
