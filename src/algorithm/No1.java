package algorithm;

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

class Res1 {

	/*
	 * Complete the 'miniMaxSum' function below.
	 *
	 * The function accepts INTEGER_ARRAY arr as parameter.
	 */

	public static void miniMaxSum(List<BigInteger> arr) {
		// Write your code here
		BigInteger result1 = new BigInteger("");
		BigInteger result2 = new BigInteger("");

		Collections.sort(arr);
		for (int i = 0; i < arr.size() - 1; i++) {
			result1.add(arr.get(i));
		}
		for (int i = 1; i < arr.size(); i++) {
			result2.add(arr.get(i));
		}
		System.out.print(result1 + " " + result2);

	}

}

public class No1 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		long sum = 0;
		long max = 0;
		long min = 1000000000;
		while(sc.hasNext()) { // hasNext() : 입력끝까지 받는다 정지 버튼 누르기 전 까지
			Long n = sc.nextLong();
			// 핵심 알고리즘 개념 : 전체 요소 중 하나(가장 큰값, 가장 작은 값)만 거르기 *전체 - 값 = 원하는 값
			sum += n ; // 전체 만들기
			if(min > n) { // 값 만들기
				min = n;
			}
			if(max < n) { // 값 만들기
				max = n;
			}
		}
		// 핵심  result2 = 전체 - 가장 작은 값 하나
		// result1 = 전체 - 가장 큰 값 
		System.out.print((sum-max) +" "+(sum-min));
		sc.close();
		
		
	}

}
