package Strings;

class Main{
	public String[] word = {"zero","one","two","three","four","five","six","seven","eight","nine"};
	
	public int solution(String s) {
		int res = 0;
		String sa  = "";
		// 숫자 컨테이너
		for(int i =0; i<s.length(); ) {
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				sa += s.charAt(i);
				i++;
			}else {
				// 10번을 반복한다 
				for(int j =0; j<10; j++ ){
					if(s.startsWith(word[j], i)) {
						// 조건문을 찾으면 라운드 종료 
						sa += j;
						i += word[j].length();
						System.out.println(j+":확인");
						// 알맞은 j를 찾으면 
						break;
					}
					// 다시 j는 0 으로 된다 => 즉 다음 라운드로
					System.out.println(j + " 반복문 종료?");
					 
				}
					
				// break; // : 여기서 브레이크를 달면 else 문에서 한 문자만 찾고 끝 
			}
			// break; : 여기서 브레이크를 달면 for(int i =0; i<s.length;) 문이 하나 찾으면 종료
			
		}
		
		
		res = Integer.parseInt(sa);
		// 문자 컨테이너
		
		return res;
		
	}
	
	
}





public class String_m1_startWith {
	public static void main(String[] args) {
		Main m = new Main();
		String s = "3zeroonenine98six"; //1019986
//		String s1 = "12034";
//		System.out.println("확인");
//		int res1 = m.solution(s1);
		System.out.println(m.solution(s));
		
		
	}
	

}
