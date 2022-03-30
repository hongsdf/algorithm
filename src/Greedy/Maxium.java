package Greedy;

import java.util.ArrayList;
import java.util.List;

public class Maxium {

}

class Result {

	/*
	 * Complete the 'maximumPerimeterTriangle' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * INTEGER_ARRAY sticks as parameter.
	 */

	public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
		int max = 0;
		List<Integer> temp = new ArrayList<>();
		for (int i = 0; i < sticks.size() - 3; i++) {
			int sum = 0;
			List<Integer> a = sticks.subList(i, i + 4);
			if (a.get(0) + a.get(1) < a.get(2)) {
				temp.add(-1);
				return temp;
			} else {
				sum += a.get(0);
				sum += a.get(1);
				sum += a.get(2);
				if(sum > max) {
					max = sum;
					temp.add(a.get(0));
					temp.add(a.get(1));
					temp.add(a.get(2));
					
				}
				
			}

		}

		return temp;
	}

}