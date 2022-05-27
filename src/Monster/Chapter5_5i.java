package Monster;

import java.lang.*;
import java.util.*;
import java.io.*;


public class Chapter5_5i {
	public static final Scanner scanner = new Scanner(System.in);

	public static long getMaximumSquareArea(int n, Point2D[] points) {
		long answer = 0;

		TreeSet<Point2D> Tset = new TreeSet<>();
		//모든 점 삽입
		for(Point2D p : points) {
			Tset.add(p);
		}
		// 탐색
		for(Point2D p1 : points) {
			for(Point2D p2 : points) {
				long area = p1.getSquaredDistanceTo(p2); // 두점을 가지고 가상의 넓이를 생성
				
				if(area < answer) {
					continue; //가상의 넒이가 작다면 스킵
				}
				
				// x좌표 차이
				int dx = p1.x - p2.x;
				
				// y좌표 차이
				int dy = p1.y - p2.y;
				
				// 새로운 p3,p4 찾기
				// 벡터 성질이 적용된다.  => <a,b> 수직이면 <b,-a> || <-b,a>
				Point2D p3 = new Point2D(p1.x-dy, p1.y + dx);
				Point2D p4 = new Point2D(p2.x-dy, p2.y + dx);
				
				// 그리고 Tset안에 p3,p4점이 진짜 있다면 최대 면적을 갱신한다.
				if(Tset.contains(p3) && Tset.contains(p4)) {
				 answer = Math.max(answer, area);
				}
				
			}
		}
		


		return answer;
	}

	public static void testCase(int caseIndex) {
		int n = scanner.nextInt();

		Point2D[] points = new Point2D[n];

		for (int i = 0; i < n; i += 1) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			points[i] = new Point2D(i, x, y);
		}

		long answer = getMaximumSquareArea(n, points);

		System.out.printf("%.2f\n", (double) answer);
	}

	public static void main(String[] args) throws Exception {
		int caseSize = scanner.nextInt();

		for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
			testCase(caseIndex);
		}
	}

}

class Point2D implements Comparable<Point2D> {
	// treeSet 구현 => 순서가 있다=> bst트리기반으로 형성되어있다 O(lg N)
	public int x;
	public int y;
	public int index;
	
	Point2D(int index, int x, int y){
		this.index = index;
		this.x = x;
		this.y = y;
		
	}
	// 넓이 구하는 함수
	public long getSquaredDistanceTo(Point2D target) {
		long dx = Math.abs(this.x - target.x);
		long dy = Math.abs(this.y - target.y);
		return dx * dx + dy * dy;
	}
	public double getDistanceTo(Point2D target) {
		// 두 좌표간의 실수 거리를 계산
		long sqd = this.getSquaredDistanceTo(target);
		return Math.sqrt(sqd);
	}
	
	
	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
		
	}

	@Override
	public int compareTo(Point2D o) {
		if(this.x == o.x) {
			return this.y - o.y;
		}
		return this.x - o.x;
	}
}