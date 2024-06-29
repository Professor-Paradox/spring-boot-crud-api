package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    // working with jpa have java working  column names link local ref to db column name
    @Column(name = "roll_no")
    private String rollNo;
    
    @Column(name="branch")
    private String branch;
    
    @Column(name = "full_name")
    private String fullName;
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name="email")
	private String email;
    
	@Column(name = "phone_number")
    private String phoneNumber;

	public Student(String rollNo, String branch, String fullName, String email, String phoneNumber) {
		super();
		this.rollNo = rollNo;
		this.branch = branch;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", rollNo=" + rollNo + ", branch=" + branch + ", fullName=" + fullName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + "]";
	}

	public Student() {
		super();
	}

	
	
	
	
}