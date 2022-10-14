package com.coder.result.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coder.result.entity.Student;
import com.coder.result.exception.StudentIsNotAvailable;
import com.coder.result.exception.StudentIsNotPrecent;
import com.coder.result.exception.StudentIsAlreadyPrecent;
import com.coder.result.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/saveStudent")
	public ResponseEntity<Boolean> saveStudent(@Valid @RequestBody Student student) {
		System.out.println(student);

		boolean isAdded = studentService.saveStudent(student);
		if (isAdded == true) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.OK);
		} else {
			throw new StudentIsAlreadyPrecent(
					"Student Is Alreadyt Precent On This rollNumber " + student.getStudentRollNo());
		}

	}

	@GetMapping("/getStudent")
	public ResponseEntity<Student> getStudent(@Valid @RequestParam String studentRollNumber) {

		Student student = studentService.getStudent(studentRollNumber);

		if (student != null) {
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		} else {
			throw new StudentIsNotAvailable("Student is not Available for this rollNumber " + studentRollNumber);
		}

	}

	@PutMapping("/updateStudent")
	public ResponseEntity<Boolean> updateStudent(@Valid @RequestBody Student student) {
		boolean isUpdated = studentService.updateStudent(student);
		if (isUpdated == true) {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.OK);
		} else {
			throw new StudentIsNotPrecent("Student Is NOT Precent in this Id " + student.getStudentRollNo());
		}

	}

	@GetMapping("/GetStudentResultByrollnumber")
	public ResponseEntity<Map<String, Object>> GetStudentResultByrollnumber(@RequestParam String rollNumber) {
		Map<String, Object> result = studentService.GetStudentResultByrollnumber(rollNumber);
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);

	}

}
