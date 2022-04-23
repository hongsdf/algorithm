package DP;

import java.io.*;
import java.util.*;

public class grapes2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int arr[] = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 1; i<=N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken()) ; 
        }
        // 6 8 9 10 11 13 2
        int d[][] = new int[N+1][4];
        
        //초기값 : 연속값 전까지 4까지 모든 경우의 수는 세팅하는 것이 좋다
        // 즉 d[1][0] ~ d[3][0],d[3][1], d[3][2],d[3][3] 까지 세팅
        d[1][1] = arr[1];
        d[1][0] = 0;
        d[2][2] = arr[1] + arr[2];
        d[2][1] = arr[2];
        d[2][3] = arr[1] + arr[2];
        		
        d[3][1] = arr[3]+ arr[1];
        d[3][2] = d[2][1] + arr[3];
        d[3][3] = arr[1] + arr[2] + arr[3];		 
//        		49
        		
        // 점화식
        for(int i = 4; i<=N; i++) {
        	d[i][3] = d[i-1][2] + arr[i];
        	d[i][2] = d[i-1][1] + arr[i];
        	d[i][1] = Math.max(d[i-2][3] ,Math.max(d[i-2][1], d[i-2][2])) + arr[i];
        	d[i][0] = Math.max(d[i-1][1] , Math.max(d[i-1][3], d[i-1][2]) );
        }
        
        int ans = 0;
        for(int i = 1; i<=N; i++) {
        	for(int j = 0; j<4; j++) {
        		ans = Math.max(ans, d[i][j]);
        	}
        }
        System.out.println(ans);
        
        
    }
}