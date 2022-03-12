package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1065 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		// 첫째항 + (n-1)d : 등차 수열
		int ans  = d(n);
		System.out.println(ans);
	}
	
	
	static int d(int n) {
		int cnt = 0;
		
		if(n<100) { // 99 이하의 개수는 99
			return n; //들어온 수를 return 한다.
		}
		
		else { // 100 이상 의 수
			cnt = 99; //최소 개수 99
			
			if(n == 1000) {
				n = 999;
			}
			
			for(int i = 100; i<= n; i++) {
				int hundred = i/100; // 1
				int ten = (i/10)%10; // 4
				int one = i%10; //7
				
				if((hundred -ten) == (ten - one))
					cnt++; // -3 == -3 
			}
		
		}
		
		
		return cnt;

	}
		
		
		
	

}
