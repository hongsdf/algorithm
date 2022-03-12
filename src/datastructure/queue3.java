package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class queue3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		LinkedList<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(n --> 0) {
			st = new StringTokenizer(br.readLine()," ");
			switch(st.nextToken()){
			
			case "push":
				q.add(Integer.parseInt(st.nextToken()));
				break;
			case "pop" :
				if(q.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					
					sb.append(q.poll()).append("\n");
				}
				break;
			case "size" :	
				sb.append(q.size()).append("\n"); break;
			case "empty" :
				if(q.isEmpty()) {
					sb.append(1).append("\n");
				}
				else {
					sb.append(0).append("\n") ;
				}
				break;
			case "front":
				if(q.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(q.peekFirst()).append("\n");
				}
				break;
			case "back":
				if(q.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(q.peekLast()).append( "\n");
				}
					break;
			}
//			System.out.println(sb);
		}	
//			
//			String command = br.readLine();
//			if(command.contains("push")) {
//			  String s = command.substring(5);
//			  int num = Integer.parseInt(s);
//			  q.add(num);
//			  break;
//			}else if(command.contains("pop")) {
//				
//				if(q.isEmpty()) sb.append(-1).append("\n");
//				else sb.append(q.poll()).append("\n");
//				break;
////				else System.out.println(q.poll());
//			}else if(command.contains("size")) {
////				System.out.println("사이즈"+q.size());
//				sb.append(q.size()).append("\n");
//				break;
//			}else if(command.contains("empty")) {
////				if(q.isEmpty()) System.out.println(1);
//				if(q.isEmpty()) sb.append(-1).append("\n");
//				else sb.append(0).append("\n") ;
//			}else if(command.contains("front")) {
////				if(q.isEmpty()) System.out.println(-1);
//			}else { // 끝 원소 rear구현
////				
//			}
//			n--;
//		}
		System.out.println(sb);
	}
}
