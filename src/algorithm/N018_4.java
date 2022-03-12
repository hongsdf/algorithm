package algorithm;

public class N018_4 {

	public static void main(String[] args) {
		/*
		 * 주요 요점정리
		 * 1. 행과 *의 관계를 파악한다
		 * ex) 0행 : * 1, 3행 : *4..
		 * 2. 열 길이 고정(5개)
		 * 
		 * 3. i(행)와 *의 관계이므로 i을 변수로 
		 */
		 
		
		int n =5;
		for(int i = n; i > 0; i--) { // 5 4 3 2 1
			for(int j = 0; j < n; j++) { // 5개 열 고정
				if(i > j+1) {
					// 0 : *
					System.out.print(" ");
				}else {
					System.out.print("*");
					
				}
			}
			System.out.println();
		}

	}

}
