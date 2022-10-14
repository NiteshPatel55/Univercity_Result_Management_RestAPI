package com.coder.result.entity;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Component
public class Student {
	

	@Id
	private String studentRollNo;
	
	@NotNull(message =  "Student name is requered")
	private String studentName;
	
	
	
	
	
	
	@NotNull(message =  "Student DOB is requered")
	@JsonFormat(pattern = "dd/mm/yyyy")
	private String studentDOb;
	
	
	@OneToOne(targetEntity = Branch.class,cascade = CascadeType.ALL)
	private Branch  branch;
	
	
	

	public Student() {
		super();
	}

	public Student( @NotNull(message = "Student name is requered") String studentName,
			@Min(1) String studentRollNo, @NotNull(message = "Student DOB is requered") String studentDOb,
			Branch branch) {
		super();
		this.studentName = studentName;
		this.studentRollNo = studentRollNo;
		this.studentDOb = studentDOb;
		this.branch = branch;
	}
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentRollNo() {
		return studentRollNo;
	}
	public void setStudentRollNo(String studentRollNo) {
		this.studentRollNo = studentRollNo;
	}
	public String getStudentDOb() {
		return studentDOb;
	}
	public void setStudentDOb(String studentDOb) {
		this.studentDOb = studentDOb;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Student [studentRollNo=" + studentRollNo + ", studentName=" + studentName + ", studentDOb=" + studentDOb
				+ ", branch=" + branch + "]";
	}

}
