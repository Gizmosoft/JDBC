package com.accenture.lkm.empapp.client;

import java.util.ArrayList;
import java.util.Iterator;

import com.accenture.lkm.empapp.businessbean.Employee;
import com.accenture.lkm.empapp.service.EmployeeService;

public class EmployeeMain {

	public static void main(String[] args) {
		EmployeeService service = new EmployeeService();
		boolean result;
		/*
		 * code to insert employee details Employee employee = new Employee(null,
		 * "Melinda", new Date(), "Sr.Analyst", 9000); result =
		 * service.addEmployee(employee); if (result) {
		 * System.out.println("Added successfully"); }
		 */

		/* code to update */
		Employee emp = new Employee();
		emp.setEmployeeId(1002);
		emp.setRole("Team lead");
		emp.setSalary(15000);
		result = service.updateEmployee(emp);
		if (result) {
			System.out.println("Updated successfully");
		}
		/* code to select all employees */
		ArrayList<Employee> list = service.getAllEmployees();
		Iterator<Employee> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		/* code to delete employee */
		int delEmplID = 1003;
		emp.setEmployeeId(delEmplID);
		result = service.deleteEmployee(delEmplID);
		if (result) {
			System.out.println("Deleted successfully");
		}
		
		/* code to show emp based on id */
		int empById = 1002;
		Employee elist = service.getEmployeeById(empById);
		System.out.println(elist.toString());
	}

}
