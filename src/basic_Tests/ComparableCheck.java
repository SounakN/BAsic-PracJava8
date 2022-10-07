package basic_Tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableCheck implements Comparable<ComparableCheck> {

	private String EmpyeeName;
	private int Employeeage;
	private double EmployeeSalary;

	/*
	 * public String getEmpyeeName() { return EmpyeeName; }
	 * 
	 * 
	 * 
	 * public void setEmpyeeName(String empyeeName) { EmpyeeName = empyeeName; }
	 * 
	 * 
	 * 
	 * public int getEmployeeage() { return Employeeage; }
	 * 
	 * 
	 * 
	 * public void setEmployeeage(int employeeage) { Employeeage = employeeage; }
	 * 
	 * 
	 * 
	 * public double getEmployeeSalary() { return EmployeeSalary; }
	 * 
	 * 
	 * 
	 * public void setEmployeeSalary(double employeeSalary) { EmployeeSalary =
	 * employeeSalary; }
	 */

	public ComparableCheck(String empyeeName, int employeeage, double employeeSalary) {
		EmpyeeName = empyeeName;
		Employeeage = employeeage;
		EmployeeSalary = employeeSalary;
	}

	@Override
	public int compareTo(ComparableCheck o) {
		if (this.Employeeage > o.Employeeage) {
			return 1;
		} else {
			return -1;
		}
	}

	public static void main(String args[]) {

		List<ComparableCheck> x = new ArrayList<>();

		x.add(new ComparableCheck("Rakesh", 20, 23.0));
		x.add(new ComparableCheck("Sakesh", 23, 20.0));
		x.add(new ComparableCheck("Bhakesh", 25, 22.0));
		x.add(new ComparableCheck("Kumaakesh", 19, 18.0));
		
		  System.out.println(x.get(1).compareTo(x.get(0))); 
		  Collections.sort(x ,
		  Collections.reverseOrder() );
		 

		x.stream().map(s -> s.EmpyeeName).forEach(c -> System.out.println(c));
	}

}
