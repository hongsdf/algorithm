package Sort;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class comparator2 {
	public static void main(String[] args) {
		// 2차원 배열 comparator로 정렬하기 연습
		String [][] str = { {"무한도전", "노홍철"}, {"무한도전", "노홍칠"}, {"놀러와", "유재석"}, {"무한도전", "하하"}, {"놀러와", "노홍철"}};
		System.out.println("정렬전");
		
//		for(int i =0; i<str.length; i++) {
//			List<String> nstr = Arrays.asList(str[i]); //Arrays : 배열,문자열의 타입을 매개변수 받아list형으로반환
//			for(String s:nstr) {
//				System.out.println(s);
//			}
//			
//		}
		
		for(int i =0; i<str.length; i++) {
			System.out.println(Arrays.asList(str[i])) ;
		}
		
		Arrays.sort(str,new Comparator<String[]>() { // Arrays.sort(정렬할 배열, 정렬기준을 만들수도 있다 )

			@Override
			public int compare(String[] str1, String[] str2) {
				if(str1[0].toString().contentEquals(str2[0].toString())) { // 2차원배열 에서 첫번째 원소가 같으면
					return str1[1].toString().compareTo(str2[1].toString()); // 두번째 원소를 비교한다
					// str[1].toString.compareTo(Str[1].toString()) 결과가 음수이면 내림차순 , 양수이면 오름차순
				}else {
					return str1[0].toString().compareTo(str2[0].toString());
				}
				
				
			}
			
			
			
			
		});
		System.out.println("정렬후 ");
		for(int i =0; i<str.length; i++) {
			System.out.println(Arrays.asList(str[i]));
		}
		
		
//		for(int i=0; i<str.length; i++) {
//			for(int j=0; j<str[i].length; j++) {
//				System.out.print(str[i][j]);
//			}
//			System.out.println();
//		}
		
		
		
	}
}
