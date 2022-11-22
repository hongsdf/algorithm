package Test1;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열_contains {
	public static void main(String[] args) {
		String str = "123123567";
		boolean flag = str.contains("3123567");
		System.out.println(flag);
		
		 int start = -14; // 시작점
         int end = -5; // 도착지점
         int length = end - start;
         System.out.println(length);
         
         int arr[][] = new int[][] {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
         Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] > o2[0]) {
					return 1;
				}
				return -1;
			}
		});

         
	}
}
