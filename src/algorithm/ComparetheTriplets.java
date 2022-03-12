package algorithm;

import java.util.*;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;




public class ComparetheTriplets{	
	public static void main(String[] args)  {
	       Scanner sc =  new Scanner(System.in);
	       
	       
	       
	       
	       List<Integer> a = Arrays.asList(17, 28, 30);
	       List<Integer> c = Arrays.asList(99, 16, 8);
//	       for(int i =0; i<a.size();i++) {
//	    	   System.out.print(a.get(i)+" ");
//	       }
	       
	       
	       
	       List<Integer> b = new ArrayList<Integer>(2);
	       b.add(0,0);
	       b.add(1,0);
	       for(int ab: b) {
	    	   System.out.print("¿©±â"+ab + " "+"\n");
	       }
	       
	       for(int i =0; i<a.size(); i++) {
	    	   if(a.get(i) > c.get(i)) {
	    		  int num = b.get(0);
//	    		  num++;
	    		  b.set(0,num+=1);
	    		   
	    	   }else if(a.get(i) <c.get(i)) {
	    		   int num = b.get(1);
//	    		   num++;
	    		   b.set(1,num+=1);
	    	   }else continue;
	       }
	       for(int ab: b) {
	    	   System.out.print(ab + " ");
	       }
	       
	       
	       
	       
	       while(sc.hasNext()) {
	    	  int num = sc.nextInt();
	    	  System.out.println(num);
	    	  a.add(num);
	       }
	       
	       while(sc.hasNext()) {
		    	  int num = sc.nextInt();
		    	  System.out.println(num);
		    	 b.add(num);
		    }
	       
	}
}