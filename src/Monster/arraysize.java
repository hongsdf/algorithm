package Monster;

import java.io.*;
import java.lang.*;
import java.util.*;


public class arraysize {
	public static final Scanner scanner = new Scanner(System.in);

	/**
	 * 배열의 N개의 원소가 연속적인 정수 수열로 표현될 수 있는지 판단하는 함수
	 * @param data
	 * @param n
	 * @return
	 */
	public static boolean isConsecutive(int[] data, int n)
	{
		// 정렬 문제로 풀면 o(n^2)
    // 다시 배열 순회 o(n)을 하여 
		//data[i]+1 == data[i+1] 비교 o(n^2) 
		
		// 최대 , 최소값을 구해서 그사이 갯수를 측정 M
		// M 칸안에 원소가 다 있어어야한다.
		
		// M = G + L -1 : 칸수
		
		// M < N
		// [1,2,3]
		// N : 4 이고 M : 3+1-1 = 3
		// [1,2,2,3]중복 값으로 채워야한다.
		
		
		// M > N
		// [1,2,3,4,5]
		// N = 3, m =4+1-1 = 4
		// 3칸중 4개로 채운다 ? => 크기 초과
		
		// M == N
		// [1,2,3,4,5]
		int l,g,m;
		l = data[0];//최소값
		g = data[0];//최대 값
		
		for(int i = 0; i<n; i++){
			if(l > data[i]){
				l = data[i];
			}
			// esle if을 사용하지 않는다 원소가 하나라면 두조건다 해당 되므로
			if(g < data[i]){
				g = data[i];
			}
		}
		m = (g - l + 1); // 폐구간 계산 공식 [a,b] = a + b - 1
		if(m == n){
			return true; 
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();
		int[] data = new int[n];
		for(int i = 0 ; i < n ; i ++)
		{
			data[i] = scanner.nextInt();
		}

		boolean result = isConsecutive(data, n);

		if(result)
		{
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}
}
