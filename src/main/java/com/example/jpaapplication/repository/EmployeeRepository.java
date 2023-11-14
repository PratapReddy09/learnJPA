package com.example.jpaapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.jpaapplication.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
/*	//This concept is used by findBy methods, if you are using findby methods then only
	//we have to write the below code otherwise no need, we nned to take care by method names
	//select * from employee where empSalary> :salary
	public List<Employee> findByempSalaryGreaterThan(Double salary);
	//select * from employee where empSalary<= :salary
	public List<Employee> findByempSalaryLessThanEquals(Double salary);
	//select * from employee where empName= name
	public List<Employee> findByempName(String name);
	//end of findBy methods
	//----------------------------------------------------------------------------
*/
	/**
	//this concept is for  custom query
	//this is sql query
	 
	@Query(value = "select * from emp_tb1", nativeQuery=true)
	public List<Employee> getAllEmployee();
	
	//this is HQL query, i preferd this query
	 
	@Query(value = "from Employee")
	public List<Employee> getAllEmployee();
	
	
	*/

}
