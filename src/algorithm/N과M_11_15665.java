package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class N과M_11_15665 {
	public static int N,M;
	public static int arr[];
	public static StringBuilder sb = new StringBuilder();
	public static Set<Integer> set = new TreeSet<Integer>(); // TreeSet은 이진탐색트리 중에서도 서능을 향상시킨 레드-블랙 트리(Red-Black Tree)로 구현되어있다. 일반적으로 트리 높이 만큼 시간소모
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		arr = new int[N];
		String str1[] = br.readLine().split(" ");
		for(int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(str1[i]);
			set.add(arr[i]);
		}
		// 구현
		List<Integer> list = new ArrayList<Integer>();
		solve(0,list);
		System.out.println(sb.toString());
		
	}
	private static void solve(int depth, List<Integer> list) {
		// 탈출 조건 : 뿌리 깊이 까지 탐색을 하면 종료
		if(depth == M) {
			// temp안에 있는 원소 출력
			for(int num : list) {
				sb.append(num+" ");
			}
			sb.append('\n');
			return;
		}
		// 구현
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			int num = it.next();
			list.add(num);
			solve(depth+1,list);
			list.remove(list.size()-1);
		}
		
	}
}
