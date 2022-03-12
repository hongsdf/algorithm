package recursive1;

class Main{
	
//	public static String reverseString(String s,String result) {
//		if(s.equals("")) {
//			return result;
//		}
//		
//		
//		result =  result + s.charAt(s.length()-1); 
//		System.out.println("round:"+result);
//		return reverseString(s.substring(0,s.length()-1),result);
//	}
	
	public static String reverseString(String s) {
		String result = "";
		char c[] = s.toCharArray();
		
//		for(int i=s.length()-1; i>=0; i--) {
//			result += s.charAt(i);
//			
//			
//		}
		for(int i =c.length-1; i >=0; i--) {
			result += c[i];
		}
		
		
		
		
		return result;
	}
	
	
	
}




public class review1 {
	// 문자열 뒤집기
	public static void main(String[] args) {
		Main m = new Main();
		String sc = "bcad";
		String c1 = m.reverseString(sc);
		System.out.println(c1);
	}
}
