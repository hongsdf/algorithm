package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class N과M_12_15666 {
	public static int N,M;
	public static int arr[];
	public static StringBuilder sb = new StringBuilder();
	public static Set<List<String>> set = new LinkedHashSet<List<String>>(); // 입력순서대로 처리 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		arr = new int[N];
		String str1[] = br.readLine().split(" ");
		for(int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(str1[i]);
		}
		Arrays.sort(arr);
		// 구현
		List<Integer> list = new ArrayList<Integer>();
		// 시작점
		int start = 0;
		solve(0,start,list);
		
		Iterator<List<String>> it = set.iterator();
		while(it.hasNext()) {
			List<String> answer = it.next();
			for(String a :answer) {
				sb.append(a+" ");				
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
		
	}
	private static void solve(int depth,int start, List<Integer> list) {
		// 탈출 조건 : 뿌리 깊이 까지 탐색을 하면 종료
		if(depth == M) {
			// temp안에 있는 원소 출력
			
			// set안에 담기
			List<String> answer = new ArrayList<>();
			for(int i = 0; i<list.size(); i++) {
				answer.add(String.valueOf(list.get(i)));
			}
			set.add(answer);
			return;
		}
		// 구현
		for(int i = start; i <N; i++) {
			list.add(arr[i]);
			solve(depth+1,i,list);
			list.remove(list.size()-1);
		}
		
	}
}
