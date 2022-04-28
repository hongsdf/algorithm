package algorithm;

import java.io.*;
import java.lang.*;
import java.util.*;

// -10,000 ~ 10,000
public class t1 {
	public static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args)
	{
		int n = scanner.nextInt();
		Point2D[] points = new Point2D[n];

		for(int i = 0 ; i < n ; i++)
		{
			int x=  scanner.nextInt();
			int y=  scanner.nextInt();
			points[i] = new Point2D(x, y);
		}
		
		
		// 두개의쌍들중 최소거리저장
		int answer = Integer.MAX_VALUE;
		int cnt = 0; //최소거리랑 같은 쌍들 갯수
		for(int i = 0; i<n; i++){ // 0 ~ n-1
			// 두개의 쌍을 탐색할때 방법 이중 반복문
			for(int j = 0; j<i; j++){
				//< i ,j >조합 i := 0~n-1 , j := j< i
				int dist = points[i].getSquaredDistanceTo(points[j]); // 두쌍의 거리를 측정하는 메서드실행
				if(dist < answer){
					answer = dist; //최소 거리 갱신
					cnt = 1; // 처음 최소거리가 발견되면 1개 -> 다음 최소거리가 나오면 cnt을 초기화 1로
				}else if(dist == answer){
					cnt+=1; //최소 거리랑 같은 쌍이 또 존재 할경우
				}
			}
			
		}
		System.out.printf("%.1f\n",Math.sqrt(answer));
		System.out.printf("%d",cnt);

		
	}
}

class Point2D{
	int x;
	int y;
	public Point2D(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * 2차원 평면 상에서 점 this부터 점 target까지 거리의 제곱을 계산하는 함수
	 * @param target
	 * @return
	 */
	public int getSquaredDistanceTo(Point2D target)
	{
		// this는 어떤한 값들어 왔을때 비교를 하는것
		// 기존 vs 새로운것
		
		// this점과 target의 x 좌표 차이길이
		int deltax = this.x-target.x;
		// this점과 target의 y 좌표 차이길이
		int deltay = this.y-target.y;
		return (deltax*deltax) +(deltay * deltay);
		

	}

	public double getDistanceTo(Point2D target)
	{
		return Math.sqrt(this.getSquaredDistanceTo(target));
	}

}

