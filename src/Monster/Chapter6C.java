package Monster;

import java.io.*;
import java.util.*;
import java.lang.*;

class Utility {
	/**
	 * arr[l] ~ arr[r] 사이에 target이 존재하는지 반환하는 함수
	 * 
	 * @param arr    오름차순으로 정렬된 배열
	 * @param target 탐색하고자 하는 값
	 * @param l      탐색범위의 왼쪽 끝 인덱스
	 * @param r      탐색범위의 오른쪽 끝 인덱스
	 * @return arr내에 target이 존재하면 true, 그렇지 않으면 false
	 */
	public static boolean binarySearch(int[] arr, int target, int l, int r) {
		// implement here
		if(l == r) {
			if(arr[l] == target) return true;
			else {
				return false ;
			}
		}
		
		int mid = (l+ r)/2;
		if(arr[mid] == target) {
			return true;
		}
		else if(arr[mid] > target) {
			return binarySearch(arr,target,l,mid-1);
		}else {
			return binarySearch(arr,target,mid+1,r);
		}
		

	}
}

public class Chapter6C {
	/**
	 * 메인 함수는 자유롭게 수정하며 테스트 해도 됩니다
	 */
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 7, 8, 9, 20, 30, 50, 70, 120 };
		int target = 121;
		// Arrays.sort(arr);

		boolean result = Utility.binarySearch(arr, target, 0, arr.length - 1); // 구현한 함수의 결과

		if (result) {
			System.out.println("배열 내에 존재합니다");
		} else {
			System.out.println("배열 내에 존재하지 않습니다");
		}

	}
}