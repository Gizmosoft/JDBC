package com.accenture.lkm.empapp.service;

import java.util.ArrayList;

import com.accenture.lkm.empapp.businessbean.Employee;
import com.accenture.lkm.empapp.dao.EmployeeDAO;

// add business logic
public class EmployeeService {

	EmployeeDAO employeeDao = new EmployeeDAO();

	public ArrayList<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	public boolean addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	public boolean updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}

	public boolean deleteEmployee(int employeeId) {
		return employeeDao.deleteEmployee(employeeId);
	}

	public Employee getEmployeeById(int employeeId) {
		return employeeDao.getEmployeeById(employeeId);
	}

}
