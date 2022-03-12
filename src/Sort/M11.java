package Sort;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Stringcompar3 implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// 문자열 길이가 같지 않을때 비교 
		if(o1.length() != o2.length()) {
			return o1.length() - o2.length();
		}else { // 문자열 길이가 같을때
			for(int i =0; i <o1.length() ; i++) {
				if(o1.charAt(i) != o2.charAt(i) ) return o1.charAt(i) - o2.charAt(i);
			}
		}
		
		return 0;
	}

}

class Result2 {

	static List<String> bigSorting(List<String> unsorted) {
		Collections.sort(unsorted, new Stringcompar3());
		System.out.println(unsorted);
		return unsorted;
	}

}

public class M11 {
	public static void main(String[] args) throws IOException {
		Result2 r = new Result2();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<String> list = new ArrayList<String>();
		while (n-- > 0) {
			list.add(sc.next());

		}
//    	System.out.println(list);
		System.out.println((r.bigSorting(list)));
	}
}
