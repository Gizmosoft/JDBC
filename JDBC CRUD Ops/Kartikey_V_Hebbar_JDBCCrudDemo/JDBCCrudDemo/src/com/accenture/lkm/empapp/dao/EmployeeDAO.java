package com.accenture.lkm.empapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.accenture.lkm.empapp.businessbean.Employee;
import com.accenture.lkm.empapp.utility.DBUtility;

public class EmployeeDAO {

	public ArrayList<Employee> getAllEmployees() {
		ResultSet resSet = null;
		ArrayList<Employee> empList = new ArrayList<Employee>();
		try (Connection con = DBUtility.getDBConnection()) {
			if (con != null) {
				String select = "select * from employee";
				Statement stmt = con.createStatement();
				resSet = stmt.executeQuery(select);
				while (resSet.next()) {
					Employee emp = new Employee();
					emp.setEmployeeId(resSet.getInt(1));
					emp.setEmployeeName(resSet.getString(2));
					emp.setInsertTime(resSet.getDate(3));
					emp.setRole(resSet.getString(4));
					emp.setSalary(resSet.getInt(5));
					empList.add(emp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;

	}

	public boolean addEmployee(Employee employee) {
		PreparedStatement preStmt = null;
		boolean isInserted = false;
		try (Connection con = DBUtility.getDBConnection()) {
			String insert = "insert into employee(employeename, role, inserttime, salary)" + " VALUES(?,?,?,?)";
			preStmt = con.prepareStatement(insert);
			java.sql.Date time = new java.sql.Date(employee.getInsertTime().getTime());
			preStmt.setString(1, employee.getEmployeeName());
			preStmt.setString(2, employee.getRole());
			preStmt.setDate(3, time);
			preStmt.setInt(4, employee.getSalary());
			int result = preStmt.executeUpdate();
			if (result > 0) {
				isInserted = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isInserted;

	}

	public boolean updateEmployee(Employee employee) {
		PreparedStatement preStmt = null;
		boolean isUpdated = false;
		try (Connection con = DBUtility.getDBConnection()) {
			String update = "update employee set role=?, salary=? where employeeId=? ";
			preStmt = con.prepareStatement(update);
			preStmt.setString(1, employee.getRole());
			preStmt.setInt(2, employee.getSalary());
			preStmt.setInt(3, employee.getEmployeeId());
			int rows = preStmt.executeUpdate();
			if (rows > 0) {
				isUpdated = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
	}

	// delete from employee where employeeid=?
	// Add code to delete employee details of given employee id
	public boolean deleteEmployee(int employeeId) {
		PreparedStatement preStmt = null;
		boolean isDeleted = false;
		try (Connection con = DBUtility.getDBConnection()) {
			String delete = "delete from employee where employeeId=? ";
			preStmt = con.prepareStatement(delete);
			int rows = preStmt.executeUpdate();
			if (rows > 0) {
				isDeleted = true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	// select * from employee where employeeid=?
	// Add code to fetch employee details for given employee id
	public Employee getEmployeeById(int employeeId) {
		Employee emp = null;
		
		ResultSet resSet = null;
		try (Connection con = DBUtility.getDBConnection()) {
			if (con != null) {
				String show = "select * from employee where employeeId=" + employeeId;
				Statement stmt = con.createStatement();
				resSet = stmt.executeQuery(show);
				while (resSet.next()) {
					emp = new Employee();
					emp.setEmployeeId(resSet.getInt(1));
					emp.setEmployeeName(resSet.getString(2));
					emp.setInsertTime(resSet.getDate(3));
					emp.setRole(resSet.getString(4));
					emp.setSalary(resSet.getInt(5));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

}
