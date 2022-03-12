package Sort;

import java.util.Scanner;

public class Bubble_De2 {
	public static void swap(int arr[],int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		
	}
	
	
	
	public static void bubble(int arr[]) {
		// bubble 정렬
		// 앞칸 과 뒤칸을 비교해서 자리를 바꾼다
		// 반복 횟수 :  arr.length -1
		// 각 라운드 마다 -1 횟수
		
		// (개선)시간을 줄이기 위한 변수
		boolean flag = false;
		
		for(int i =0; i<arr.length-1;i++) { // 4 행
			for(int j =0; j<arr.length-1 -i;j++) { //4 3 2 1 횟수  총 10번 
				// 이 조건이 맞을 때 에만 swap함수가 실행되는 것
				if(arr[j] > arr[j+1]) {
					swap(arr,j,j+1);
					flag = true;
				}
			}
			// 이 조건이 실행되는 것은  : 라운드에서 교환이 이루어지지 않는 것
			if(flag = false) {
				break;
			}
		}
		for(int i =0; i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i =0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		bubble(arr);
	}
	

}
