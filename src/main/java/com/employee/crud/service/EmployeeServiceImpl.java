package com.employee.crud.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.crud.entity.Employee;
import com.employee.crud.repository.IEmployeeRepository;

@Component
public class EmployeeServiceImpl implements IEmployeeService {

	Logger logger=LoggerFactory.getLogger(EmployeeServiceImpl.class);
	@Autowired
	IEmployeeRepository iEmployeeRepository;
	

	@Override
	public Employee saveEmployee(Employee employee) {
		logger.debug("Entered into Service Layer");
		
		try {
			employee= iEmployeeRepository.save(employee);
			if(employee!=null) {
				logger.info("response fetched from Controller Layer and inserted successfully:"+ employee);
			}else {
				logger.warn("employee must be not null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Invalid data or employee must be not null");
		}
		logger.debug("Existed from Service Layer");
		 return employee;
	}


	@Override
	public List<Employee> getAllEmployee() {
		logger.debug("Entered into Service Layer");
		
		logger.debug("Existed from Service Layer");
		return iEmployeeRepository.findAllEmployee();
	}


	@Override
	public Employee getEmployeeById(Integer id) {
		logger.debug("Entered into Service Layer");
		
		try {
			if(id!=null) {
				logger.info("Response fetched from Controller Layer:"+ id);
			}else {
				logger.warn("id must be not null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("invalid id or id must be not null");
			
		}
		logger.debug("Existed from Service Layer");
		return iEmployeeRepository.findById(id).get();
	}


	@Override
	public void deleteEmployeeById(Integer id) {
		logger.debug("Entered into Service Layer");
		
		try {
			if(id!=null) {
				logger.info("Response fetched from Controller Layer:"+ id);
			}else {
				logger.warn("id must be not null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("invalid id or id must be not null");
			
		}
		logger.debug("Existed from Service Layer");
		iEmployeeRepository.deleteById(id);
	}


	@Override
	public Employee updateEmployee(Employee employee, Integer id) {
		logger.debug("Entered into Service Layer");
		
		try {
			if(id!=null) {
				logger.info("Response fetched from Controller Layer:"+id);
			}else {
				logger.warn("id must be not null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("invalid id or id must be not null");
			
		}
		Employee ExistingRecord = iEmployeeRepository.findById(id).get();
		
		ExistingRecord.setEmployeeName(employee.getEmployeeName());
		ExistingRecord.setEmployeeId(employee.getEmployeeId());
		ExistingRecord.setEmployeeDesignation(employee.getEmployeeDesignation());
		ExistingRecord.setEmployeePhoneNo(employee.getEmployeePhoneNo());
		ExistingRecord.setEmployeeAddress(employee.getEmployeeAddress());
		
		employee= iEmployeeRepository.save(ExistingRecord);
		logger.info("Data updated:"+ employee);
		logger.debug("Existed from Service Layer");
		return employee;
	}


	@Override
	public List<Employee> getEmployeeByName(String employee_name) {
		logger.debug("Entered into Service Layer");
		
		try {
			if(employee_name!=null) {
				logger.info("Response fetched from Controller Layer:"+ employee_name);
			}else {
				logger.warn("employee_name must be not null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("invalid employee_name or employee_name must be not null");
			
		}
		
		logger.debug("Existed from Service Layer");
		return iEmployeeRepository.findByEmployeeName(employee_name);
	}


	@Override
	public Employee employeeGetById(String employee_id) {
		logger.debug("Entered into Service Layer");
		
		try {
			if(employee_id!=null) {
				logger.info("Response fetched from Controller Layer:"+employee_id);
			}else {
				logger.warn("employee_id must be not null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("invalid employee_id or employee_id must be not null");
			
		}
		
		
		logger.debug("Existed from Service Layer");
		return iEmployeeRepository.findByEmployeeId(employee_id);
	}
			

	@Override
	public List<Employee> getByDesignationAndAddess(String employee_designation, String employee_address) {
		logger.debug("Entered into Service Layer");
		
		try {
			if(employee_designation!=null & employee_address!=null) {
				logger.info("Response fetched from Controller Layer:"+employee_designation+ employee_address);
			}else {
				logger.warn("employee_designation and employee_address must be not null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("invalid employee_designation and employee_address or"
					+" employee_designation and employee_address must be not null");	
		}
		
		
		logger.debug("Existed from Service Layer");
		return iEmployeeRepository.findByEmployeeDesignationAndEmployeeAddress(employee_designation, employee_address);
	}


	@Override
	public List<Employee> getbyDesignationOrAddress(String employee_designation, String employee_address) {
		logger.debug("Entered into Service Layer");
	
		try {
			if(employee_designation!=null | employee_address!=null) {
				logger.info("Response fetched from Controller Layer:"+ employee_designation +  employee_address);
			}else {
				logger.warn("employee_designation or employee_address must be not null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("invalid employee_designation or employee_address or"
					+" employee_designation or employee_address must be not null");	
		}
		
		logger.debug("Existed from Service Layer");
		return iEmployeeRepository.findByEmployeeDesignationOrEmployeeAddress(employee_designation, employee_address);
	}


	
	@Override
	public List<Employee> getEmployeeByAge(Integer age) {
		logger.debug("Entered into Service Layer");
		
		try {
			if(age!=null) {
				logger.info("Response fetched from Controller Layer:"+ age);
			}else {
				logger.warn("age must be not null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("invalid age or age must be not null");
			
		}
		
		logger.debug("Existed from Service Layer");
		return iEmployeeRepository.findByAgeLessThan(age);
	}


	@Override
	public List<Employee> getEmployeeByAddress(String employee_address) {
		logger.debug("Entered into Service Layer");
		
		try {
			if(employee_address!=null) {
				logger.info("Response fetched from Controller Layer:"+ employee_address);
			}else {
				logger.warn("employee_address must be not null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("invalid employee_address or employee_address must be not null");
			
		}
		
		logger.debug("Existed from Service Layer");
		return iEmployeeRepository.getByEmployeeAddress(employee_address);
	}


	@Override
	public void deleteEmployeeById(String employee_id) {
		logger.debug("Entered into Service Layer");
		
		
		try {
			if(employee_id!=null) {
				logger.info("Response fetched from Controller Layer:"+ employee_id);
			}else {
				logger.warn("employee_id must be not null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("invalid employee_id or employee_id must be not null");
			
		}
		
		logger.debug("Existed from Service Layer");
		iEmployeeRepository.deleteByEmployeeId(employee_id);
		
	}


	@Override
	public void deleteEmployeeByName(String employee_name) {
		logger.debug("Entered into Service Layer");
		

		try {
			if(employee_name!=null) {
				logger.info("Response fetched from Controller Layer:"+ employee_name);
			}else {
				logger.warn("employee_name must be not null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("invalid employee_name or employee_name must be not null");
			
		}
		
		logger.debug("Existed from Service Layer");
		iEmployeeRepository.deleteByEmployeeName(employee_name);
		
	}	

}
