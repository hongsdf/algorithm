package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 음계 문제
/*
 *  생각한 원리는 조건에 따라 출력하는 형식이 다르다
 *  
 *  ascending 과 mixed 짝
 *  desending과 mixed 짝 
 *  mixed는 항상 등장한다.
 *  
 *  그러면
 *  ascending, desending을 각 출발 지점으로 삼아 각각에 대해서 boolean으로 판별하여 false 이면 mixed을 출력하자고 생각하자
 *  
 *  그러면 출발 지점이 ascending시작할지, desending 시작할지 정해야한다.
 *  그래서 처음 0번째 원소와 1번째 요소를 비교하여 
 *  0번째 요소 > 1번째 요소 보다 크면 desending으로 시작하고
 *  
 *  0번째 요소 < 1번째 요소보다 크면ascending으로 시작하자라고 생각했다.
 *  
 *  
 * 
 * 
 * 
 * */
 

public class Back2920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int arr[] = new int[8];
		for(int i = 0; i <8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if(arr[0] < arr[1]) { //오름 차순 구현
			 boolean flag =increasing(arr,Arrays.copyOfRange(arr, 1, arr.length));
			 if(flag) System.out.println("ascending");
			 else System.out.println("mixed");
		}else { // 내림 차순 구현
			 boolean flag = descresing(arr,Arrays.copyOfRange(arr, 1,arr.length)) ;
			 if(flag) System.out.println("descending");
			 else System.out.println("mixed");
		}
		
	}
	// 판별함수

	private static boolean increasing(int[] arr, int[] array) {
		boolean flag = true;
		// flag = true; 이면 오름차순
		for(int i = 0; i <array.length-1; i++) {//flag = flase 이면 내림차순
			if(array[i] > array[i+1]) {
				flag = false;
				break;
			}
		}
		return flag;
		
		
		
	}

	private static boolean descresing(int[] arr, int[] array) {
		boolean flag = true;
		for(int i = 0; i<array.length-1; i++ ) {
			if(array[i] < array[i+1]) {
				flag = false;
				break;
			}
		}
		return flag;
		
	}

}
