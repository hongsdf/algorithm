package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 피보나치수2 {
	public static long d[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		d = new long[n+1];
		long result = fibo(n);
		System.out.println(result);
		Arrays.fill(d, 0);
		fibo2(n);
		
		
		
	}
	public static long fibo(int n) {
		// Top - Down
	
		
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(d[n] != 0) return d[n];
		
		return d[n] = fibo(n-1) + fibo(n-2); 
	}
	public static void fibo2(int n) {
		d[0] = 0;
		d[1] = 1;
		for(int i = 2; i<=n; i++) {
			d[i] = d[i-1] + d[i-2];
		}
		
		
	}
}
