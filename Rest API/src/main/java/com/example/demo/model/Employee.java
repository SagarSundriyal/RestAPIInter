package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "column")
public class Employee {

	private String Name;
	private Long MobileNo;
	private String Email_id;
	private Date dateOfBirth;
	
	public Employee() {
		super();
	}
	
	public Employee(String name, Long mobileNo, String email_id, Date dateOfBirth) {
		super();
		Name = name;
		MobileNo = mobileNo;
		Email_id = email_id;
		this.dateOfBirth = dateOfBirth;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	@Column(name = "mobileNo" , nullable = false)
	public Long getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		MobileNo = mobileNo;
	}
	
	@Column(name = "emailId" , nullable = false)
	public String getEmail_id() {
		return Email_id;
	}
	public void setEmail_id(String email_id) {
		Email_id = email_id;
	}
	
	@Column(name = "D.O.B" , nullable = false)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Employee [Name=" + Name + ", MobileNo=" + MobileNo + ", Email_id=" + Email_id + ", dateOfBirth="
				+ dateOfBirth + "]";
	}
	
}
