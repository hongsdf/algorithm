package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bubbel {
//	public static int arr[] = new int [1001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		for(int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(br.readLine()) ;
			 
		}
//		for(int i = 0; i <N; i++) {
//			System.out.print(arr[i] +" ");
//			
//		}
		bubble(N,arr);
		for(int i = 0; i <N; i++) {
			System.out.print(arr[i] +" ");
			
		}
	}
	private static void bubble(int n, int[] arr) {
		// TODO Auto-generated method stub
//		arr.length : 3
		System.out.println(n);
//		System.out.println(arr.length);
		
		// for(int j =0; j <arr.length-i-1; j++) 가 안되는 이유:
//		위에 static 으로 int arr[] = new int[1001]을 생성하여서 크기가 크다 그래서 n을 사용하자
		
		// bubble 정렬 핵심 
		for(int i=0; i<arr.length; i++) { // 0 1 2 3 라운드
			for(int j =0; j <arr.length-i-1; j++) { // 0 1  라운드 마다 -1 : 0번 라운드 : 4번 ,1번 라운드 : 3번 ... 
				if(arr[j] > arr[j+1]) {
					int tmp =arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
}
