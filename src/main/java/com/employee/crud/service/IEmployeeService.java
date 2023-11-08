package com.employee.crud.service;

import java.util.List;

import com.employee.crud.entity.Employee;



public interface IEmployeeService {
	
	
	public Employee saveEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
	
	public Employee getEmployeeById(Integer id);
	
	public void deleteEmployeeById(Integer id);
	
	public Employee updateEmployee(Employee employee,Integer id);
	
	public List<Employee> getEmployeeByName(String employee_name);
	
	public Employee employeeGetById(String employee_id);
	
	public List<Employee> getByDesignationAndAddess(String employee_designation,String employee_address);

	public List<Employee> getbyDesignationOrAddress(String employee_designation,String employee_address);
	
	
	public List<Employee> getEmployeeByAge(Integer age);
	
	public List<Employee> getEmployeeByAddress(String employee_address);
	
	public void deleteEmployeeById(String employee_id);
	
	public void deleteEmployeeByName(String employee_name);
	
}
