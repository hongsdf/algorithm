package que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class yousepuce {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," "); //buffer에 기준 주기
		LinkedList<Integer> link = new LinkedList<Integer>();
		int size = link.size();
		List<Integer> list = new ArrayList<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int idx = 0;
		for(int i =0; i<N; i++) {
			link.add(i+1);
		}
		
		
		System.out.print("<");
		while(!link.isEmpty()) {
			// 1 2  4 5 7   //        0+2 %7 ,  2+2 % 6, 4+2 % 5, 1 +2 % 4, 5%3 , 2+2% 2 ,2%1 
			idx = (idx+(M-1)) % link.size();	// 3  
//			System.out.println("idx : "+idx+" link.size() :"+link.size()+"\n");
			if(link.size() == 1) {
				System.out.print(link.get(idx));
				
			}else {
				System.out.print(link.get(idx)+ ", ");
			}
			link.remove(idx);
		}
		System.out.print(">");
		
	}
}
