package com.accenture.lkm.empapp.client;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import com.accenture.lkm.empapp.businessbean.Employee;
import com.accenture.lkm.empapp.service.EmployeeService;

public class EmployeeMain {

	public static void main(String[] args) {
		EmployeeService service = new EmployeeService();
		boolean result;
		long dateToday = 1615206523459L;
		
		// code to insert employee details 
		 Employee employee = new Employee(null, "Melinda", new Date(dateToday), "Sr.Analyst", 9000); 
		 result = service.addEmployee(employee); 
		 if (result) {
			 System.out.println("Added successfully"); 
		 }
		 

//		/* code to update */
//		Employee emp = new Employee();
//		emp.setEmployeeId(1002);
//		emp.setRole("Team lead");
//		emp.setSalary(15000);
//		result = service.updateEmployee(emp);
//		if (result) {
//			System.out.println("Updated successfully");
//		}
//		/* code to select all employees */
//		ArrayList<Employee> list = service.getAllEmployees();
//		Iterator<Employee> itr = list.iterator();
//		while (itr.hasNext()) {
//			System.out.println(itr.next());
//		}
	}

}
