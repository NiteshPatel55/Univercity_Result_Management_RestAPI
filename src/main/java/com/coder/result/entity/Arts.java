package com.coder.result.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Arts {
	
	@Id
	private String studentRollNo;
	private int brachCode;
	
	
	private int history;
	private int giography;
	private int economy;
	private int english;
	private int hindi;
	
	
	
	
	public Arts() {
		super();
	}
	public Arts(int brachCode, String studentRollNo, int history, int giography, int economy, int english, int hindi) {
		super();
		this.brachCode = brachCode;
		this.studentRollNo = studentRollNo;
		this.history = history;
		this.giography = giography;
		this.economy = economy;
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
	public int getHistory() {
		return history;
	}
	public void setHistory(int history) {
		this.history = history;
	}
	public int getGiography() {
		return giography;
	}
	public void setGiography(int giography) {
		this.giography = giography;
	}
	public int getEconomy() {
		return economy;
	}
	public void setEconomy(int economy) {
		this.economy = economy;
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
		return "Arts [brachCode=" + brachCode + ", studentRollNo=" + studentRollNo + ", history=" + history
				+ ", giography=" + giography + ", economy=" + economy + ", english=" + english + ", hindi=" + hindi
				+ "]";
	}
	
	
	
	
	

}
