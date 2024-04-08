package com.his.dto;

public class ResponseDTO {

	private Long citizenSsnId;
	private String fullName;
	private String email;
	private Long mobNo;
	private Character gender;
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

	public String getCitizenState() {
		return citizenState;
	}

	public void setCitizenState(String citizenState) {
		this.citizenState = citizenState;
	}

}
