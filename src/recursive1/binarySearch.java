package recursive1;

import java.util.Arrays;


// 범위를 조정하는 방법
// 오름차순으로 정렬이 되어있어야 진행이 가능하다.

// 내일 해야하는 것 :  컴퓨터가 범위중 하나를 임의로 생성하여 맞추기 프로그램 생성

class Main1{
	// -1 0 1 2 3 4 7 9 10 20
	public int solution(int arr[], int left,int right, int x) {
		// 찾고자 하는 값이 없을 경우
		if(left > right) { return -1;}
		
		// 0 1 2 3
		// 0 1 2 3 4 5 6 7 8 9 
		// 4 5 6 7 8 9 
		// 범위의 중간지점
		int range = (left + right)/2;
		// 4
		
		// 값을 찾으면 인덱스 값을 리턴
		if(x == arr[range]) {
			return range;
		}
		
		// range-1 : -1를 하는 이유 : 같은 경우는 x==arr[range]에서 걸러진다
		// 찾고자 하는 값이 중간 범위보다 작은경우 중간을 기준으로 오른쪽 범위를 버린다.
		if(x < arr[range]) {
			return solution(arr,left,range-1 ,x);
		}
		
		
		// 범위가 줄여져야 한다.
		// 4 ~ 9
		// range+1 : +1를 하는 이유 :  같은 경우는 x==arr[range]에서 걸러진다
		// 찾고자 하는 값이 중간 값보다 큰 경우 왼쪽 범위는 버린다.
		return solution(arr,range+1 ,right,x);
	}
	
	
	
}







public class binarySearch {
	public static void main(String[] args) {
		Main1 m = new Main1();
		int arr[] = {-1, 0, 1, 2, 3, 4, 7, 9, 10, 20};
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		int x = 13;
		int res = m.solution(arr,0,arr.length-1,x);
		
		System.out.println("\n"+res);
	}
}
