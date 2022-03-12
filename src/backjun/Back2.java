package backjun;

import java.util.Arrays;
import java.util.Scanner;

public class Back2 {
	public static void main(String[] args) {
		int n = 9;
		int arr[] = new int[n];
		int sum = 0;
		int spy1 = 0,spy2 = 0;
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i <arr.length; i++) {
			arr[i] = sc.nextInt();
			 sum += arr[i];
		}
		Arrays.sort(arr); // 오름 차순 정렬
		
		for(int i = 0; i<arr.length; i++) {
			for(int j = i+1; j<arr.length; j++) {
				if(sum - arr[i] - arr[j] == 100) {
					spy1 = i;
					spy2 = j;
					break;
				}
			}
		}
		for(int a =0; a<arr.length; a++) {
			if(a == spy1 || a == spy2)  
				continue; // 애네는 제외
			
			System.out.println(arr[a]);
		}
		sc.close();
	}
}
