package algorithm;

public class No30 {
	/*아주 중요*/
	// 주요 요점 :
	//  방향 만드는 조건문
	
	
	// 2번으로 그리기
	static final int COlOR =2 ; // 상수
	static int size = 5; // map size
	
	static void color(int x, int y) {
		// 시작점이 1이 아닐경우 색칠
		if(map[x][y] != 1) {
			map[x][y] = COlOR;
		}
		// 왼쪽
		if(x-1 >= 0 && map[x-1][y] != 1 && map[x-1][y] != COlOR) {
			color(x-1,y);
		}// 오른쪽
		if(x+1 <size && map[x+1][y] !=1 && map[x+1][y] != COlOR) {
			color(x+1,y);
		}// 위쪽
		if(y-1 >= 0 && map[x][y-1] != 1 && map[x][y-1] != COlOR) {
			color(x,y-1);
		}// 아래쪽
		if(y+1 < size && map[x][y+1] !=1 && map[x][y+1] != COlOR) {
			color(x,y+1);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		for(int i=0; i < size; i++) {
			for(int j =0; j <size; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		color(0,0); // (0,0)시작위치 변환

		System.out.println("==================");
		
		for(int i=0; i < size; i++) {
			for(int j =0; j <size; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
/*정답: 
22222
22112
22221
22222
22122*/
	}
	static int [][]map= {{0,0,0,0,0},
			{0,0,1,1,0},
			{0,1,0,0,1},
			{0,0,0,0,0},
			{0,0,0,0,0}};
	
	
	
}
