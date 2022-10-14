package com.coder.result.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.coder.result.entity.Admin;
import com.coder.result.entity.Arts;
import com.coder.result.entity.Branch;
import com.coder.result.entity.Bsc;
import com.coder.result.entity.College;
import com.coder.result.entity.Student;
import com.coder.result.exception.AdminIsAlreadyPrecent;
import com.coder.result.exception.BranchIsAlreadyPrecent;
import com.coder.result.exception.CollegeIsAlreadyPrecent;
import com.coder.result.exception.InvalidRollNumber;
import com.coder.result.exception.ResultIsNotDeclair;
import com.coder.result.exception.ResultIsNotPrecent;
import com.coder.result.exception.StudentIsNotPrecent;
import com.coder.result.exception.StudentListIsEmpty;
import com.coder.result.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@PostMapping("/registerAdmin")
	public ResponseEntity<Boolean> registerAdmin(@Valid @RequestBody Admin admin) {

		System.out.println(admin);
		boolean isAdded = adminService.registerAdmin(admin);

		if (isAdded == true) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.OK);
		} else {
			throw new AdminIsAlreadyPrecent("Admin is Already precent for this id " + admin.getAdminId());
		}

	}

	@PutMapping("/updateStudent")
	public ResponseEntity<Boolean> updateStudent(@Valid @RequestBody Student student) {
		boolean isUpdated = adminService.updateStudent(student);
		if (isUpdated == true) {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.OK);
		} else {
			throw new StudentIsNotPrecent("Student Is NOT Precent in this rollNumber" + student.getStudentRollNo());
			
		}

	}

	@GetMapping("/getAllStudent")
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> allStudent = adminService.getAllStudent();
		if (!allStudent.isEmpty()) {
			return new ResponseEntity<List<Student>>(allStudent, HttpStatus.OK);
		} else {
			throw new StudentListIsEmpty("student not available on list");
		}
	}

	@DeleteMapping("/deleteStudent/{studentId}")
	public ResponseEntity<Boolean> deleteStudent(@PathVariable String rollNumber) {

		boolean isDeleted = adminService.deleteStudent(rollNumber);
		if (isDeleted == true) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		} else {
			throw new StudentIsNotPrecent("student is not available for this rollNumber" + rollNumber);
		}

	}

	@PostMapping("/addCollege")
	public ResponseEntity<Boolean> addCollege(@Valid @RequestBody College college) {
		boolean isAdded = adminService.addCollege(college);
		if (isAdded == true) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.OK);
		} else {
			throw new CollegeIsAlreadyPrecent("college is already precent for this id " + college.getCollegeId());
		}

	}

	@PostMapping("/addBranch")
	public ResponseEntity<Boolean> addBranch(@Valid @RequestBody Branch branch) {
		boolean isAdded = adminService.addBranch(branch);
		if (isAdded == true) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.OK);
		} else {
			throw new BranchIsAlreadyPrecent("college is already precent for this id " + branch.getBranchId());
		}

	}

	@PostMapping("/uploadSheet")
	public ResponseEntity<Map<String, String>> uploadSheet(@RequestParam CommonsMultipartFile file,
			HttpSession session) {
		Map<String, String> map = adminService.uploadSheet(file, session);
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);

	}

	@PostMapping("/uploadSheetArts")
	public ResponseEntity<Map<String, String>> uploadSheetArts(@RequestParam CommonsMultipartFile file,
			HttpSession httpSession) {
		Map<String, String> map = adminService.uploadSheetArts(file, httpSession);
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}

	@GetMapping("/getStudentResultByrollnumber")
	public ResponseEntity<Map<String, Object>> getStudentResultByrollnumber(String rollNumber) {
		Map<String, Object> map = adminService.getStudentResultByrollnumber(rollNumber);
		if (!map.isEmpty()) {
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			throw new InvalidRollNumber("Your roll number is invalid" + rollNumber);
		}
	}

	@GetMapping("/getListOfBscStudentResult")
	public ResponseEntity<List<Bsc>> getListOfBscStudentResult() {
		List<Bsc> results = adminService.getListOfBscStudentResult();
		if (!results.isEmpty()) {
			return new ResponseEntity<List<Bsc>>(results, HttpStatus.OK);
		} else {
			throw new ResultIsNotDeclair("Result is not declair for Bsc");
		}

	}

	@GetMapping("/getListOfArtsStudentResult")
	public ResponseEntity<List<Arts>> getListOfArtsStudentResult() {
		List<Arts> results = adminService.getListOfArtsStudentResult();
		if (!results.isEmpty()) {
			return new ResponseEntity<List<Arts>>(results, HttpStatus.OK);
		} else {
			throw new ResultIsNotDeclair("Result is not declair for Arts");
		}

	}

	@GetMapping("/getAllStudentResult")
	public ResponseEntity<List<Object>> getAllStudentResult() {
		List<Object> allStudentResult = adminService.getAllStudentResult();
		if (!allStudentResult.isEmpty()) {
			return new ResponseEntity<List<Object>>(allStudentResult, HttpStatus.OK);
		} else {
			throw new ResultIsNotPrecent("Result is not precent in database");
		}
	}

}
