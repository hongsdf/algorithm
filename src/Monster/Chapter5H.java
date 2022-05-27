package Monster;

import java.io.*;
import java.lang.*;
import java.util.*;


public class Chapter5H {
	public static final Scanner scanner = new Scanner(System.in);
	public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int N = scanner.nextInt();

		// 각 <정수, 빈도수> 형태로 key-value를 저장할 Map 자료구조
		TreeMap<Integer, Integer> frequencyMap = new TreeMap<>();

		for(int i = 0 ; i < N; i+= 1){
			// frequencyMap := 이전에 입력된 정수들의 빈도수를 저장하고 있다.
			int X = scanner.nextInt();
			// HashMap은 초기화 필요하다
			if(!frequencyMap.containsKey(X)) {
				frequencyMap.put(X, 0);
			}
			int f = frequencyMap.get(X) + 1;
			frequencyMap.put(X, f);
			int num = frequencyMap.size();
			writer.write(String.format("%d %d\n",num,f));
		}

		writer.flush();
		writer.close();
	}

}
