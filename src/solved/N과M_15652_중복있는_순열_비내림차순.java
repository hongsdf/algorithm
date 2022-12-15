package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class N과M_15652_중복있는_순열_비내림차순 {
 /*
  * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되
  * 중복이 존재 전에 탐색했던 지점을 다시 탐색해도 된다.
  * 비내림 차순 => 조합 문제
  * 
  * 
  * */
	public static List<String> list = new ArrayList<>();
	public static boolean visit[];
	public static int [] arr;
	public static int N;
	public static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		visit = new boolean[N+1];
		arr = new int[N+1]; // 배열
		for(int i = 1; i <=N; i++) {
			arr[i] = i;
		}
		
		dfs(1,0,"");
		
		for(String ans : list) {
			char c[] = ans.toCharArray();
			for(char c1 :c) {
				sb.append(c1+" ");				
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
		
	}
	// 핵심  : start 매개변수
	// 재귀함수를 실행할때 나보다 작은 값으로 가지 않는다.(이때는 나를 지칭하는 변수가 필요하다 start)
	// start를 기준으로 실행 start 2 이면 2-->N , 3이면 3 --> N
	
	private static void dfs(int start,int depth, String temp) {
		// 탈출조건 : depth == M까지 탐색하면 종료
		if(depth == M) {
			list.add(temp);
			return;
		}
		// 구현
		for(int i = start; i<=N; i++) {
			// 중복이 가능
			temp += i;
			dfs(i,depth+1,temp);
			temp = temp.substring(0,temp.length()-1);
		}
		
		
	}
	

     
				
     
}
