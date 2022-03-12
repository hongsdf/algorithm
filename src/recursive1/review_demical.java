package recursive1;

public class review_demical {
	public static String d(int n,String result) {
		if(n ==0) {
			return result;
		}
		
		result = n%2 + result;
		
		return d(n/2,result);
	}
	
	
	public static void main(String[] args) {
		int n = 566; 
		String result = d(n,"");
		System.out.println(result);
	}
}
