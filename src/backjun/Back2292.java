package backjun;

import java.util.Scanner;
public class Back2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
		int num = 1;
		int z = 0;
		int cnt =1;
		int n = sc.nextInt();
		int arr[][] = new int[10][100];
		for(int i = 0 ; i < arr.length;i++) {
			for(int j = 0; j <= z; j++) { // i = 1, 1~6, 2 ~ 12
				arr[i][j] = num++;
//				System.out.print(arr[i][j]+" ");
				if(n == arr[i][j]) {
					System.out.println(cnt);
				}

			}
//			System.out.println();
			if(i == 0) z+= 5;
			else z+=6; //5 ,6 ,7
			cnt++;
			
		}
		
		
	}
}
