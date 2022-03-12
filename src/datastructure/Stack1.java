package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Stack1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Integer> st = new Stack<Integer>();
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		while(n > 0) {
//			String command = br.readLine();
//			if(command.equals("push")) {
//				
//			}
//			
//			n--;
//		}
		
		st.push(7);
		st.push(6);
		st.push(4) ;
		st.pop(); // 상단 제거
		st.push(5);
		st.pop();
		
		while(!st.empty()) {
			System.out.println(st.pop());
			
		}
		
		
		
	}
}
