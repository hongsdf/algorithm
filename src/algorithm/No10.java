package algorithm;

public class No10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1  2   3   4
//		5  6   7   8
//		9  10  11  12
//		13 14  15  16
		
		int z = 0; // 4 8 12
		int j = 1; // 5 9 13
		
		for(int i = 0; i < 5 ; i++) {
			
			
			for(; j < 5 + z ; j++) {
				
				System.out.print(j+" ");
			}
			z +=4;
			
			
			
			
			System.out.println(" ");
		}
	}

}
