package algorithm;

/*중복된 수 제거*/
/*
 * 주요 요점 정리
 * brr[arr[i]] : 이중 배열
 * boolean[] brr = 1 ~ n 까지 공간을 0 or 1 확인 여부 ;
 * int arr[] : 배열
 * brr[i] 값과 i을 출력시 brr[i] : (== 1 이라면)의 값의 공간만 출력된다
 * 
 */
public class No21_2 {
	public static void main(String[] args) {
		 // 0 1 8 9
		boolean[] brr = new boolean[101]; // 100 공간 중 TRUE OR FALSE 확인 여부
		int arr[] = new int[101]; // 100 공간
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 13;
		arr[3] = 20;
		arr[4] = 11;
		arr[5] = 21;
		arr[6] = 11;
		arr[7] = 21;
//		for(int i = 0; i <arr.length; i++) {
//			System.out.print(arr[i] + " ");
//			
//		}
		
		for(int i = 0; i <= 100; i++) {
			// brr[i] = arr[i]
			brr[arr[i]] = true; // brr[arr[0] : 1 ]  : true;
			
		}
		for(int i = 1; i <= 100; i++) {
			if(brr[i]) {
				System.out.print(i+" ");
			}
			
		}
		
		// 1 2 13 20 11 21 11 21
		// 1 2 11 13 20 21
		// 한번이라도 등장하면 true
		
//		
//		ArrayList<Integer> list = new ArrayList<>();
//		list.add(1);
//		list.add(2);
//		for(Integer e: list) {
//			System.out.println(e);
//			
//		}
//		
//		
		
		
	}
}
