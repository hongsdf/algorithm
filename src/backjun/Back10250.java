package backjun;

import java.util.Scanner;
public class Back10250 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num =1;
		for(int i = 0; i < n; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int m = sc.nextInt();
			
			int room = 0;
			int Y; 
			if(m%h ==0) { // (h*w)/m  5/5 = 1  15/5 = 3 20/5  6%5 7%5 13%5  5%5 ==0 10%5  9%5 =4 10/5 ==2
			    Y = h;
				
			}
			else {
				Y = m%h;
			}
			int v;
			if(m%h == 0) {  // 30 50 72
				v = m/h; // 2/5 < 1 3/5 <1  4/5 5/5 =1 6/5 15<5
			}else {
				v = (m/h)+1; // (9/5) =1 //(14/5) = 2+1
				// 3/5 = 0 5/5 = 1 2/5 = 0
				// 9 /5 = 1 8/5 1 7/5
				// 15 / 5  14/5= 2  13/5= 2 12/5= 2  3
			}
			
			
			System.out.println(room+(Y*100)+v);
			
			
					 // 12/5 = 2  22/5 =4
					 // 12/5 = 2  22%5 =2
					
			
			/* 501 502 503 504 505  
			   401 402 403 404 405  
 			   301 302 303 304 305 
			   201 202 203 204 205 
 			   101 102 103 104 105  */
			
			
			
		}
		

	}

}
