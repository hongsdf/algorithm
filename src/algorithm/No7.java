package algorithm;

public class No7 {
// 소수판별
	/* 
	 * 핵심 요점 정리
	 * boolean flag 을 사용하는 이유 : 확인 여부를 판단하기 위한 설정
	 * for() 문안에 if 문을 거치는 경우이므로 (소수 x) flag  => false가 됨
	 * 소수 o 이면 if문을 거치지 않은 경우 flag는 true;
	 */
	public static void main(String[] args) {
		int in = 3;
		boolean flag = true;
		
//		2 /1  =2 ..0
//		2 /2 = 1 ...0
		
//	    8 / 2 == 4 ...0
//		8 / 8 == 1 ...0
//		8 / 4 == 2 ...0 
		
//		소수는 판별은 2부터 자기 자신-1까지 검색 
		for(int i =2; i <= in-1 ; i++) {
			// 반복문 도중에 한번이라도 나누어지면 소수가 아니다
			if(in % i == 0) {
				flag = false;
				
			}
			
		}
//		소수라면 if문에 한번도 거치지 않으므로 flag는 위와 같이 true가 그대로
		if(flag) {
			System.out.println(in+" 소수 입니다");
		}
		else {
			System.out.println("소수 x");
		}
		
	}
}
