package algorithm;

import java.util.*;

public class No24 {
	public static void main(String[] args) {
		int student = 7; //학생수
		int st1 = 7 ; // 학생점수
		int st2 = 100 ; // 학생점수
		int st3 = 95 ; // 학생점수
		int st4 = 80 ; // 학생점수
		int st5 = 60 ; // 학생점수
		int st6 = 70 ; // 학생점수
		int st7 = 70 ; // 학생점수
		
//		int avg = st1+st2+st3+st4+st5+st6+st7;
//		int m = avg/student;
//		System.out.print(m);
		
		Map<Integer,Integer> number = new HashMap<>();
		number.put(1, 7);
		number.put(2, 100);
		number.put(3, 95);
		number.put(4, 90);
		number.put(5, 80);
		number.put(6, 70);
		number.put(7, 60);
		number.put(8, 50);
		
		Set<Integer> set = number.keySet();
		System.out.println(set);
		
		// iterator는 한번 사용하고 나면 다시 같은 기능으로 사용할수 없다
		Iterator<Integer> iter = set.iterator(); 
		Iterator<Integer> iter2 = set.iterator(); // 그래서 다시 만듬
		
		int total = 0;
		int cnt = 0;
		while(iter.hasNext()) {
//			int avg = 68;
			int v = iter.next();
			int num= number.get(v);
//			System.out.println(v+"학생의 점수는 : " + num);
			
			
			total += num;
			
		}
		double avg = total/8;
		
		while(iter2.hasNext()) { //iter를 그대로 사용하면 위에 사용하여서 적용이 안된다 --> iter2이용
//			int avg = 68;
			int v = iter2.next();
			int num2= number.get(v);
		
			if(num2 > avg) {
				System.out.println(v+"학번 학생의 점수"+num2+"는 평균이상입니다");
				cnt++;
			}
			else {
				System.out.println(v+"학생의 점수는 평균이하 ");
			}
		}
		
		
		
		System.out.println(total);
		
//		int avg = total/7;
		System.out.println("평균은 : "+ avg);
		System.out.println("평균을 넘는 학생수 : " + cnt);
		System.out.println("평균을 넘는 전체학생수 중 비율 : " + (double)cnt / 8 *100+"%" );
		
//		if()
//		
		
//		while(student > 0) {
//			 
//			int v = st1[i];
//			
//			
//			
//			student--;
//		}
//		
//		
//		
//		
//		
//		
//		int cnt = 0;
//		
//		if(n > m) {
//			System.out.println("평균을 넘는 학생");
//			cnt++;
//		}
			
			
			
		// 7 100 95 80 60 70 70
		// 70.14 평균
		// 7 중 5 명 평균을 넘으므로 71.41
		
	}
}
