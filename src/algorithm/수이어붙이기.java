package algorithm;

import java.io.*;
import java.util.*;

public class 수이어붙이기 {
	public static int arr[];
	public static Long answer = 9999999999999999L; // 정답변수
	public static int N; // 배열크기
	public static List<String> list = new ArrayList<>(); // 수들을 담을배열
	public static boolean visit[];
	public static void main(String[] args) throws Exception {
		// [1] 입력층
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String str[] = br.readLine().split(" ");
		arr = new int[N];
		visit = new boolean[N];
		for(int i = 0; i<N; i++){
			arr[i] = Integer.parseInt( str[i]);
		}
		
		
		
		// 가장 작은 수를 찾아 출력
		// [2] 구현
		// 완점탐색
		dfs(0,"");
		
		// [2-1] 십의자리수와 1의 자리수가 같은지 체크 
		solve();
		
		
		System.out.println(answer);
	}

	public static void dfs(int depth,String temp){
		// 목적 : 뿌리 끝까지 탐색하여 리스트에 저장
		// 탈출조건 : 뿌리 끝까지 탐색하면 종료
		if(depth == N){
			// 리스트 배열에 담기
			list.add(temp);
			return;
		}
		for(int i = 0; i < arr.length; i++){
			 if(!visit[i]){
				 visit[i] = true;
				 temp += String.valueOf(arr[i]);
				 dfs(depth+1,temp);
				 temp = temp.substring(0,temp.length()-2);
				 visit[i] = false;
			 }
		}
		
	}
	public static void solve(){
		for(String curr : list){
			String ans = "";
			// 42311619
			// 두개씩 묶음
			for(int i = 0; i < curr.length()-2; i+=2){ // 0  2 4
				String temp = curr.substring(i,i+2); // 앞의 arr[i]
				char c1 = temp.charAt(1); // 2
				String temp2 = curr.substring(i+2,i+4); // 뒤의 arr[i];
				char c2 = temp2.charAt(0); // 2
				
				if(ans.length() != 0) ans = ans.substring(0,ans.length()-2);
				if(c1 == c2) ans +=  temp.charAt(0) + String.valueOf(c2) + temp2.charAt(1);
				else { // 42316 
					ans += temp + temp2;
						//423 1619
				}
				
				
				
			}
			answer = Math.min(answer,Long.parseLong(ans));
			
			}
		}
	
}