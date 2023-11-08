package com.employee.crud.model;

public class EmployeeCheck {
	
	public static void main(String[] args) {
		
		Employee employee=new Employee();			//Checking whether the Lombok is working or not
		
		employee.getEmployeeName();					//Lombok is working Successfully
		employee.getEmployeeId();
		employee.getEmployeeDesignation();
		employee.getEmployeePhoneNo();
		employee.getEmployeeAddress();
	}

}
