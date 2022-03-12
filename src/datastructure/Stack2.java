package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Integer> st = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String s = "push 1";
//		System.out.println(s.substring(5));
		
		int n = Integer.parseInt(br.readLine());
		while(n > 0) {
			String command = br.readLine();
			if(command.contains("push")) {
				String s1 = command.substring(5);
				int num = Integer.parseInt(s1);
				st.push(num);
				//push 1
			}else if(command.contains("pop")) {
				if(st.isEmpty()) System.out.println(-1);	
				else System.out.println(st.pop());
			}else if(command.contains("size")) {
				System.out.println(st.size());
			}else if(command.contains("empty")) {
				if(st.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}else { //top ÇÔ¼ö
				if(st.isEmpty()) System.out.println(-1);
				else System.out.println(st.peek());
			}
			
			
			n--;
		}
	
		
		
	}
}
