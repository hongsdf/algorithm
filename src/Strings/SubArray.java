package Strings;

//*목표 : [1,2,3,4]
//output
//(1),(2),(3),(4)    1행  1개        
//(1,2),(2,3),(3,4)  2행  2개
//(1,2,3),(2,3,4)   3행   3개
//(1,2,3,4)   4행   4개

public class SubArray {
	public static void main(String[] args) {
		int arr[] = new int[] {1,2,3,4};
		// 글자 수 만큼 윈도우 생성
		
		// 1,2,3,4
		// 삼중for문 생각
		// 윈도우 크기만큼 배열 생성 
		
		//output
		// 행을 1for문
		// 한행 사이즈 2for문
		// 사이즈별 위치가 변하기 때문에 3for문
		//(1),(2),(3),(4)    1행  1개     4     
		//(1,2),(2,3),(3,4)  2행  2개     3
		//(1,2,3),(2,3,4)   3행   3개     2
		//(1,2,3,4)   4행   4개           1
		
		
		// 슬라이드 생성
		for(int i = 0 ; i<arr.length; i++) { // 0
			System.out.println("행"+i);
			for(int j = 0; j<arr.length-i; j++) { // 0 : 0 : 0:1, // 0 : 1 : 0: 2 // 0 : 2 : 0 : 3 // 0 : 3 : 0: 4
				
				int start = j; int end = j+i;
				System.out.print("(");
				for(int k = start; k <= end; k++) {
					if(k == end) {
						System.out.print(arr[k]);
					}else {
						System.out.print(arr[k]+",");
						
					}
				}
				System.out.print(")");
			}
			System.out.print("\n");
		}
		
		// 결과 리스트 담기
		
		int brr[] = new int[] {2,3,4,5};
		for(int i = 0; i <brr.length; i++) {
			for(int j = 0; j <brr.length-i; j++) {
				System.out.print("(");
				for(int k = j; k<= i+j; k++) {
					System.out.print(brr[k]);
				}
				System.out.print(")");
			}
			System.out.println();
		}
		
		
		/*                    행    그룹
		 	(2345)            1     1
			(234)(345)        2     2 
			(23)(34)(45)      3     3
			(2)(3)(4)(5)      4     4
		 */
		
		 System.out.println("행 번호 그룹 번호");
		 int n = brr.length;
		 for(int i = 0 ; i < n; i++) {
			 for(int j = 0; j < i+1 ; j++) { // 여기 부분수정
				 System.out.print("(");
				 int start = j; int end = n+j-i-1 ; // 0 : 4 - 0 
				                               // 1 : 4 -1
				 for(int k = start; k <= end; k++) {
					 if(k == end) {
						 System.out.print(brr[k]);
					 }else {
						 System.out.print(brr[k]+",");
					 }
				 }
				 System.out.print(")");
			 }
			 System.out.println();
		 }
		
		
		
	}
}
