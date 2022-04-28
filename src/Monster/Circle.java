package Monster;

import java.io.*;
import java.lang.*;
import java.util.*;


public class Circle {
	public static final Scanner scanner = new Scanner(System.in);

	/**
	 * 왼쪽 아래 좌표가 (x,y)인 픽셀이 반지름 R인 원에 포함되는가?
	 * @param x
	 * @param y
	 * @param R
	 * @return  포함된다면 true, else false
	 */
	public static boolean isInside(long x, long y, long R)
	{
		// 좌표한칸의 기준 만들기 := 왼쪽 아래 점
		long d = x*x +y*y;
		if(d < R*R){
			return true;
		}
		return false;
	}

	public static void testCase(int caseIndex) {
		long R = scanner.nextLong();
		long cnt = 0;
		long j = R; // j:= 변하지 않는다.
	   // 3번째 방식
		// 직사각형으로 1길이로 생각하고, 위에 내려오면 break
		for(int i = 0; i<=R; i++){
			for(; j>= 0; j--){ // j감소하는 경우 := 밑에 if절을 통과하지않을때만 j--가 실행된다.
				// j := 위에 변수로 선언하여 공통변수가 되었다. j --> 0 으로 수렴할때까지만 실행(값을 가지고 실행)
				if(isInside(i,j,R)){
					 //이때 높이 저장
					long height = j+1; // y좌표 +1
					cnt += height;
					break; // break을 만나야 j가 감소 된다.
				}
				
			}
		}
		
		
		
		System.out.printf("#%d\n", caseIndex);
		System.out.println(cnt*4);
	}

	public static void main(String[] args) throws Exception {
		int caseSize = scanner.nextInt();

		for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
			testCase(caseIndex);
		}
	}

}

