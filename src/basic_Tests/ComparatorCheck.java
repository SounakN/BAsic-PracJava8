package basic_Tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ComparatorCheck extends Object {
	public String EmpyeeName;
	public int Employeeage;
	public double EmployeeSalary;

	public ComparatorCheck(String empyeeName, int employeeage, double employeeSalary) {
		EmpyeeName = empyeeName;
		Employeeage = employeeage;
		EmployeeSalary = employeeSalary;
	}

	@Override
	public String toString() {
		return EmpyeeName + " , " + Employeeage + " , " + EmployeeSalary;

	}
	public boolean equals(ComparatorCheck obj) {
       return this.EmpyeeName.equals(obj.EmpyeeName);
    }

	public static void main(String args[]) {

		List<ComparatorCheck> x = new ArrayList<>();

		x.add(new ComparatorCheck("Rakesh", 20, 23.0));
		x.add(new ComparatorCheck("Sakesh", 23, 20.0));
		x.add(new ComparatorCheck("Bhakesh", 25, 22.0));
		x.add(new ComparatorCheck("Kumaakesh", 19, 18.0));
		/* x.get(0).EmpyeeName.compareTo(x.get(1).EmpyeeName); */
		/*
		 * BiFunction<ComparatorCheck, ComparatorCheck, Integer> d = new
		 * BiFunction<ComparatorCheck, ComparatorCheck, Integer>() {
		 * 
		 * @Override public Integer apply(ComparatorCheck t, ComparatorCheck u) { return
		 * t.Employeeage > u.Employeeage ? 1 : -1; }
		 * 
		 * };
		 */
		
		/*
		 * BiFunction<ComparatorCheck, ComparatorCheck, Integer> d = (ComparatorCheck t,
		 * ComparatorCheck u) -> ( t.Employeeage>u.Employeeage?1:-1 );
		 */
		
		
		
		 
		
			/*
			 * Comparator<ComparatorCheck> c = (ComparatorCheck o1,ComparatorCheck o2) ->
			 * d.apply(o1, o2);
			 */
		System.out.println(x.get(0).equals(x.get(1)));
		
		  Comparator<ComparatorCheck> c = (ComparatorCheck o1,ComparatorCheck o2) ->
		  (o1.Employeeage>o2.Employeeage? 1:-1);
		  

			/* x.stream().map(s -> s.EmpyeeName).forEach(f -> System.out.println(f)); */
			Collections.sort(x,c);
			


		/*
		 * Collections.sort(x, (ComparatorCheck o1, ComparatorCheck o2) ->
		 * o1.Employeeage > o2.Employeeage ? 1 : -1);
		 */

		x.stream().map(s -> s.EmpyeeName).forEach(f -> System.out.println(f));

	}

}
