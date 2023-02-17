package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


class jewelry{
	int weight;
	int value;
	
	public jewelry(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
}

public class 보석도둑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long answer = 0;
		
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
//		boolean visit[] = new boolean[N+1];
		
		int c[] = new int[K+1];
		jewelry[] jewelries = new jewelry[N];
	
		// 우선 순위 큐 생성		
		// 가바에 대한 큐 생성
		Queue<Integer> q = new LinkedList<>();
		
		
		
		
		for(int i = 0; i <N; i++ ) {
			String str1[] = br.readLine().split(" ");
			int W = Integer.parseInt(str1[0]);
			int V = Integer.parseInt(str1[1]);
//			w[i] = W;
//			v[i] = V;
			jewelries[i] = new jewelry(W,V);
			
			// pq.add(new jewelry(W,V));
			
		}
		Arrays.sort(jewelries,new Comparator<jewelry>() {

			public int compare(jewelry j1, jewelry j2) {
				if(j1.weight == j2.weight) {
					return j2.value - j1.value; // 가격 내림 차순
				}
				return j1.weight - j2.weight; // 무게 오름 차순
			}
		});
		
		
		for(int i = 1; i <=K; i++) { 
			int weight = Integer.parseInt(br.readLine());
			c[i] = weight;
		}
		// 구현 계층
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> (b-a));
		// 가방에 대한 정렬
		
		Arrays.sort(c);
		for(int i = 1; i <=K; i++) { 
			q.add(c[i]);
		}
		// O(n) or O(NlogN)
		for(int i = 1 , j = 0; i<= K; i++) {
			// 현재 가방 무게 보다 작은 것을 모두 넣는다.
			while(j < N && jewelries[j].weight <= c[i]) {
				pq.add(jewelries[j].value);
				j++;
			}
			if(!pq.isEmpty()) {
				answer += pq.poll();
				
			}
				
		}

		bw.write(answer +"\n");
		bw.flush();
		bw.close();
		br.close();
		
		
	}
}
