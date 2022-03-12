package algorithm;

public class No22_2 {
	public static void main(String args[]) {
		String n = "1135311";
		boolean flag = true;
		int len = n.length();
		for(int i = 0; i < len/2 ; i++) {
			if(n.charAt(i) != n.charAt(len-i-1)) {//charAt(index) :  문자열을 인덱스별로 분리하는 메서드 반환 String
				flag = false;
				// char타입 : 한 문자이지만 아스키코드로 받기 때문에 정수형이다
				// [0]   [4]
			}
		}
		System.out.println(flag);
	}
}
