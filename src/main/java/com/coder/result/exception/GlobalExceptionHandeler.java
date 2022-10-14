package com.coder.result.exception;

import java.util.Date;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandeler {
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public HashMap<String,Object> MethodArgumentNotValidexemple(MethodArgumentNotValidException ex){
				HashMap<String, Object> map = new HashMap<>();
				map.put("Time", new Date());
		
				ex.getBindingResult().getFieldErrors().forEach(error -> {
					map.put(error.getField(), error.getDefaultMessage());
				});
		
		
		return map;
	}
	
	@ExceptionHandler(AdminIsAlreadyPrecent.class)
	public ResponseEntity<String> ProductIsAlreadyPrecent(AdminIsAlreadyPrecent ex){
		
		return  new ResponseEntity<String>(ex.getMessage(),HttpStatus.OK);
	}
	
	@ExceptionHandler(StudentIsAlreadyPrecent.class)
	public ResponseEntity<String> StudentIsAlreadyPrecent(StudentIsAlreadyPrecent studentEx){
		return new ResponseEntity<String>(studentEx.getMessage(),HttpStatus.OK);
		
	}
	
	@ExceptionHandler(StudentIsNotPrecent.class)
	public ResponseEntity<String> StudentIsNotAvailable(StudentIsNotAvailable  studentEx){
		return new ResponseEntity<String>(studentEx.getMessage(),HttpStatus.OK);
		
	}
	
	@ExceptionHandler(StudentListIsEmpty.class)
	public  ResponseEntity<String> StudentListIsEmpty(StudentListIsEmpty ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.OK);
	}
	
	
	@ExceptionHandler(CollegeIsAlreadyPrecent.class)
	public ResponseEntity<String> CollegeIsAlreadyPrecent(CollegeIsAlreadyPrecent ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.OK);
	}

	@ExceptionHandler(BranchIsAlreadyPrecent.class)
	public ResponseEntity<String> BranchIsAlreadyPrecent(BranchIsAlreadyPrecent branchEx){
		return new ResponseEntity<String>(branchEx.getMessage(),HttpStatus.OK);
	}
	
	@ExceptionHandler(InvalidRollNumber.class)
	public ResponseEntity<String> InvalidRollNumber(InvalidRollNumber invalidEx){
		return new ResponseEntity<String>(invalidEx.getMessage(),HttpStatus.OK);
	}
	
	@ExceptionHandler(ResultIsNotDeclair.class)
	public ResponseEntity<String> ResultIsNotDeclair(ResultIsNotDeclair invalidEx){
		return new ResponseEntity<String>(invalidEx.getMessage(),HttpStatus.OK);
	}
	
	@ExceptionHandler(ResultIsNotPrecent.class)
	public ResponseEntity<String> ResultIsNotPrecent(ResultIsNotPrecent resultEx){
		return new ResponseEntity<String>(resultEx.getMessage(),HttpStatus.OK);
	}
	
	@ExceptionHandler(ObjectIsNullException.class)
	public ResponseEntity<String> YourAdminIsNullException(ObjectIsNullException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.OK);
	}
	
}
