package algorithm;

public class 주식가격3 {
	public static void main(String[] args) {
		SolutioA2 m = new SolutioA2();
		int prices[] = {2,3,6,1,7};
		int[] result = m.solution(prices);
		for(int num : result) {
			System.out.printf("%d ",num);
		}
	}
}


