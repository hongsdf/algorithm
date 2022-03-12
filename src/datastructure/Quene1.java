package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.*;
import java.util.Queue;

public class Quene1 {
	public static StringBuilder sb = new StringBuilder();
	public static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue<Integer> q = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
//		int front = -1;
//		int rear = -1;
		while(n > 0) {
			String command = br.readLine();
			if(command.contains("push")) {
			  String s = command.substring(5);
			  int num = Integer.parseInt(s);
			  q.add(num);
			}else if(command.contains("pop")) {
				if(q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(q.poll()).append("\n");
//				else System.out.println(q.poll());
			}else if(command.contains("size")) {
//				System.out.println("사이즈"+q.size());
				sb.append(q.size()).append("\n");
			}else if(command.contains("empty")) {
//				if(q.isEmpty()) System.out.println(1);
				if(q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(0).append("\n") ;
			}else if(command.contains("front")) {
//				if(q.isEmpty()) System.out.println(-1);
				if(q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(q.peek()).append("\n");
			}else { // 끝 원소 rear구현
				dequeu(q);
//				for(int i = 0; i <list.size(); i++) {
//					q.add(list.get(i));
//				}
			}
			n--;
		}
		System.out.println(sb);
		
		
//		q.add(4);
//		q.add(6);
//		q.add(7);
//		q.poll();
//		q.add(3);
//		q.poll();
//		while(!q.isEmpty()) {
//			System.out.println(q.poll());
//		}
	}

	private static void dequeu(Queue<Integer> q) {
		// TODO Auto-generated method stub
		int rear = 0;
		List<Integer> list = new ArrayList<>();
		if(q.isEmpty()) {
//			System.out.println(-1);
			sb.append(-1).append("\n") ;
		}else { //21
			// 1
			// 2
			// 거꾸로 출력하기 위해 ArrayList를 만들 었다. 
			while(!q.isEmpty()) { // q 원소 다 빼내기
				int num = q.poll();
				list.add(num); // list 에 담기
			} // 2 1
			  // 1 2 
			  // 1 2
//			System.out.println(list.get(list.size()-1)); // list의 마지막 원소 출력
			sb.append(list.get(list.size()-1)).append("\n" ) ;
			
			
			for(int i = 0; i < list.size(); i++) { // q가 비어있으니깐 다시 q의 list원소 집어 넣기
				 q.add(list.get(i));
			}
		}
	}
}
