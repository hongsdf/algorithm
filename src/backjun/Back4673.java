package backjun;

import java.io.*;

public class Back4673 {
//	static int mode[] = new int[1000];

//	static boolean flag[] = new boolean[10001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		boolean flag[] = new boolean[num +1];
		for(int i = 1; i <num+1;i++) {
			int n = d(i);
			
			if(n < num+1)
			flag[n] = true;
		}
		
		
		
		for(int i = 1; i< num+1; i++) {
			if(!flag[i]) {
				System.out.println(i);
			}
		}
		
		
		
		
		
	}
	
		
	
	


		public static int d(int n){ // 17 여기서 걸리는 것은 생성자가 있는 숫자 이다
			int sum = n;
		    
			while(n != 0){
				sum = sum + (n % 10); // 첫 째 자리수 , 17 + 7 = 24 25
				n = n/10;	// 10을 나누어 첫 째 자리를 없앤다 1 0
			}
		    
			return sum; // 25
		}
	

}
