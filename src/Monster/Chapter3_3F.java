package Monster;

import java.io.*;
import java.lang.*;
import java.util.*;


public class Chapter3_3F {
	public static final Scanner scanner = new Scanner(System.in);


	/**
	 *
	 * @param n   카드의 수
	 * @param m   앨범을 구매한 팬의 수
	 * @param cards   각 카드에 적힌 숫자의 리스트 (cards[1] ~ card[n])
	 * @param ranges  각 팬이 선택한 범위의 리스트 (ranges[0] ~ ranges[m-1])
	 * @return        총 점수의 합이 가장 큰 범위 객체
	 */
	public static Range getBestRange(int n, int m, int[] cards, Range[] ranges) {
		Range answer = ranges[0];
		
		// 누적합:= 공간을 활용하면 시간복잡도를 줄 일 수 있다.
		// 누적합 배열 생성 := 1 ~ cards[i]까지 누적합 저장 배열
		long Rangsum[] = new long[n+1];
		
		// 누적합 배열 채워넣기
		for(int i =1; i<=n; i++){ // 1번부터하는 이유:= i-1 이런상황에 예외처리
			Rangsum[i] = Rangsum[i-1] + cards[i]; // i-1누적합 + card[i]
		}
		//누적합 완성
		// 팬들 순환
			for(Range r : ranges ){
				r.totalPoint = Rangsum[r.right] - Rangsum[r.left-1];
				if(answer.totalPoint < r.totalPoint){
					answer = r;
				}
			}


		return answer;
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] cards = new int[n+1];
		Range[] ranges = new Range[m];

		// 각 카드의 정보를 입력받는다.
		for(int i = 1 ; i <= n ; i ++)
		{
			cards[i] = scanner.nextInt();
		}

		// 팬들의 정보를 입력받는다.
		for(int i = 0 ; i < m; i ++)
		{
			int l = scanner.nextInt();
			int r = scanner.nextInt();
			ranges[i] = new Range(i + 1, l, r); // 팬 번호 1번부터
		}

		//범위의 합이 가장 큰 범위를 계산한다.
		Range answer = getBestRange(n, m, cards, ranges);

		System.out.printf("%d %d\n", answer.index, answer.totalPoint);
	}

}

class Range{
	int index; // 팬 번호
	int left;  // 왼쪽값
	int right; // 오른쪽 값
	long totalPoint; // 총합
	Range(int index, int left, int right)
	{
		this.index = index;
		this.left = left;
		this.right = right;
		this.totalPoint = 0;
	}
}