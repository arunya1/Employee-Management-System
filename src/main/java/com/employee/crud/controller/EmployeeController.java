package com.employee.crud.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.crud.entity.Employee;
import com.employee.crud.service.IEmployeeService;

@RestController
public class EmployeeController {

	
	Logger logger=LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	IEmployeeService iEmployeeService;
	
	
	@PostMapping("/insert")
	public ResponseEntity<Employee>  insertEmployee(@RequestBody Employee employee) {
		logger.debug("Entered into Controller Layer");
		
		 employee=iEmployeeService.saveEmployee(employee);
		 logger.debug("Existed from Controller Layer");
		 if(employee!=null) {
				return new ResponseEntity<Employee>(employee, HttpStatus.OK);
			}else {
				return new ResponseEntity<Employee>(employee, HttpStatus.NOT_FOUND);
			}
		 
		 
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		logger.debug("Entered into Controller Layer");
		
		List<Employee> employee = iEmployeeService.getAllEmployee();
		 logger.debug("Existed from Controller Layer");
		if(employee!=null) {
			logger.info("Response fetched from Service Layer"+ employee );
			return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Employee>>(employee, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
		logger.debug("Entered into Controller Layer");
		
		 Employee employee = iEmployeeService.getEmployeeById(id);
		 logger.debug("Existed from Controller Layer");
		 if(employee!=null) {
			logger.info("Response fetched from Service Layer"+ employee);
			 return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		 }else {
			 return new ResponseEntity<Employee>(employee, HttpStatus.NOT_FOUND);
		 }
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public String deleteEmployeeById(@PathVariable("id") Integer id) {
		logger.debug("Entered into Controller Layer");
		
		iEmployeeService.deleteEmployeeById(id);
		 logger.debug("Existed from Controller Layer");
		return "Deleted Successfully";
		
	}
	
	@DeleteMapping("/empdeletebyid/{employee_id}")
	public String deleteEmpById(@PathVariable("employee_id") String employee_id) {
		logger.debug("Entered into Controller Layer");
		
		iEmployeeService.deleteEmployeeById(employee_id);
		 logger.debug("Existed from Controller Layer");
		return "Deleted Successfully";
		
	}
	
	@DeleteMapping("/deletebyname/{employee_name}")
	public String deleteEmpByName(@PathVariable("employee_name") String employee_name) {
		logger.debug("Entered into Controller Layer");
		
		iEmployeeService.deleteEmployeeByName(employee_name);
		 logger.debug("Existed from Controller Layer");
		return "Deleted Successfully";
		
	}
	
	@PutMapping("/updatebyid/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,
			@PathVariable("id") Integer id) {
		logger.debug("Entered into Controller Layer");
		
		employee= iEmployeeService.updateEmployee(employee, id);
		 logger.debug("Existed from Controller Layer");
		if(employee!=null) {
			logger.info("Response fetched from Service layer"+ employee);
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}else {
			return new ResponseEntity<Employee>(employee, HttpStatus.NOT_MODIFIED);
		}
	}
	 
	@GetMapping("/getbyname/{employee_name}")
	public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable("employee_name") String employee_name){
		logger.debug("Entered into Controller Layer");
		
		List<Employee> employee = iEmployeeService.getEmployeeByName(employee_name);
		 logger.debug("Existed from Controller Layer");
		if(employee!=null) {
			logger.info("Response fetched from Service layer"+ employee);
			return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Employee>>(employee, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/empgetbyid/{employee_id}")
	public ResponseEntity<Employee> employeeGetById(@PathVariable("employee_id") String employee_id) {
		logger.debug("Entered into Controller Layer");
		
		Employee employee = iEmployeeService.employeeGetById(employee_id);
		 logger.debug("Existed from Controller Layer");
		if(employee!=null) {
			logger.info("Response fetched from Service layer"+ employee);
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}else {
			return new ResponseEntity<Employee>(employee, HttpStatus.NOT_FOUND);
		}
		
	}

	@GetMapping("/getbyage/{age}")
	public ResponseEntity<List<Employee>> getEmployeeByAge(@PathVariable("age") int age){
		logger.debug("Entered into Controller Layer");
		
		List<Employee> employee = iEmployeeService.getEmployeeByAge(age);
		 logger.debug("Existed from Controller Layer");
		if(employee!=null) {
			logger.info("Response fetched from Service layer"+ employee);
			return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Employee>>(employee, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getbyaddress/{employee_address}")
	public ResponseEntity<List<Employee>> getEmployeeByAddress(@PathVariable("employee_address") String employee_address){
		logger.debug("Entered into Controller Layer");
		
		 List<Employee> employee = iEmployeeService.getEmployeeByAddress(employee_address);
		 logger.debug("Existed from Controller Layer");
		 if(employee!=null) {
			 logger.info("Response fetched from Service layer"+ employee);
			 return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
		 }else {
			 return new ResponseEntity<List<Employee>>(employee, HttpStatus.NOT_FOUND);
		 }
		
	}
	
	@GetMapping("/getbydesignationandaddress/{employee_designation}/{employee_address}")
	public ResponseEntity<List<Employee>> getByDesignationAndAddress(@PathVariable("employee_designation") String employee_designation,
			@PathVariable("employee_address") String employee_address){
		logger.debug("Entered into Controller Layer");
		
		
		 List<Employee> employee = iEmployeeService.getByDesignationAndAddess(employee_designation, employee_address);
		 logger.debug("Existed from Controller Layer");
		 if(employee!=null) {
			 logger.info("Response fetched from Service layer"+ employee);
			 return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
		 }else {
			 return new ResponseEntity<List<Employee>>(employee, HttpStatus.NOT_FOUND);
		 }
	}
	
	@GetMapping("/getbydesignationoraddress/{employee_designation}/{employee_address}")
	public ResponseEntity<List<Employee>> getbyDesignationOrAddress(@PathVariable("employee_designation") String employee_designation,
			@PathVariable("employee_address") String employee_address){
		logger.debug("Entered into Controller Layer");
		
		
	   List<Employee> employee = iEmployeeService.getbyDesignationOrAddress(employee_designation, employee_address);
	   logger.debug("Existed from Controller Layer");
		if(employee!=null) {
			 logger.info("Response fetched from Service layer"+ employee);
			return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Employee>>(employee, HttpStatus.NOT_FOUND);
		}
	}	
	
}
