package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class compareString {
	public static void main(String[] args) {
		int arr1[] = {1,3,5,7,9,10,12,15,16,18};
		int arr2[] = {1,2,4,5,10,};
		int cnt = 0;
		Set<Integer> set = new HashSet<>();
		for(int i =0; i<arr1.length; i++) {
			for(int j =0; j<arr2.length; j++) {
				if(arr1[i] == arr2[j]) {
					cnt++;
					set.add(arr1[i]);
				}
			}
		}
		System.out.println(cnt);
		System.out.println(set);
		
	}
	

}
