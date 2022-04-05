package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Germany_l {
	
	public static List<Integer> list;
	public static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			N = sc.nextInt();
			if(N == 0) break;
			
			list = new ArrayList<Integer>();
			for(int i=0;i<N; i++) {
				list.add(sc.nextInt());
			}
			boolean visited[] = new boolean[N];
			solve2(list,visited,0,N,6);
			
			System.out.println();
		}
		
	}

	private static void solve2(List<Integer> list, boolean[] visited, int pos,int n, int cnt) {
		if(cnt == 0) {
			print(list,visited,n);
			return;
		}
		
		//핵심은 뿌리 가 있다.
		// 재귀함수가 외부에서 실행되어 들어온다 그게 가장 큰 조상
		// 재귀내부함수에 반복문이 있으면 각각이 출발점 재귀 출발점이다
		// ex) for(int i=0;i<4; i++) 재귀함수는 조상의 자식 4개(출발)
		// 조상 -> 1 --> 2  ---> 3  ----> 4  1234  123 234 124 134
		//				   ---> 4
		//		    
		//          --> 3  ---> 4

		//          --> 4
		
		//     -> 2   --> 3  ---> 4
		//		      --> 4
		
		
		//	   -> 3 --> 4
		
		
		//     -> 4
		//
		for(int i = pos; i< n; i++) {
			visited[i] = true;
			solve2(list,visited,i+1,n,cnt-1);
			visited[i] = false;
		}
		
		
		
	}

	private static void print(List<Integer> list, boolean[] visited, int n) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i< n; i++) {
			if(visited[i]) {
				sb.append(list.get(i)).append(" ");
			}
		}
		sb.append("\n");
		
		System.out.print(sb.toString());
		
	}

//	private static void solve(List<Integer> list, int pos, StringBuilder sb) {
//		if(pos >= list.size()) { // 전체 원소를 포함여부 상관없이 다 확인 해야함
//			if(sb.length() == 6) System.out.println(sb);
//			
//			return; // 모든 인덱스를 다 확인 했을때 종료
//		}
//		
//		
//		// 조합 함수를 구현(해당 자료, 인덱스 위치 전진, 이어 붙힐 메모리공간)
//		solve(list,pos+1,sb.append(list.get(pos)));
//		sb.setLength(sb.length()-1);
//		solve(list,pos+1,sb);
//		
//	}
}
