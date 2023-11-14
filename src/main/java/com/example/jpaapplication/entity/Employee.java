package com.example.jpaapplication.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="emp_tb1")
public class Employee {
	
	@Id
	private Integer empId;
	private String empName;
	private Double empSalary;
	private String empGender;
	private String dept;
	
	
	//below two varibles belongs to, time stamping in JPA topic
	
	//this annotation is useful to genaerate the insertable and updated times
	@CreationTimestamp
	
	//below annotation is used to create column name and it's declared update is false that means 
	//only insertion is possible, if you insert the new record it will set the insertion time.
	
	@Column(name="date_created", updatable=false)
	private LocalDate dateCreated;
	
	
	@UpdateTimestamp
	
	//below annotation is used to create column name and it's declared insert is false that means 
	//only update is possible, if you update the existing record it will set the updated time.
	@Column(name="last_updated", insertable=false)
	private LocalDate lastUpdated;
	
	

}
