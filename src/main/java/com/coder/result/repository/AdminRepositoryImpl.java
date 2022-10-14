package com.coder.result.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.log.LogAccessor;
import org.springframework.stereotype.Repository;

import com.coder.result.entity.Admin;
import com.coder.result.entity.Arts;
import com.coder.result.entity.Branch;
import com.coder.result.entity.Bsc;
import com.coder.result.entity.College;
import com.coder.result.entity.Student;

@Repository
public class AdminRepositoryImpl implements AdminRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private Student student;

	@Override
	public boolean registerAdmin(Admin admin) {
		Session session = null;
		Transaction transaction = null;
		boolean isAdded = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Admin adm = session.get(Admin.class, admin.getAdminId());
			if (adm == null) {
				session.save(admin);
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
	public boolean updateStudent(Student student) {
		Session session = null;
		Transaction transaction = null;
		boolean isAdded = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Student std = session.get(Student.class, student.getStudentRollNo());
			
			if (std != null) {
				session.evict(std);
				session.update(student);
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
	public List<Student> getAllStudent() {
		Session session = null;
		List<Student> listStudent = null;
		try {
			session = sessionFactory.openSession();
			listStudent = session.createCriteria(Student.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return listStudent;
	}

	@Override
	public boolean deleteStudent(String studentId) {
		Session session = null;
		Transaction transaction = null;
		boolean isDeleted = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Student student = session.get(Student.class, studentId);
			if (student != null) {
				session.delete(student);
				transaction.commit();
				isDeleted = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isDeleted;
	}

	@Override
	public boolean addCollege(College college) {
		Session session = null;
		Transaction transaction = null;
		boolean isAdded = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			College clg = session.get(College.class, college.getCollegeId());
			if (clg == null) {
				session.save(college);
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
	public boolean addBranch(Branch branch) {
		Session session = null;
		Transaction transaction = null;
		boolean isAdded = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Branch brnch = session.get(Branch.class, branch.getBranchId());
			if (brnch == null) {
				session.save(branch);
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
	public int uploadBscMarksList(List<Bsc> list) {
		Session session = null;
		Transaction transaction = null;
		int count = 0;
		try {
			for (Bsc bsc : list) {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				session.save(bsc);
				transaction.commit();
				count = count + 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return count;

	}

	@Override
	public int uploadArtsMarksList(List<Arts> list) {
		Session session = null;
		Transaction transaction = null;
		int count = 0;
		try {
			for (Arts arts : list) {
				System.out.println(list);
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				session.save(arts);
				transaction.commit();
				count = count + 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return count;
	}

	@Override
	public Map<String, Object> getStudentResultByrollnumber(String rollNumber) {
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

	@Override
	public List<Bsc> getListOfBscStudentResult() {
		Session session = null;
		List<Bsc> list = null;
		try {
			session = sessionFactory.openSession();

			list = session.createCriteria(Bsc.class).list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<Arts> getListOfArtsStudentResult() {
		Session session = null;
		List<Arts> list = null;
		try {
			session = sessionFactory.openSession();

			list = session.createCriteria(Arts.class).list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;

	}

}
