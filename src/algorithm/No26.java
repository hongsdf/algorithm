package algorithm;

public class No26 {

	public static void main(String[] args) {
		int n1 = 250;  // 4 *100 + 3*10 + 7*1
		int n3 = n1;
		int n2 = 287;
		int n4 = n2;
		
		
		
		
		int res1 = 0;
		int tmp = 0;
		int i = 100;
		
		int i2 = 100;
		int res2 = 0;
	    int tmp2 = 0;
	    
		
		while(n1 > 0) {
			tmp = n1%10; // 4 3
			n1 /= 10; // 73  7
			tmp = tmp * i;
			i /= 10;
//			System.out.print(tmp);
			res1 += tmp; // 400
		}
//		System.out.println(res1);
		
	    while(n2 > 0) {
//	    	int n2 = 934;
	    	tmp2 = n2%10; 
	    	tmp2 = tmp2 * i2;
	    	n2 /= 10; // 93
	    	i2 /= 10;
	    	res2 += tmp2;
	    	
	    }
//	    System.out.println(res2);
	
	    
	    if(res2 > res1) {
	    	System.out.println(n4+"°¡ ´õ Å®´Ï´Ù"+res2);
	    }
	    else {
	    	System.out.println(n3+"°¡ ´õ Å®´Ï´Ù"+res1);
	    }
	    
	}

}
