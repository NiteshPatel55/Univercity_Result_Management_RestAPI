package com.coder.result.validator;

import com.coder.result.entity.Arts;
import com.coder.result.entity.Bsc;

public class ValidateObject {

	public static boolean validateProduct(Bsc bsc) {

		boolean isValid = true;
		if (bsc.getStudentRollNo() == null || bsc.getStudentRollNo().equals("")) {
			isValid = false;
		}
		if (bsc.getMathemetics() <= 0) {
			isValid = false;
		}
		if (bsc.getChemestry() <= 0) {
			isValid = false;
		}
		if (bsc.getPhysics() <= 0) {
			isValid = false;
		}
		if (bsc.getHindi() <= 0) {
			isValid = false;
		}
		if (bsc.getEnglish() <= 0) {
			isValid = false;
		}
		if (bsc.getBrachCode() <= 0) {
			isValid = false;
		}

		return isValid;
	}

	public static boolean validateProductArts(Arts arts) {

		boolean isValid = true;
		if (arts.getStudentRollNo() == null || arts.getStudentRollNo().equals("")) {
			isValid = false;
		}
		if (arts.getHistory() <= 0) {
			isValid = false;
		}
		if (arts.getGiography() <= 0) {
			isValid = false;
		}
		if (arts.getEconomy() <= 0) {
			isValid = false;
		}
		if (arts.getHindi() <= 0) {
			isValid = false;
		}
		if (arts.getEnglish() <= 0) {
			isValid = false;
		}
		if (arts.getBrachCode() <= 0) {
			isValid = false;
		}

		return isValid;
	}

	public static Boolean checkIfObjectNull(Object object) {
		System.out.println("kiran");
		if (object == null) {
			return true;
		} else {
			return false;
		}
	}

}
