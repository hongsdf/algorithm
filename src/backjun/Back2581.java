package backjun;

import java.util.Scanner;

public class Back2581 {
	static boolean prime(int a) {
		boolean flag = true; // ¼Ò¼ö : true
		
		// 25°³
		// 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
		// 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
		if(a == 1) return false;
		if(a == 2) return true;
		
		for(int i = 2; i < a; i++) { // 2 4
			if(a%i == 0) {
				flag = false;
			}
		}
		
		
		return flag;
	}
	public static void main(String[] args) {
//		4
//		1 3 5 7
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		int arr[] = new int[n];
		for(int i =0; i<arr.length; i++) {
			arr[i] = sc.nextInt();	
			if(prime(arr[i]) == true) {
				cnt++;
			}
			
		}
		System.out.println(cnt);
		
		sc.close();
	}

	
}
