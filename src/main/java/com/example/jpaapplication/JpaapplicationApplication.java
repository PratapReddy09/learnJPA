package com.example.jpaapplication;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import com.example.jpaapplication.entity.Employee;
import com.example.jpaapplication.repository.EmployeeRepository;

@SpringBootApplication
public class JpaapplicationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(JpaapplicationApplication.class, args);
	
				EmployeeRepository repository=context.getBean(EmployeeRepository.class);
				//get all employee data
				List<Employee> list=repository.findAll();
				list.forEach(System.out::println);
				System.out.println("Now printing sorting by name");
				System.out.println("-----------------------------");
				//logic for getting employee data by names ascending order
				Sort ascending=Sort.by("empName").ascending();
				List<Employee> list1=repository.findAll(ascending);
				list1.forEach(System.out::println);
				System.out.println("Now printing sorting by name ");
				System.out.println("-----------------------------");
				//logic for getting employee data by names descending order 
				Sort descending=Sort.by("empName", "empSalary").descending();
				List<Employee> list3=repository.findAll(descending);
				list3.forEach(System.out::println);
				
				System.out.println("Now printing by gender (Male) ");
				System.out.println("-----------------------------");
				//this is for filtering data by gender
				//by using this we can filter any of it, for example, if you search mobile in flipcart
				//it will show more than 1000. but, if you filter iphone it will show only 100 like that.
				Employee emp=new Employee();
				emp.setEmpGender("male");
				//if you use this one this is filtering data by job role,  
				//emp.setEmpGender("manager");
				Example<Employee> emxs=Example.of(emp);
				List<Employee> emps=repository.findAll(emxs);
				emps.forEach(System.out::println);
				
				
				System.out.println("this is for findBy methods ");
				System.out.println("-----------------------------");
				//this code is belongs to findBy methods, in the employee repository i wrote the
				
				//code, that code is belongs to below 3lines of the code, But not belongs to above code
	/*			
				List<Employee> list4=repository.findByempSalaryGreaterThan(3500.00);
				list4.forEach(System.out::println);
				
				List<Employee> list6=repository.findByempSalaryLessThanEquals(3500.00);
				list4.forEach(System.out::println);
				
				List<Employee> list5=repository.findByempName("siva");
				list5.forEach(System.out::println);
		*/
				//end this concept
				/*
				
				System.out.println("this is concept for custom queries ");
				System.out.println("-----------------------------");
				List<Employee> list7=repository.getAllEmployee();
				list7.forEach(System.out::println);
				*/
				
				//below object is used for the time stamping in JPA topic
				
				Employee emp1=new Employee();
				emp1.setEmpId(101);
				emp1.setEmpName("ramu");
				emp1.setEmpGender("male");
				emp1.setEmpSalary(8000.00);
				emp1.setDept("developer");
				
				repository.save(emp1);
				
				
				
				
				
				
				
	}

}
