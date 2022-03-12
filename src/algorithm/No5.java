package algorithm;

public class No5 {
// 대소문자 변경하기
	/*핵심 요점
	 * 라이브러리나 다른 모튤을 사용하지 않고 java에서는 아스키 코드를 활용하여 변경해야 한다.
	 * 
	 * */
	public static void main(String[] args) {
		String A = "helloWORLD"; // 기대값 HELLOworld;
// 		아스키 코드를 사용
		char b[]; // char[]로 (문자열--> 문자) 하게 되면 각 문자를 접근 할수있게 된다.
		b = A.toCharArray(); // toCharArray : charArray로 변경
		
		// 문자열을 각 문자로 변경하여 순회
		for(int i = 0; i < b.length ; i++) {
			// 소문자 --> 대문자
			if(b[i] >= 'a' && b[i] <= 'z') {
				b[i] = (char) (b[i] + 'A' - 'a'); // 'A' - 'a' :아스키 코드로 했을때 차이는 30
			}
			// 대문자 소문자
			else if(b[i] >= 'A' && b[i] <= 'Z') {
				b[i] = (char) (b[i]- ('A'-'a'));
			}
		}
		System.out.println(b);
	}
}
