package com.mac.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EmployeeInfo")
public class Employee {

	@Id
	@TableGenerator(name = "empid", table = "emppktb", pkColumnName = "empkey", pkColumnValue = "empvalue", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "empid")
	private int empId;

	@Column
	private String empName;

	@Temporal(TemporalType.DATE)
	private Date dob;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timeIn;

	private boolean permanent;
	private BigDecimal salary;
	private String emailAddress;

	public Employee(String empName) {
		this.empName = empName;
	}

	public Employee() {
	}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(Date timeIn) {
		this.timeIn = timeIn;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
