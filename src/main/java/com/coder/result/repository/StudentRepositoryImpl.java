package com.coder.result.repository;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coder.result.entity.Arts;
import com.coder.result.entity.Bsc;
import com.coder.result.entity.Student;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveStudent(Student student) {
		Session session = null;
		Transaction transaction = null;
		boolean isAdded = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Student std = session.get(Student.class, student.getStudentRollNo());
			if (std == null) {
				System.out.println(student);
				session.save(student);
				transaction.commit();
				isAdded = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return isAdded;
	}

	@Override
	public Student getStudent(String studentId) {
		Session session = null;
		Student student = null;
		try {
			session = sessionFactory.openSession();
			student = session.get(Student.class, studentId);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return student;
	}

	@Override
	public boolean updateStudent(Student student) {
		Session session = null;
		Transaction transaction = null;
		boolean isUpdated = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Student std = session.get(Student.class, student.getStudentRollNo());
			if (std.getStudentRollNo() == student.getStudentRollNo()) {

				std.setStudentDOb(student.getStudentDOb());
				std.setStudentName(student.getStudentName());
				session.update(std);
				transaction.commit();
				isUpdated = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isUpdated;
	}

	@Override
	public Map<String, Object> GetStudentResultByrollnumber(String rollNumber) {
		Session session = null;
		Transaction transaction = null;
		Map<String, Object> map = new HashMap<>();
		try {
			session = sessionFactory.openSession();
			Student student = session.get(Student.class, rollNumber);
			map.put("Student info", student);
			String branch = student.getBranch().getBrachName();

			if (branch.equals("Bsc")) {
				Bsc bsc = session.get(Bsc.class, rollNumber);
				map.put("result", bsc);
			} else if (branch.equals("Arts")) {
				Arts arts = session.get(Arts.class, rollNumber);
				map.put("result", arts);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return map;
	}

}
