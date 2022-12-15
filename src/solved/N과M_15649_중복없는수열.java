package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N과M_15649_중복없는수열 {
 /*
  * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되
  * 중복이 없다는 것은 뿌리를 탐험할때 전에 탐험했던 원소는 탐험하지 않는다.
  * 
  * 
  * */
	public static boolean visit[];
	public static int [] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		visit = new boolean[N+1];
		arr = new int[N+1]; // 배열
		for(int i = 1; i <=N; i++) {
			arr[i] = i;
		}
		dfs(0,"",M);
		
	}

        private static void dfs(int depth,String temp,int M) {
        	// 탈출조건 깊이(M)까지 도달하면 종료
        	if(depth == M) {
        		char c[] = temp.toCharArray();
        		for(char a :c) {
        			System.out.print(a +" "); 
        		}
        		System.out.println();
        		return;
        	}
        	
        	// 구현
        	for(int i = 1; i <= arr.length-1; i++) {
        		if(!visit[i]) {
        			visit[i] = true;
        			temp += i;
        			dfs(depth+1,temp,M);
        			temp = temp.substring(0,temp.length()-1);
        			visit[i] = false; 
        		}
        	}
        	
				
     }
}
