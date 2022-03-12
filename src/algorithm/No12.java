package algorithm;

public class No12 {
	public static void main(String args[]) {
		/*Q2*/
//		1   5   9    13
//		2   6   10   14
//		3   7   11   15
//		4   8   12   16	

		int j = 1;
		for(int i = 0; i <4; i++) {
			
			
			
			for(; j < i+14 ;) {
				System.out.print(i+j+" ");
				j +=4;
				
			}
			j = 1;
			
			
			
			System.out.println("");
		}
	}
}
