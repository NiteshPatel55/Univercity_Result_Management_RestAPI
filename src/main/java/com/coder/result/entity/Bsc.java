package com.coder.result.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Bsc {
	
	@Id
	private String studentRollNo;
	private int brachCode;
	
	private int mathemetics;
	private int physics;
	private int chemestry;
	private int english;
	private int hindi;
	
	
	
	
	public Bsc() {
		super();
	}



	public Bsc(int brachCode, String studentRollNo, int mathemetics, int physics, int chemestry, int english,
			int hindi) {
		super();
		this.brachCode = brachCode;
		this.studentRollNo = studentRollNo;
		this.mathemetics = mathemetics;
		this.physics = physics;
		this.chemestry = chemestry;
		this.english = english;
		this.hindi = hindi;
	}



	public int getBrachCode() {
		return brachCode;
	}

	public void setBrachCode(int brachCode) {
		this.brachCode = brachCode;
	}


	public String getStudentRollNo() {
		return studentRollNo;
	}


	public void setStudentRollNo(String studentRollNo) {
		this.studentRollNo = studentRollNo;
	}

	public int getMathemetics() {
		return mathemetics;
	}


	public void setMathemetics(int mathemetics) {
		this.mathemetics = mathemetics;
	}


	public int getPhysics() {
		return physics;
	}

	public void setPhysics(int physics) {
		this.physics = physics;
	}

	public int getChemestry() {
		return chemestry;
	}

	public void setChemestry(int chemestry) {
		this.chemestry = chemestry;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getHindi() {
		return hindi;
	}

	public void setHindi(int hindi) {
		this.hindi = hindi;
	}

	@Override
	public String toString() {
		return "Bsc [brachCode=" + brachCode + ", studentRollNo=" + studentRollNo + ", mathemetics=" + mathemetics
				+ ", physics=" + physics + ", chemestry=" + chemestry + ", english=" + english + ", hindi=" + hindi
				+ "]";
	}




	
	
	
	

}
