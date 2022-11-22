package al2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 전화번호목록{
	public static void main(String[] args) {
		String phone_book[] = {"12","88","1235","567","123"};
		boolean flag = false;
		Arrays.sort(phone_book);
		// Collections.reverse(Arrays.asList(phone_book));
		 
		
		for(int i = 0; i < phone_book.length-1 ; i++) {
			if(phone_book[i+1].startsWith(phone_book[i])) {
				flag = true;
				break;
			}
		}
		System.out.println(flag);
	}
}
