package com.accenture.lkm.empapp.businessbean;

import java.util.Date;

// Class would be named after table
//Fields would be named after columns
public class Employee {
	private Integer employeeId;
	private String employeeName;
	private Date insertTime;
	private String role;
	private Integer salary;

	public Employee() {

	}

	/**
	 * @param employeeId
	 * @param employeeName
	 * @param insertTime
	 * @param role
	 * @param salary
	 */
	public Employee(Integer employeeId, String employeeName, Date insertTime, String role, Integer salary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.insertTime = insertTime;
		this.role = role;
		this.salary = salary;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", insertTime=" + insertTime
				+ ", role=" + role + ", salary=" + salary + "]";
	}

}
