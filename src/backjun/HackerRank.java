package backjun;

import java.util.Scanner;
import java.util.*;
public class HackerRank {
	static int sock(int n,int[] arr) {
		int cnt = 0;
		
		Set<Integer> set = new HashSet<>();
		// set에는 null
		for(int i = 0; i<arr.length; i++) {
			if(!set.contains(arr[i])) { // 추가 작업
				set.add(arr[i]);
			}else {
				cnt++;
				set.remove(arr[i]);
			}
		}
		
		return cnt;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int ans = sock(n,arr);
		System.out.println(ans);
	}
}
