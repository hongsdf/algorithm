package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

// 문제 시간복잡도 초과
// long타입 구현 arr[][] = new long[1000000000][1000000000]; 3개가 존재 메모리 초과
public class JobDA2 {
	public static void main(String[] args) {
		Solve2 m = new Solve2();
		int n = 4;
		int x1[] = {2,3,5,1};
		int y1[] = {1,3,3,7};
		int x2[] = {4,5,7,3};
		int y2[] = {3,5,7,9};
		
//		
//		int x1[] = {10,20,40,10};
//		int y1[] = {100,40,60,10};
//		int x2[] = {50,50,90,30};
//		int y2[] = {110,60,90,40};
		
//		int x1[] = {10,20,40,10};
//		int y1[] = {10,40,60,100};
//		int x2[] = {30,50,90,50};
//		int y2[] = {40,60,90,110};
		
		int answer[] = m.solution(n, x1, y1, x2, y2);
		for(int a :answer) {
			System.out.print(a+" ");
		}
	}
}
class Solve2{
	public int arr[][] = new int[111][111]; // 1000000000
	public int gameboard[][] = new int[111][111]; // 1000000000
	public boolean visit[][] = new boolean[111][111]; 
	public int cnt = 0; // 섬지역 갯수 체크
	public HashSet<Integer> set = new HashSet<>();
	
	public int[] solution(int n, int x1[],int y1[],int x2[],int y2[]) {
		int answer[] = new int[n];
		
		// gameboard 배열을 하나 더 만든다.
		// 섬 영역별로 세팅한다.
		for(int i = 0; i <n; i++) {
			int row1 = 111 - x1[i];
			int row2 = 111 - x2[i];
			
			int col1 = y1[i];
			int col2 = y2[i];
			// gameboard 채우기
			for(int x = row2; x<row1; x++) {
				for(int y = col1; y<col2; y++) {
					gameboard[x][y] = i+1;
				}
			}
		}
		
		// 구현
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j <arr.length; j++) {
				if(!visit[i][j] && gameboard[i][j] != 0 ) {
					List<Integer> list = new ArrayList<>();
					int num = gameboard[i][j]; // 섬번호
					//cnt = 1;
					list.add(num);
					//set.add(num);
					dfs(i,j,num,list); // 연결된섬을 모두 연결 
					for(int number : list) {
						answer[number-1] = list.size();
					}
		
				}
				
			}
		}
		
		
		
		return answer;
	}


	private void dfs(int x, int y,int num,List<Integer> list) {
		// 탈출조건 범위를 초과하지 않고 방문했던 지점이면
		if(visit[x][y]) return;
		visit[x][y] = true;
		
		
		// 순환하다가 다른 섬이 나온다면
		if(num != gameboard[x][y]) {
			if(!set.contains(gameboard[x][y])) {
				set.add(num);
				list.add(gameboard[x][y]);
				num = gameboard[x][y]; // 넘버 교체
				//cnt++;
				
			}
		}
		
		
		if(x-1 >= 0 && gameboard[x-1][y] != 0 ) { // 상
			dfs(x-1,y,num,list);
		}
		if(x+1 < arr.length && gameboard[x+1][y] != 0 ) { // 하
			dfs(x+1,y,num,list);
		}
		if(y-1 >= 0 && gameboard[x][y - 1] != 0  ) { //  좌
			dfs(x,y-1,num,list);
		}
		if(y+1 < arr.length && gameboard[x][y+1] != 0 ) { // 우
			dfs(x,y+1,num,list);
		}
	}
}
