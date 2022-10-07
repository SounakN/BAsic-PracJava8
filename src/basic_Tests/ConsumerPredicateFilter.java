package basic_Tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;  

public class ConsumerPredicateFilter {
	
	
	private String EmpyeeName ;
	private int Employeeage;
	private double EmployeeSalary;
	
	public ConsumerPredicateFilter(String empyeeName, int employeeage, double employeeSalary) {
		EmpyeeName = empyeeName;
		Employeeage = employeeage;
		EmployeeSalary = employeeSalary;
	}
	
	public static void main (String args[])
	{
		List<Integer> x = new ArrayList<>();
		x.add(2);
		x.add(3);
		x.add(4);
		x.add(5);
		x.add(6);
		
		List<Integer> z = new ArrayList<>();
		z.add(2);
		z.add(3);
	

		//Consumer 
		/*
		 * Consumer<Integer> cons = x1-> System.out.print(x1);
		 * 
		 * x.stream().forEach(cons); x.stream().forEach(x1-> System.out.print(x1));
		 */
		
		Predicate<Integer> pred = x1-> x1%2==0;
		/*
		 * System.out.println(x.stream().filter(pred).collect(Collectors.toSet()));
		 * System.out.println(x.stream().filter(x1->
		 * x1%2==0).collect(Collectors.toList()));
		 * System.out.println(x.stream().filter(x1->
		 * x1%2==0).collect(Collectors.toMap(x1-> x1,x1->x1%3)));
		 * System.out.println(x.stream().filter(x1-> x1%2==0));
		 */
		
		
		//Map
		Function<Integer,Integer> timesThree = new Function<>() {

			@Override
			public Integer apply(Integer t) {
				return t*3;
			}
						
		};
				
		Function<Integer, Function<Integer,Integer>> Func = new Function<>() {

			@Override
			public Function<Integer, Integer> apply(Integer t) {
				//return x -> x*t;
				Function<Integer,Integer> cc =  new Function<Integer, Integer>(){
					@Override
					public Integer apply(Integer t1) {
						return t1*t;
					}
				};
				return cc;
			}

		};
		
		// creating a custom action

		Function<Integer,Integer> timesfour = Func.apply(4);
				
		/*
		 * System.out.println(x.stream().filter(pred).map(x1 ->
		 * x1*2).collect(Collectors.toList()));
		 * System.out.println(x.stream().filter(pred).map(timesThree).collect(Collectors
		 * .toList()));
		 * System.out.println(x.stream().filter(pred).map(timesfour).collect(Collectors.
		 * toList()));
		 */
		//reduce
	
	}

}
