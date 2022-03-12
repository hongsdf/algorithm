package Sort;

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

class R {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
    // Write your code here
//    	5
//    	2 4 6 8 3
    	for(int i =n-1; i >=1; i--) {// n-1
    		// 2  3자리 왼쪽 두수 비교
    		int j = i-1;
    		while(arr.get(j) > arr.get(j+1)) {
//    		        3   4  2 3  1 2  0 1       
    			int tmp = arr.get(j+1);
    			arr.set(j+1, arr.get(j));
    			arr.set(j, tmp);
    			j++;
    			for(int v = 0; v<arr.size(); v++) {
    				if(arr.get(v) == tmp)
    					System.out.print(arr.get(v+1));
    				else System.out.print(arr.get(v));
    			}
    			System.out.println();
    			if(j > n-2  ) {
        			break;
        		}
    		}
    		
    	}
    					
    				
    	for(int i =0; i <arr.size(); i++) {
    		System.out.print(arr.get(i));
    	}
    }

}

public class insertSortTEST2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        R.insertionSort1(n, arr);

        bufferedReader.close();
    }
}

