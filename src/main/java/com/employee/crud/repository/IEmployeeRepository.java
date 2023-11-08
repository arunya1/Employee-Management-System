package com.employee.crud.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.crud.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{

	//---------Custom Finder Methods/Derived Query Methods--------------
	
	public List<Employee> findByAge(int age);
	
	public Employee findByEmployeeId(String employee_id);
	
	//public List<Employee> findByEmployeeDesignationAndEmployeeAddress(String employee_designation,String employee_address);
	
	public List<Employee> findByEmployeeDesignationOrEmployeeAddress(String employee_designation,String employee_address);
	
	public List<Employee> findByAgeLessThanEqual(int age);
	
	public List<Employee> findByAgeLessThan(int age);
	
	public List<Employee> findByAgeGreaterThan(int age);
	
	public List<Employee> findByAgeGreaterThanEqual(int age);

	//------------JPQl Queries---------------
	
	@Query("select e from Employee e")
	public List<Employee> findAllEmployee();
	
	@Query("select e FROM Employee e where e.employeeAddress=?1")
	public List<Employee> getByEmployeeAddress(String employee_address);
	
	@Modifying
    @Transactional
	@Query("delete from Employee e where e.employeeId=:id")
	public void deleteByEmployeeId(@Param("id")String employee_id);
	
	
	
	//------------Native Queries-------------
	
	
	@Query(value="select * from employeerecord", nativeQuery=true)
	public List<Employee> getAllEmployee();
	
	@Query(value="select * from employeerecord where employee_name=?1",nativeQuery=true)
	public List<Employee> findByEmployeeName(String employee_name);
	
	
	@Query(value="select * from employeerecord where employee_designation=?1 and employee_address=?2",nativeQuery=true)
	public List<Employee> findByEmployeeDesignationAndEmployeeAddress(String employee_designation,String employee_address);
	
	@Modifying
    @Transactional
	@Query(value="delete from employeerecord where employee_name=:name", nativeQuery=true)
	public void deleteByEmployeeName(@Param("name")String employee_name);
	
	
	@Query(value="insert into employeerecord (employee_name,employee_id,employee_age,employee_designation,employee_phone_no,employee_address)"+
				"(:name,:id,:age,:desg,:phone,:address)", nativeQuery= true)
	public Employee	saveEmployee(@Param("name") String employee_name,@Param("id") String employee_id,@Param("age") String employee_age,
			@Param("desg") String employee_designation,@Param("phone") String employee_phone_no,@Param("address") String employee_address );
}
	