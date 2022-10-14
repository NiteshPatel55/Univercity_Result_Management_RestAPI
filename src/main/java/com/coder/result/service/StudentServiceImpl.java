package com.coder.result.service;

import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.result.entity.Student;
import com.coder.result.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public boolean saveStudent(Student student) {

		String timeStamp = new SimpleDateFormat("yyMMddhhmmss").format(new java.util.Date());
		student.setStudentRollNo(timeStamp);
		boolean isAdded = studentRepository.saveStudent(student);

		return isAdded;
	}

	@Override
	public Student getStudent(String studentId) {
		Student student = studentRepository.getStudent(studentId);
		return student;

	}

	@Override
	public boolean updateStudent(Student student) {
		boolean isUpdated = studentRepository.updateStudent(student);
		return isUpdated;
	}

	@Override
	public Map<String, Object> GetStudentResultByrollnumber(String rollNumber) {
		Map<String, Object> map = studentRepository.GetStudentResultByrollnumber(rollNumber);
		return map;
	}

}
