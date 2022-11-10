package basic_Tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class stringChecks {
	
	static String x = "II SO  Tel me that";

	static String[] xx = x.split(" ");
	public static void main(String args[]) {	
		
		  String s = ""; 
		  char[] ff = x.toCharArray();
		  Map<Object,Integer> f = new HashMap<Object, Integer>();
		  List<char[]> asList = Arrays.asList(ff); 
		  
		  System.out.print(asList.get(0));
		  
		List<String> cc = x.chars().mapToObj(d->Character.toString(d)).collect(Collectors.toList());
		
		List<Character> listC = new ArrayList<Character>();
	    for (char c : ff) {
	        listC.add(c);
	    }
		  x.chars().forEach(d->{
			  if(f.containsKey(Character.toString(d))) {
				  f.put(Character.toString(d),f.get(Character.toString(d))+1);
			  }else {
				  f.put(Character.toString(d), 1);
			  }
		  });
		  
		  
		  System.out.print(f);
			/*
			 * ArrayList<String> dd = new ArrayList<String>(Arrays.asList(xx));
			 * dd.stream().forEach(x->{ char[] xy = x.toCharArray(); for(int
			 * o=0;o<xy.length;o++) { if(o==0) {
			 * System.out.print(Character.toUpperCase(xy[o])); }else {
			 * System.out.print(xy[o]); }
			 * 
			 * } System.out.print(" "); });
			 */

	}


}
