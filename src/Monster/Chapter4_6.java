package Monster;


import java.io.*;
import java.lang.*;
import java.util.*;

// 문제 
// 순환주기가 다른 한쌍의 페어
// <x,y>는 서로 주기가 다르다.
public class Chapter4_6 {
	public static final Scanner scanner = new Scanner(System.in);

	public static void testCase(int caseIndex) {
		int M = scanner.nextInt();
		int N = scanner.nextInt();
		int x = scanner.nextInt();
		int y = scanner.nextInt();

		// <1,1> ~ <M, N> 연도를 표현하는 카잉 달력을 생성한다
		KaingCalendar calendar = new KaingCalendar(M, N);

		// 이 달력에서 <x, y>가 몇 번째 연도인지 계산한다
		int answer = calendar.getIndex(x, y);

		// 정답을 출력한다
		System.out.println(answer);
	}

	public static void main(String[] args) throws Exception {
		int caseSize = scanner.nextInt();

		for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
			testCase(caseIndex);
		}
	}

}

class KaingCalendar
{
	final int M;    // 왼쪽 번호의 최대 값
	final int N;    // 오른쪽 번호의 최대 값

	KaingCalendar(int M, int N)
	{
		this.M   = M;
		this.N   = N;
	}

	/**
	 * 'index'번째 날짜의 X(왼쪽 번호)를 반환하는 함수
	 *
	 * @param index
	 * @return
	 */
	public int getXbyIndex(int index)
	{
		int numX = (index - 1 )%M +1;
		return numX;
	}

	/**
	 * 'index'번째 날짜의 Y(오른쪽 번호)를 반환하는 함수
	 *
	 * @param index
	 * @return
	 */
	public int getYByIndex(int index)
	{
		int numY = (index-1) %N +1;
		return numY;
	}

	/**
	 *
	 *
	 * @param x
	 * @param y
	 * @return  이 달력에서 <x, y>라는 연도가 최초로 등장하는 순번
	 *          등장하지 않는 연도라면 -1을 반환한다
	 */
	public int getIndex(int x, int y)
	{
//		// native
//		for(int i = 1; i<= M * N; i+=1 ){
//			if(getXbyIndex(i) == x && getYByIndex(i) == y){
//				return i; // 날짜를 찾았다.
//			}
//		}
//		return -1; //해당 날짜는 없다.
		
		// 최적화
		// 하나의 값 x를 고정시켜두고 탐색한다.
		//그리고 M씩 건너 뛰며 탐색한다.
		// 모든 경우의 수안에서 x를 기준으로 += M씩 탐색하여도 모든 y의 종류에 매핑 될 수 있다.
		// ex
		// M : 1,2
		// N : 1,2,3
		// <1,1>  
		// <2,2>
		// <1,3>
		// <2,1>
		// <1,2>
		// <2,3> 
		// <1,1> -- 다시 같아지는 시점은 배수 단위,   배수 단위안에서 x가 1일때 y= 1,2,3의 종류를 다 만난다.
		//   :

		for(int i = x; i<= M * N; i+=M) {
			if( getXbyIndex(i) == y) {
				return i;
			}
		}
		return -1;
		
		
	}
}