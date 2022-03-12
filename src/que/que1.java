package que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class que1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		LinkedList<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<=n; i++) {
			q.add(i);
		}
		// 첫카드 버리기
		while(n != 1) {
			q.poll(); //1 // 3 //5 //2 //6
			if(q.size() == 1) {
				break;
			}
			int number = q.poll(); //2
			q.add(number); // 4 6
		}
		
		while(!q.isEmpty()) {
			System.out.print(q.poll()+" ");
		}
		
		
		
		
	}
}
