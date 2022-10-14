package com.coder.result.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Branch {
	
	@Id
	private int branchId;
	
	private String brachName;
	
	
	private int branchCode;
	
	public Branch() {
		super();
	}

	public Branch(int branchId, String brachName, int branchCode) {
		super();
		this.branchId = branchId;
		this.brachName = brachName;
		this.branchCode = branchCode;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBrachName() {
		return brachName;
	}

	public void setBrachName(String brachName) {
		this.brachName = brachName;
	}

	public int getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}

	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", brachName=" + brachName + ", branchCode=" + branchCode + "]";
	}

}
