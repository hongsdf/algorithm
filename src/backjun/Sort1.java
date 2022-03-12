package backjun;

import java.util.*;

public class Sort1 {
	public static void main(String[] args) {
		
//		********** 중요
		
		// Collections.reverseOrder 불가
//		int arr[] = {1,4,5};
//		Arrays.sort(arr,Collections.reverseOrder()); // 불가 : primative타입은 불가하므로 boxing 필요
		
		//----  개선 한뒤
		Integer N[] = {1,4,5};
		Arrays.sort(N,Collections.reverseOrder());
		// -------
		for(int n:N) {
			System.out.print(n);
		}
		System.out.println();
		
//		 *****************
		
		
		List<Integer> list = new ArrayList<>(Arrays.asList(1,4,5));
		Collections.reverse(list);
		for(int s1:list) {
			System.out.print(s1);
		}
	}
}
