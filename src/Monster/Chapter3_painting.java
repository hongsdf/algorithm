package Monster;

import java.io.*;
import java.lang.*;
import java.util.*;


public class Chapter3_painting {
	public static final Scanner scanner = new Scanner(System.in);
	public static final int MAX_SEAT_NUMBER = 1000;
	public static final int MAX_COLOR_NUMBER = 100;

	/**
	 *
	 * @param n : 좌석의 수. 좌석은 0~(n-1)번의 번호를 가진다.
	 * @param m : 좌석을 칠한 횟수.
	 * @param paintings  : 좌석들을 색칠한 이벤트들의 정보
	 */
	public static void solve(int n, int m, Painting[] paintings)
	{
		int[] seats = new int[n]; //seats[i] := i번 좌석의 최종 색상

		
//		int minIdx = 0;
//		int maxIdx = 0;
		
		for(Painting temp : paintings){
			int left = temp.left;
			int right = temp.right;
			int color = temp.color;
			for(int i = left ; i <=right; i++){
				seats[i] = color;
			}
		}
		// 좌석을 색칠로 다 완성하였다.
		
		// 같은 색깔 갯수 세기
		int color[] = new int[n];
//		for(int i = 0; i<n; i++) {
//			color[i] = -1;
//			
//		}
		/*빈도수 문제에서는 따로 배열을 만들어 사용한다
		  장점 :  시간복잡도를 공간으로 대체하여 줄일 수 있다.
		 */
		
		for(int i = 0; i<n; i++){
			color[seats[i]]++; // 빨강색깔 수 ++
		}
		
		
		// 색깔수를 다 셋의면 최소값, 최대값

		// 테크닉
		int minColor = -1; //가장 적게 등장한 색상
		int maxColor = -1; //가장 많이 등장한 색상
		
		for(int i = 0; i<color.length; i++) {
			if(color[i] == 0) continue;
			
			if(minColor == -1 || color[i] < color[minColor]) {
				minColor = i;
			}
			
			if(maxColor == -1 || color[i] > color[maxColor]) {
				maxColor = i;
			}
		}

		
		
		
		System.out.println(maxColor);
		System.out.println(minColor);
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt(); // 좌석 수
		int m = scanner.nextInt(); // 색칠 수

		//paintings[i] := i번째에 일어난 색칠 이벤트의 정보
		Painting[] paintings = new Painting[m];


		for(int i = 0 ; i < m ; i ++)
		{
			//좌석의 번호는 1번부터 시작하므로, 0 ~ (n-1)범위로 맞추기 위하여 1씩 빼준다
			int left = scanner.nextInt()  -1;
			int right = scanner.nextInt() -1;
			int color = scanner.nextInt();
			paintings[i] = new Painting(left, right, color);
		}

		//문제의 정답을 구한다
		solve(n, m, paintings);
	}

}

//좌석들을 한 번 색칠하는 이벤트에 대한 정보
class Painting{
	public int left;
	public int right;
	public int color;
	Painting(int left, int right, int color)
	{
		this.left = left;
		this.right = right;
		this.color = color;
	}
}