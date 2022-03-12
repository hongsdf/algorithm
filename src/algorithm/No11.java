package algorithm;

public class No11 {
	
	/*Q1*/
//	1   2   3    4
//	8   7   6    5
//	9   10  11  12
//	16  15  14  13
	
	
	/*Q2*/
//	1   5   9    13
//	2   6   10   14
//	3   7   11   15
//	4   8   12   16	
	
	
	public static void main(String arg[]) {
		
		

		
		
		for(int  i = 0; i <4; i++) { 
			
  			for(int  z = 1; z < 5; z++) {
  				// z = 1
  				if(i == 0) {
  					
  					System.out.print(z+ " " );
  					
  				}
  				
  				if(i == 2) {
  					for(z = z+8; z<=12; z++) {
  						System.out.print(z +" ");
  					}
  					
  					
  				}

  				if(i == 1) {
  					for(z = z+7; z >= 5; z--) {
  						System.out.print(z +" ");
  					}
  					// z = 2;
  					
  				}
  				if(i == 3) {
  					for(z = z+15; z >= 13; z--) {
  						System.out.print(z +" ");
  					}
  					
  					
  				}
  				
  				
  				
  			}
  			
  			System.out.println(" ");
  			
			
		}
		
		
	}
}
