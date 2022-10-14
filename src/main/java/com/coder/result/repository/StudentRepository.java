package com.coder.result.repository;

import java.util.Map;

import com.coder.result.entity.Student;

public interface StudentRepository {
	
	public boolean saveStudent(Student student);
	
	public Student getStudent(String studentId);

	public boolean updateStudent(Student student);
	
	public Map<String, Object> GetStudentResultByrollnumber(String rollNumber);
}
