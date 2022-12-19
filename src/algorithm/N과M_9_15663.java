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
/*
중복되는 수열을 여러 번 출력하면 안되며 순서가 있다. 순열 */

 
public class N과M_9_15663 {
	public static boolean visit[]; // 노드 방문 체크
	public static int arr[];
	public static Set<List<String>> set = new LinkedHashSet<>(); // 입력순서대로 저장
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		arr = new int[N];
		visit = new boolean[N];
		String str1[] = br.readLine().split(" ");
		for(int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(str1[i]);
		}
		List<String> list = new ArrayList<String>(); // 결과 배열
	
		// 구현
		Arrays.sort(arr);
		//int start = 0;
		dfs(0,N,M,list);
		
		Iterator<List<String>> it = set.iterator();
		while(it.hasNext()) {
			List<String> answer = it.next();
			for(String  num :answer) {
				sb.append(num+" ");
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());// 결과 출력
	}
	// 조합
	private static void dfs(int depth, int N, int M,List<String> list) {  // 결과 배열) {
		// 목적 : 뿌리깊이 까지 탐색을 했다면 종료
		if(depth == M) {
			// 문제 set을 추가하고 list를 지우면 set도 영향을 받는다.
			List<String> answer = new ArrayList<>();
			for(int i = 0;i<list.size(); i++) {
				answer.add(list.get(i));
			}
		
			if(!set.contains(answer)) {
				set.add(answer);
				
			}
			return;
		}
		
		// 구현
		for(int i = 0; i <N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				list.add(String.valueOf(arr[i]));
				dfs(depth+1,N,M,list);
				visit[i] = false;
				list.remove(list.size()-1);
			}
		}
		
		
	}
}

