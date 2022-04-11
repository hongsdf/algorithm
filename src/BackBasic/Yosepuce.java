package BackBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class Yosepuce {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <=N; i++) {
			q.add(i);
		}
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i <N-1; i++) {
			for(int j = 0; j <M-1; j++) {
				q.add(q.poll());
			}
			list.add(q.poll());
		}
		
		System.out.print("<");
		for(int i = 0; i <list.size()-1; i++) {
			sb.append(list.get(i)+",");
		}
		sb.append(list.get(list.size()-1));
		System.out.print(sb+">");
		
		
	}
	
	
}
