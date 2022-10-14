package com.coder.result.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.coder.result.entity.Admin;
import com.coder.result.entity.Arts;
import com.coder.result.entity.Branch;
import com.coder.result.entity.Bsc;
import com.coder.result.entity.College;
import com.coder.result.entity.Student;

@Component
public interface AdminService {

	// for admin
	public boolean registerAdmin(Admin admin);

	// for student
	public boolean updateStudent(Student student);

	public List<Student> getAllStudent();

	public boolean deleteStudent(String studentId);

	// for colleges
	public boolean addCollege(College college);

	public boolean addBranch(Branch branch);

	public Map<String, String> uploadSheet(CommonsMultipartFile file, HttpSession httpSession);

	public Map<String, String> uploadSheetArts(CommonsMultipartFile file, HttpSession httpSession);

	public Map<String, Object> getStudentResultByrollnumber(String rollNumber);

	public List<Bsc> getListOfBscStudentResult();

	public List<Arts> getListOfArtsStudentResult();

	public List<Object> getAllStudentResult();

}
