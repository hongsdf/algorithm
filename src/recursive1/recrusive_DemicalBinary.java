package recursive1;

import java.util.*;

// 10진수를 2진수로
public class recrusive_DemicalBinary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String ans = find(N,"");
		System.out.println(ans);
		
	}
	
	
	public static String find(int demical,String rs) {
		// base-case :탈출 조건
		if(demical ==0) { // 몫이 0이 되었을때
			return rs;
		}
		rs = demical%2 + rs;
		
		return find(demical/2,rs);
	
	}
	// 구현 순서
//	num  demical%2  rs -> 	rs
//	54      0       ""   	"0"
//	27      1       "0"   	"10"
//	13      1       "10"   "110"
//	6       0      "110"   "0110"
//  3	    1      "0110"  "10110"
//  1	    1     "10110"  "110110"
//  0	          "110110"
}
