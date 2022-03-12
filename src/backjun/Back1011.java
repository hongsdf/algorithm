package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Back1011 {
	public static void main(String[] args) throws IOException{
		// 0 : 3 3
		// 0   1    2    3     4      5    6      7 
		//  -->   ------->  -----------> --->   
		int cnt = 0;
		// 1 ~ 5  4 - 2 = 2/2
		// 2 ~ 7  6 - 2 = 4/2 = 1 + 1 +2
		// 4 ~ 7  6 - 4 = 2/2 = 1+2
		// 1 ~ 1476004783 =  1,476,004,782 - 2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T;i++) {
			
			String[] strs = br.readLine().split(" ");
			int x = Integer.parseInt(strs[0]);
			int y = Integer.parseInt(strs[1]);
			
			
			if(x == 0) {
				x++;
				cnt++;
			}
			// 35 - 15 = 20/2 + 1 == 1  , 45-15 = 30/2 + 1 =16, 42 - 15 = 27/2 = 13 +1
			// 15  16  17  18  19  20  21  22  23  24  25  26  27  28  29  30  31  32  33  34  35  36  37   38   39   40   41   42  
//				 ----->  ----->  ----->  ----->  ----->  ----->   ----->  -----> ----->  ----->  ------> -------> -------->  --->                    --> -->
			int n = y - x ;
			int m = (n/2)+1;
			
			cnt += m;
			
		}
		System.out.println(cnt);
		
	
		
	}
}
