package com.coder.result.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class College {
	
	@Id
	private String collegeId;
	private String collegeName;
	private String collegeCity;
	


	public College() {
		super();
	}

	public College(String collegeId, String collegeName, String collegeCity) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.collegeCity = collegeCity;
	}




	public String getCollegeId() {
		return collegeId;
	}




	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}




	public String getCollegeName() {
		return collegeName;
	}




	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}




	public String getCollegeCity() {
		return collegeCity;
	}




	public void setCollegeCity(String collegeCity) {
		this.collegeCity = collegeCity;
	}




	@Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + ", collegeCity=" + collegeCity
				+ "]";
	}


	
}
