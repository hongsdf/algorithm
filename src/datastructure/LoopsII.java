package datastructure;

import java.util.*;
import java.io.*;

public class LoopsII {
public static void main(String []argh){
		 Scanner in = new Scanner(System.in);
		 int t = in.nextInt();
		 for(int i=0;i<t;i++){
			 int a = in.nextInt(); // 첫째항
			 int b = in.nextInt(); // 공비
			 int n = in.nextInt(); // 항의 갯수
			 int num = 0;
			 int j =1;
			 while(n >0) {
				 num +=  j*b; 
				 System.out.println(num+a);
				 j *= 2;
				 n--;
				 
			 }

			
		 }
		 in.close();
	 }
}		            
		            
	