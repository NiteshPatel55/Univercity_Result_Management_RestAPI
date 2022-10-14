package com.coder.result.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.coder.result.entity.Admin;
import com.coder.result.entity.Arts;
import com.coder.result.entity.Branch;
import com.coder.result.entity.Bsc;
import com.coder.result.entity.College;
import com.coder.result.entity.Student;

@Component
public interface AdminRepository {

	public boolean registerAdmin(Admin admin);

	// for student
	public boolean updateStudent(Student student);

	public List<Student> getAllStudent();

	public boolean deleteStudent(String studentId);

	// for collage Add
	public boolean addCollege(College college);

	public boolean addBranch(Branch branch);

	public int uploadBscMarksList(List<Bsc> list);

	public int uploadArtsMarksList(List<Arts> list);

	public Map<String, Object> getStudentResultByrollnumber(String rollNumber);

	public List<Bsc> getListOfBscStudentResult();

	public List<Arts> getListOfArtsStudentResult();

}
