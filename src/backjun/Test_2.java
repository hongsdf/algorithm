package backjun;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class Test_2 {

	public static void main(String[] args) {
		// Map 선언
		Map<Integer, String> testMap = new HashMap<Integer, String>();
 
		// Map에 데이터 추가
		testMap.put( 1, "apple");
		testMap.put( 4, "pineapple");
		testMap.put( 2, "orange");
		testMap.put( 5, "strawberry");
		testMap.put( 3, "melon");

		// 키로 정렬
		Object[] mapkey = testMap.keySet().toArray();
		Arrays.sort(mapkey);

		// 결과 출력
		for (Integer nKey : testMap.keySet())
		{
			System.out.println(testMap.get(nKey));
		}
	}

}