package backjun;

import java.io.IOException;
import java.util.Scanner;

public class Back2941 {
	public static void main(String[] args) throws IOException {
//		String arr[] = {"ab","cd","de"};
//		String arr1[] = {"ab","ab"} ;
//		ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
//		List<String> list1 = Arrays.asList(arr1); // 배열 -> list로
//		
////		list1.add("02"); List는 크기변경 x
//		for(String str : list1) {
//			System.out.println(str);
//		}
//		
//		list.add("01"); // ARRAYlist는 크기 변경 유동적
//		list.set(0, "00");
//		System.out.println(list.get(0));
//		System.out.println(list.get(1));
//		System.out.println(list.get(2));
//		System.out.println(list.get(3)); 
//		
//		for(int i =0; i<arr.length; i++) {
//			System.out.println(arr[i]);
//		}
//		
//		
//		String arr[] = { "c=","c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		Scanner sc = new Scanner(System.in);
		// liabcnj = 7 -2
		String str = sc.next();
		int cnt = 0;
		for(int i = 0; i <str.length(); i++) {
				char c	=	str.charAt(i);
				if(c == 'c') {
					if(i < str.length()-1) {
					if(str.charAt(i+1) == '=' || str.charAt(i+1) == '-'){
						i++;
						}
					}
				}
				if(c == 's') {
					if(i < str.length()-1) {
					if(str.charAt(i+1) == '=' ){
						i++;						
					}
				}
			}
				
				if(c == 'd') {
					if(i < str.length()-1) {
				
					if(str.charAt(i+1) == '-'){
						i++;
						
					}
					else if(str.charAt(i+1) == 'z') {
						if(str.charAt(i+2) == '=') {
							i+=2;
							}
						}
					}
				}
				if(str.charAt(i) == 'n') {
					if(i < str.length()-1) {
					if(str.charAt(i+1) == 'j'){
						i++;
						
					}
				}
			}
				if(str.charAt(i) == 'l') {
					if(i < str.length()-1) {
					if(str.charAt(i+1) == 'j'){
						i++;
						
					}
				}
				}
				if(str.charAt(i) == 'z') {
					if(i < str.length()-1) {
					if(str.charAt(i+1) == '='){
						i++;
						
					}
				}	
			
			}
			cnt++;
		
		}
		System.out.println(cnt);
	}
}
