package Strings;

import java.util.Scanner;

public class SubString2 {

	public static String getSmallestAndLargest(String s, int k) {
		String substring = s.substring(0,k);
		String smallest = substring;
		String largest = substring;
		for(int i =0;i<= s.length()-k; i++) {
			String res = s.substring(i, k+i); // 0 1 2  1 2 3
			
			
			if(smallest.compareTo(res) > 0) {
				smallest = res;
			}
			
			if(largest.compareTo(res) < 0) {
				largest = res;
			}
			
		}
		
		
		
		return smallest + "\n" + largest;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int k = scan.nextInt();
		scan.close();

		System.out.println(getSmallestAndLargest(s, k));
	}

}
