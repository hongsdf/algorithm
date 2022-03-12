package backjun;


import java.util.Scanner;

public class Back2247 {
	static char[][] arr; // 필요한 재료들
	static void star(int x,int y,int n,boolean flag) {
		if(flag) {
			for(int i=x;i<x+n; i++) {
				for(int j=y; j<y+n; j++) {
					arr[x][y] = ' ';
				}
			}
			return;
		}
		
		
		
		if(n==1) {
			arr[x][y] = '*';
			return;
		}
		
		
		// 결국 한 1x1사이즈를 찾을때까지 재귀함수를 호출해야한다.
		// (0,0) (0,3) (0,6) --> (0,0) --> (0,0) (0,1) (0,2)
		// (3,0) (3,3) (3,6)               (1,0) (1,1) (1,2)
		// (6,0) (6,3) (6,6)               (2,0) (2,1) (2,2) ....
		
		int size = n/3; //한 구역당 사이즈 크기 size (3x3) -> (1x1) 점점 깊게 파고 들기
		int AreaCount = 0;
		for(int i =x; i <x+n; i+=size) {
			for(int j=y; j<y+n; j+=size) {
				AreaCount++;
				if(AreaCount == 5) {
					star(i,j,size,true);
				}else {
					star(i,j,size,false);
				}
			}
		}
	}
	
	
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	
	
	 arr = new char[n][n]; // 결과
	 star(0,0,n,false);
	 
	 StringBuilder ssb = new StringBuilder(); // StringBuilder란 문자열 객체를 생성해주는 변수
	 for(int i=0; i<n; i++) {
		 for(int j=0; j<n; j++) {
			 ssb.append(arr[i][j]);
		 }
		 ssb.append('\n');
	 }
	 System.out.println(ssb);
	 sc.close();
	 
	 
		
	}

}