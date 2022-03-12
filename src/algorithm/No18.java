package algorithm;

public class No18 {

	public static void main(String[] args) {
		
		//     *  0행 1개
		//    **  1행 2개
		//   ***  2행 3개
		//  ****
		// *****
		
		
		
		int n =5;
		for(int i = n ; i > 0; i--) {
			for(int j = 0; j < n;j++) { // 5번 고정			
				// 0 < 4 a  0 < 3 a  0 < 2
				// 1 < 4 a  1 < 3 a  
				// 2 < 4 a  2 < 3 a  
				// 3 < 4    3 < 3 *  
				// 4 < 4 *  4 < 3 *
				
				
				if( j < i-1) { // 행이 변화에 따라  
					System.out.print(" "); 
				}else {
					System.out.print("*"); 
				}
				
			}
			System.out.println();
		}

	}

}
