package com.coder.result.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.coder.result.entity.Admin;
import com.coder.result.entity.Arts;
import com.coder.result.entity.Branch;
import com.coder.result.entity.Bsc;
import com.coder.result.entity.College;
import com.coder.result.entity.Student;
import com.coder.result.exception.ObjectIsNullException;
import com.coder.result.repository.AdminRepository;
import com.coder.result.validator.ValidateObject;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	String excludedRows = "";
	int totalRecordCount = 0;

	
	
		
	
	
	
	@Override
	public boolean registerAdmin(Admin admin) {
		
				Boolean check = ValidateObject.checkIfObjectNull(admin);
				if(check==true) {
					String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());

					admin.setAdminId(timeStamp);

					boolean isAdded = adminRepository.registerAdmin(admin);
					return isAdded;
				}else {
					
					throw new ObjectIsNullException("Your Admin is null so please add the admin  data");
				}
	}

	@Override
	public boolean updateStudent(Student student) {
		Boolean check =ValidateObject.checkIfObjectNull(student);
		System.out.println(check);
		if(check!=true) {
		boolean isUpdated = adminRepository.updateStudent(student);
		return isUpdated;
		}else {
			throw new ObjectIsNullException("your student data is  null so please add the data");
		}
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> allStudent = adminRepository.getAllStudent();
		return allStudent;
	}

	@Override
	public boolean deleteStudent(String studentId) {
		boolean isDeleted = adminRepository.deleteStudent(studentId);
		return isDeleted;
	}

	@Override
	public boolean addCollege(College college) {
		Boolean isNull = ValidateObject.checkIfObjectNull(college);
		if(isNull==true) {
		if (college.getCollegeId() == null) {
			String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
			college.setCollegeId(timeStamp);
		}
		boolean isAdded = adminRepository.addCollege(college);
		return isAdded;
		}else {
			throw new ObjectIsNullException("College data is null so can  please add  college details  ");
		}
		
	}

	@Override
	public boolean addBranch(Branch branch) {
		boolean isAdded = adminRepository.addBranch(branch);
		return isAdded;
	}

	public List<Bsc> readExcel(String filpath) {
		Workbook workbook = null;
		FileInputStream filinput = null;
		List<Bsc> list = new ArrayList<>();
		Bsc bsc = null;
		try {
			filinput = new FileInputStream(new File(filpath));
			workbook = new XSSFWorkbook(filinput);

			Sheet sheet = workbook.getSheet("Bsc");
			totalRecordCount = sheet.getLastRowNum();
			Iterator<Row> rows = sheet.iterator();
			int rowNumber = 0;
			while (rows.hasNext()) {
				Row row = rows.next();

				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}
				System.out.println(row);
				bsc = new Bsc();
				Iterator<Cell> cells = row.cellIterator();

				while (cells.hasNext()) {
					Cell cell = cells.next();

					int column = cell.getColumnIndex();
					switch (column) {
					case 0:
						bsc.setStudentRollNo(cell.getStringCellValue());
						break;
					case 1:

						bsc.setMathemetics((int) cell.getNumericCellValue());
						break;
					case 2:

						bsc.setPhysics((int) cell.getNumericCellValue());
						break;
					case 3:

						bsc.setChemestry((int) cell.getNumericCellValue());
						break;
					case 4:

						bsc.setHindi((int) cell.getNumericCellValue());
						break;
					case 5:

						bsc.setEnglish((int) cell.getNumericCellValue());
						break;
					case 6:

						bsc.setBrachCode((int) cell.getNumericCellValue());
						break;

					}

				}
				boolean isValid = ValidateObject.validateProduct(bsc);
				if (isValid) {
					list.add(bsc);
				} else {
					int rowNum = row.getRowNum() + 1;
					excludedRows = excludedRows + rowNum + ",";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null) {
					workbook.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public Map<String, String> uploadSheet(CommonsMultipartFile file, HttpSession httpSession) {
		String path = httpSession.getServletContext().getRealPath("/");
		String fileName = file.getOriginalFilename();

		HashMap<String, String> map = new HashMap<>();

		int uploadedCount = 0;
		FileOutputStream filoutput = null;
		byte[] data = file.getBytes();
		try {
			filoutput = new FileOutputStream(new File(path + File.separator + fileName));
			filoutput.write(data);

			List<Bsc> list = readExcel(path + File.separator + fileName);
			uploadedCount = adminRepository.uploadBscMarksList(list);

			map.put("Total Record In Sheet", String.valueOf(totalRecordCount));
			map.put("Uploaded Record In DB", String.valueOf(uploadedCount));
			map.put("Bad Record Row Number", excludedRows);
			map.put("Total Excluded", String.valueOf(totalRecordCount - uploadedCount));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	// for Arts result

	public List<Arts> readExcelArts(String filpath) {
		Workbook workbook = null;
		FileInputStream filinput = null;
		List<Arts> list = new ArrayList<>();
		Arts arts = null;
		try {
			filinput = new FileInputStream(new File(filpath));
			workbook = new XSSFWorkbook(filinput);

			Sheet sheet = workbook.getSheet("Arts");
			totalRecordCount = sheet.getLastRowNum();
			Iterator<Row> rows = sheet.iterator();
			int rowNumber = 0;
			while (rows.hasNext()) {
				Row row = rows.next();

				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}
				arts = new Arts();
				Iterator<Cell> cells = row.cellIterator();

				while (cells.hasNext()) {
					Cell cell = cells.next();

					int column = cell.getColumnIndex();
					switch (column) {
					case 0:
						arts.setStudentRollNo(cell.getStringCellValue());
						break;
					case 1:

						arts.setHistory((int) cell.getNumericCellValue());
						break;
					case 2:

						arts.setGiography((int) cell.getNumericCellValue());
						break;
					case 3:

						arts.setEconomy((int) cell.getNumericCellValue());
						break;
					case 4:

						arts.setHindi((int) cell.getNumericCellValue());
						break;
					case 5:

						arts.setEnglish((int) cell.getNumericCellValue());
						break;
					case 6:

						arts.setBrachCode((int) cell.getNumericCellValue());
						break;

					}

				}
				boolean isValid = ValidateObject.validateProductArts(arts);
				if (isValid) {
					list.add(arts);
				} else {
					int rowNum = row.getRowNum() + 1;
					excludedRows = excludedRows + rowNum + ",";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null) {
					workbook.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	@Override
	public Map<String, String> uploadSheetArts(CommonsMultipartFile file, HttpSession httpSession) {
		String path = httpSession.getServletContext().getRealPath("/");
		String fileName = file.getOriginalFilename();

		HashMap<String, String> map = new HashMap<>();

		int uploadedCount = 0;
		FileOutputStream filoutput = null;
		byte[] data = file.getBytes();
		try {
			filoutput = new FileOutputStream(new File(path + File.separator + fileName));
			filoutput.write(data);

			List<Arts> list = readExcelArts(path + File.separator + fileName);
			uploadedCount = adminRepository.uploadArtsMarksList(list);

			map.put("Total Record In Sheet", String.valueOf(totalRecordCount));
			map.put("Uploaded Record In DB", String.valueOf(uploadedCount));
			map.put("Bad Record Row Number", excludedRows);
			map.put("Total Excluded", String.valueOf(totalRecordCount - uploadedCount));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@Override
	public Map<String, Object> getStudentResultByrollnumber(String rollNumber) {
		Map<String, Object> map = adminRepository.getStudentResultByrollnumber(rollNumber);
		return map;
	}

	@Override
	public List<Bsc> getListOfBscStudentResult() {
		List<Bsc> result = adminRepository.getListOfBscStudentResult();
		return result;
	}

	@Override
	public List<Arts> getListOfArtsStudentResult() {
		List<Arts> result = adminRepository.getListOfArtsStudentResult();
		return result;
	}

	@Override
	public List<Object> getAllStudentResult() {
		List<Object> allStudentResult = new ArrayList<>();
		allStudentResult.addAll(getListOfBscStudentResult());
		allStudentResult.addAll(getListOfArtsStudentResult());
		return allStudentResult;
	}

}
