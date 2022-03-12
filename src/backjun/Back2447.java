package backjun;

import java.util.Arrays;
import java.util.Scanner;

public class Back2447 {
	static char arr[][];
	static void star(int r,int c ,int n ,boolean flag) {
//		**** **** **** ****  16 * 16
//		*67* *  * *  * *  *
//		*11* *  * *  * *  *               
//		**** **** **** ****
//		****           ****
//		*  *           *  *
//		*  *           *  *
//		****           ****
//		****           ****
//		*  *           *  *
//		*  *           *  *
//		****           ****
//		**** **** **** ****
//		*  * *  * *  * *  *
//		*  * *  * *  * *  *
//		**** **** **** ****
		if(flag) {
			for(int i =r; i<r+n;i++) { // (1,1) -> (1,2)
				for(int j=c; j <c+n; j++) { // (2,1) -> (2,2)
					arr[i][j] = ' ';
				}
			}
			return;
		}
		
		
		if(n == 1) {
			arr[r][c] = '*';
			return;
		}
		
		int size = n/4; // size :하나의 블록 당 크기 n=4 -> 1*1 , n =16 ->4*4
		int cnt = 0;
		for(int i =r; i<r+n; i+=size) {  // r:0 ->  (0~3 (size) 4~7 (size)  8~11 (size) 12 ~ 15         )
			for(int j =c; j<c+n; j+=size) { // c :0 
				cnt++;
				if(cnt == 6 || cnt == 7 || cnt == 10 || cnt == 11) {
					star(i,j,size,true); // 1 2 1 
				}else {
					star(i,j,size,false);
				}
			}
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		 arr = new char[n][n]; // 결과
		 star(0,0,n,false);
		 
		 StringBuilder ssb = new StringBuilder(); // StringBuilder란 문자열 객체를 생성해주는 변수
		 for(int i=0; i<arr.length; i++) {
			 for(int j=0; j<arr[i].length; j++) {
				 ssb.append(arr[i][j]);
			 }
			 ssb.append('\n');
		 }
		 System.out.println(ssb);
		 sc.close();
		 
		 
	}	
}
