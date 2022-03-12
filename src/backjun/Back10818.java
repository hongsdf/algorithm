package backjun;

import java.util.Scanner;

public class Back10818 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		int min =1000;
		int max =-1;
//		mode[0] = 1000;
//		mode[1] = 1;
		for(int i =0; i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		 
		for(int j =0; j<arr.length;j++) {
//			mode[0] = arr[j]; // ÃÖ¼Ú°ª
//			mode[1] = arr[j]; // ÃÖ´ñ°ª
			
			if(min > arr[j]) {
				min = arr[j];
			} // 20 > 35
			if(max < arr[j]) {
				max = arr[j];
			}
			// 0 : mode[0] =20 ,mode[1] = 1 
			// 1 : mode[0] =20 ,mode[1] = 1 
			// 2 : mode[0] =35 ,mode[1] = 1 
			// 3 : mode[0] =35 ,mode[1] = 1 
			// 4 : mode[0] =35 ,mode[1] = 7 
			
		}
	
		System.out.println(min +" "+ max);
//		5
//		20 10 35 30 7
//	}
	}
}
