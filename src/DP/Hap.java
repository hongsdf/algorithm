package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hap {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); 
		int K = Integer.parseInt(st.nextToken()); // 조건 갯수
		
		// 2D DP
		long d[][] = new long[K+1][N+1];
        
        // 초기식 || 점화식이 중요하다
        d[0][0] = 1; // 아무것도 하지않고 0을 만드는 방법 1가지 (공집합 의미) : 경우의 수 문제에서 생각이 필요하다.
        
        
        for(int k1 = 1; k1<=K; k1++){
        	// 0부터 N까지
            for(int i = 0; i<=N; i++){
                // 그러면 한번선택해서 0을 만들수도 잇다.
                for(int j =0; j<=i; j++){
                   d[k1][i] += d[k1-1][i-j];  //경우의수 이니깐 j횟수가 ++ (값을 구하는 것이 아닌)
                   d[k1][i] %= 1000000000L;
                }
              
                    
                    
              //  0~n까지 완성 
              //  0~1까지 선택 0,1
              //  0~2까지 선택 0,1,2
              //  0~3까지 선택 0,1,2,3
                    
              //  0~N까지 선택 0,1 2 3 .. N
               
              //  O+O+O+ j   = N
              //  O+O+O = N -j
              //  D[N] = N까지 경우의수 
              //  D[N-j] = N-j 까지 경우의 수 
              //  마지막 j를 더한 행동은 +1 
              //  그러면 k입장에서 -1
                    
            }
        }
        System.out.println(d[K][N]%1000000000L);
        
    }
}
        
		