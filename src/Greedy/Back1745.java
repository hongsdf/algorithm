package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Back1745 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
		int N = Integer.parseInt(br.readLine());
		/* 내가 생각한 방법		
		long arr[] = new long[N];
		for(int i=0;i<N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);
		long standard = arr[0];
		long ans = 0;
		for(int i =1; i<N; i++) {
		
			// ans, standard를 서로 독립적으로 구현(관계없음)
			 
			ans += standard + arr[i];
			standard = standard + arr[i];
		}
		System.out.println(ans);
	 */
		
		PriorityQueue<Long> pq = new PriorityQueue<Long>(); // q가 오름차순으로 정렬
		
		for(int i =0; i <N; i++) {
			pq.add(Long.parseLong(br.readLine()));
		}
		
		long ans = 0;
		while(pq.size() > 1) { // *2개 이상부터 묶음을 비교하는 것이 의미가 있다. // 1개라면 비교 할것이 없어 0
			long temp1 = pq.poll();
			long temp2 = pq.poll();
			ans += (temp1 + temp2); //  *ans을 따로 만들어 놓는다
			
			pq.add(temp1+temp2); // *2개의 값을 더해서 다시 인큐 
		}
		
		System.out.println(ans);
		
		
		
		
		
		
	}
}
