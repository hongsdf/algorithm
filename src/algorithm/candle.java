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

class Resulta {

	/*
	 * Complete the 'birthdayCakeCandles' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * INTEGER_ARRAY candles as parameter.
	 */

	public static int birthdayCakeCandles(List<Integer> candles) {
		// Write your code here
		int answer = 0;
		int max = -1;
		for (int i = 0; i < candles.size(); i++) {
			max = Math.max(max, candles.get(i));
		}
		for (int i = 0; i < candles.size(); i++) {
			if (candles.get(i) == max)
				answer++;

		}
		return answer++;
	}
}

public class candle {
	public static void main(String[] args) throws IOException {
		List<Integer> candles = new ArrayList<>(Arrays.asList(4, 4, 5, 3, 3));
		int result = Resulta.birthdayCakeCandles(candles);
		System.out.println(result);
	}
}
