package Strings;

import java.util.Scanner;

public class Sting_unit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int ans = solution(s);
		System.out.println(ans);
		sc.close();
		
	}
	public static int solution(String s) { 
		int answer = s.length();
		
		for(int i =1; i <=s.length()/2; i++) { // 문자열 내의 단위 크기 1 ~ 문자열/2 까지 : 이유?
			int idx = 0;
			int len = s.length();
			for( ; idx+i <= s.length(); ) { // 찾은 단위크기에 맞는 단위를 찾고 시작점 : [a]bbb, a[b]bb
				String unit = s.substring(idx,idx+i);
				idx += i; // unit에 맞는 다음 지점으로 인덱스로 이동 : 0번이 단위라면 1번단위로 인덱스 이동 
				int cnt = 0;
				for( ;idx+i<=s.length()/*시작 단위의 다음 지점부터 */ ;) {
					if(unit.equals(s.substring(idx,idx+i))) {
						cnt++; // 단위를 기준으로 다음 문단이 맞아야 cnt++
						idx += i; 
					}else break;
				}
				 
				
				if(cnt > 0) { // 단위에 맞는 하나로도 갯수(cnt) 가 있다면
					len -= i/*단위크기*/ * cnt/*단위와 맞는 갯수*/; 
					if(cnt < 9) len += 1; //aaa aaa aaa a = > 10a - > i*cnt = 9
					else if(cnt < 99) len += 2;
					else if(cnt < 999) len += 3;
					else len+=4;
				}
				answer = Math.min(answer, len);
					
					
					
				
			}
			
		}
		
		
		return answer;
	}
}
