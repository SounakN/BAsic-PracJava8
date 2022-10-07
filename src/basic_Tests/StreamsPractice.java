package basic_Tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsPractice {
	public String EmpyeeName ;
	public int Employeeage;
	private double EmployeeSalary;
	private String typeofjob;
	
	public StreamsPractice(String empname, int age, double sal, String toj)
	{
		this.EmpyeeName=empname;
		this.Employeeage=age;
		this.EmployeeSalary=sal;
		this.typeofjob=toj;
	}
	
	
	
	  @Override public String toString() { return
	  this.EmpyeeName+" , "+this.typeofjob; }
	 
	
	
	public static void main(String[] args) {
		

		
		List<StreamsPractice> loS = new ArrayList<StreamsPractice>();
		loS.add(new StreamsPractice("Radhe1",20,23000,"developer"));
		loS.add(new StreamsPractice("Radhe2",22,22000,"Tester"));
		loS.add(new StreamsPractice("Radhe3",19,23000,"developer"));
		loS.add(new StreamsPractice("Radhe4",18,23000,"Tester"));
		loS.add(new StreamsPractice("Radhe5",30,24000,"developer"));
		loS.add(new StreamsPractice("Radhe6",21,23000,"developer"));
		loS.add(new StreamsPractice("Radhe7",21,25000,"Tester"));

		//No of testers
		Long countoftester = loS.stream().filter(x -> x.typeofjob =="Tester").collect(Collectors.counting());
		System.out.println("Total Count of Tester :: "+countoftester);
		//total Salary of all developers
		System.out.println(loS.stream().filter(x -> x.typeofjob =="developer").map(s->s.EmployeeSalary).reduce(0.0,(x,acc)->x+acc));
		/*
		 * Predicate<StreamsPractice> dd = new Predicate<>() {
		 * 
		 * @Override public boolean test(StreamsPractice t) { return
		 * t.typeofjob.equals("tester"); }
		 * 
		 * };
		 */
		//average salary of tester
		Long averageTesterSalary =(long) (loS.stream().filter(x -> x.typeofjob =="Tester").map(s->s.EmployeeSalary).reduce(0.0,(x,acc)->x+acc)/countoftester);
		System.out.println("Average Salary of Tester :: "+averageTesterSalary);
		//Getting Total Salary of Developer and tester
		
		//Way 1
				Function<String, Predicate<StreamsPractice>> trying = new Function<>() {

					@Override
					public Predicate<StreamsPractice> apply(String t) {
						return x-> x.typeofjob.equals(t);
					}
					
				};
				
				System.out.println(loS.stream().filter(trying.apply("developer")).map(s->s.EmployeeSalary).reduce(0.0,(x,acc)->x+acc));
				System.out.println(loS.stream().filter(trying.apply("Tester")).map(s->s.EmployeeSalary).reduce(0.0,(x,acc)->x+acc));
				//Way 2
				Function<String, Predicate<StreamsPractice>> trying2 = t-> x-> x.typeofjob.equals(t);
				System.out.println(loS.stream().filter(trying2.apply("developer")).map(s->s.EmployeeSalary).reduce(0.0,(x,acc)->x+acc));
				System.out.println(loS.stream().filter(trying2.apply("Tester")).map(s->s.EmployeeSalary).reduce(0.0,(x,acc)->x+acc));
				
				String xx = "DDD";
				
		
		//Group By job type and get the names of the employees
		System.out.println(loS.stream().collect(Collectors.groupingBy(s->s.typeofjob)));
		
		//Partition by Salary level
		System.out.println(loS.stream().collect(Collectors.partitioningBy(s->s.EmployeeSalary>23000)));
		
		//Key pair value of name to their salary
		System.out.println(loS.stream().collect(Collectors.toMap(s->s.EmpyeeName, s->s.EmployeeSalary)));

		
		//Types of job and names of Employee
		System.out.println(loS.stream().collect(Collectors.groupingBy(s->s.typeofjob)).
				entrySet().stream().collect(Collectors.toMap(s->s.getKey(), s->s.getValue().stream().map(s1->s1.EmpyeeName).collect(Collectors.toList()))));
		
		//Types of job and Total salary
		System.out.println(loS.stream().collect(Collectors.groupingBy(s->s.typeofjob)).
				entrySet().stream().collect(Collectors.toMap(s->s.getKey(), s->s.getValue().stream().map(s1->s1.EmployeeSalary).reduce(0.0,(acc,x)->acc+x))));
		
		Function<String, String> SS_Lower = s->new StringBuilder(s).replace(0, 1, s.substring(0, 1).toLowerCase()).toString();
		Function<String, String> SS_reverse = s->new StringBuilder(s).reverse().toString();
		Function<String, String> SS_Then = SS_Lower.andThen(SS_reverse);
		Function<String, String> SS_Compose = SS_Lower.compose(SS_reverse);
		loS.stream().filter(trying2.apply("developer")).map(x->SS_Compose.apply(x.EmpyeeName)).forEach(x->System.out.println(x));
		

		System.out.println(loS.stream().filter(trying.apply("developer")).mapToDouble(s->s.EmployeeSalary).sum());
	}

}
