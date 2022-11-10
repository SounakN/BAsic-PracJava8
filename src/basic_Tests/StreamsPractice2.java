package basic_Tests;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsPractice2 {
	public String EmpyeeName ;
	public int Employeeage;
	private double EmployeeSalary;
	private String typeofjob;
	
	public StreamsPractice2(String empname, int age, double sal, String toj)
	{
		this.EmpyeeName=empname;
		this.Employeeage=age;
		this.EmployeeSalary=sal;
		this.typeofjob=toj;
	}
	
	
	  @Override 
	  public String toString() 
	  { 
		  return  this.EmpyeeName+" , "+this.typeofjob; 
	  }

	 
	
	public static void main(String[] args) {
		
		List<StreamsPractice2> loS = new ArrayList<StreamsPractice2>();
		loS.add(new StreamsPractice2("Radhe1",20,23000,"developer"));
		loS.add(new StreamsPractice2("Radhe2",22,22000,"Tester"));
		loS.add(new StreamsPractice2("Radhe3",19,23000,"developer"));
		loS.add(new StreamsPractice2("Radhe4",18,23000,"Tester"));
		loS.add(new StreamsPractice2("Radhe5",30,24000,"developer"));
		loS.add(new StreamsPractice2("Radhe6",21,23000,"developer"));
		loS.add(new StreamsPractice2("Radhe7",21,25000,"Tester"));


		

		System.out.println(loS.stream().filter(x->x.typeofjob.equals("developer")).mapToDouble(s->s.EmployeeSalary).sum());
		System.out.println(loS.stream().filter(x->x.typeofjob.equals("developer")).mapToDouble(s->s.EmployeeSalary).average());
		System.out.println(loS.stream().filter(x->x.typeofjob.equals("developer")).mapToDouble(s->s.EmployeeSalary).count());

			
	}

}
