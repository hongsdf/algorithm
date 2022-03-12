package datastructure;
import java.util.Scanner;
import java.util.*;
public class BitSet1{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BitSet bs1 = new BitSet(n);
		BitSet bs2 = new BitSet(n);
		
		int m = sc.nextInt();
		for(int i =0; i<m; i++) {
			String command = sc.next();
			int one = sc.nextInt();
			int two = sc.nextInt();
			switch (command) {
				case "AND":
					if(one == 1) {
						bs1.and(bs2);
						
					}else {
						bs2.and(bs1);
					}
					
					break;
//				 0 0 0 0 0 
				case "OR":
					if(one==1) {
						bs1.or(bs2);
					}else {
						bs2.or(bs1);
					}
					break;
				
				case "SET":
					if(one == 1) {
						bs1.set(two);
					}
					else{
						bs2.set(two);
					}
					break;
				
				case "FLIP":
					if(one ==1) {
						bs1.flip(two);
					}
					else {
						bs2.flip(two);
					}
					break;
				case "XOR":
					if(one ==1) {
						bs1.xor(bs2);
					}
					else {
						bs2.xor(bs1);
					}
					break;
			
				}
			System.out.println();
			System.out.print(bs1.cardinality());
			System.out.print(bs2.cardinality());
			
		}
		sc.close();
		
	}
	
	
}
