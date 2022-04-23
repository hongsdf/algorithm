package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tile2 {
	public static int d[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		d = new int[1001];
		int ans = solve(N);
		System.out.println(ans);
	
	}
	private static int solve(int n) {
		if(n == 0) return 1;
		if(n == 1) return 1;
		if(d[n] > 0 ) return d[n];
		d[n] = solve(n-1) + 2* solve(n-2);
		
		return d[n];
	}
	private static int solve2(int n) {
		d[0] = 1;
		d[1] = 1;
		for(int i = 2; i <=n; i++) {
			d[i] = d[i-1] + d[i-2] * 2;
		}
		
		// TODO Auto-generated method stub
		return d[n];
	}
	
	
}
