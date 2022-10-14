package com.coder.result.service;

import java.util.Map;

import com.coder.result.entity.Student;

public interface StudentService {
	
	public boolean saveStudent(Student student);
	
	public Student getStudent(String studentId);
	
	public boolean updateStudent(Student student) ;
	
	public Map<String, Object> GetStudentResultByrollnumber(String rollNumber);

}
