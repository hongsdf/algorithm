package djk;
// 모든 지점에서 다른 모든 지점까지 최단거리연결
// 2차원 배열 사용
// 3중 for문을 사용 : 중간지점, 출발지점, 도착지점
// 특징 : arr[1][2] != arr[2][1] 거리가 같지 않아도 사용이 가능하다 즉) 가는 거리와 오는 거리가 다를 때도 사용가능 
 
public class Floyd {
	public static int arr[][]; // 정답 2차원배열
	public static int num;
	public static int INF;
	public static int board[][];
	public static void main(String[] args) {
		num = 4;
		INF = 1000000000;
		board = new int[][] {
			{0,5,INF,8},
			{7,0,9,INF},
			{2,INF,0,4},
			{INF,INF,3,0}	
		};
		floyd();
		
		
	}

	private static void floyd() {
		arr = new int[num][num];
		for(int i = 0 ; i <num; i++) {
			for(int j = 0; j <num; j++) {
				arr[i][j] = board[i][j];
			}
		}
		
		// k : 중간노드를 거쳐가는 노드
		for(int k = 0; k <num; k++) {
			// i : 출발 지점
			for(int i =0; i <num; i++) {
				// j : 도착 지점
				for(int j =0; j <num; j++) {
					// arr[i][j] : i(출발지점) -> j(도착지점) >  i(출발지점) -> k(중간지점) + k(중간지점) -> j(도착지점)
					if(arr[i][j] > arr[i][k] + arr[k][j]) {
						
						arr[i][j] = arr[i][k] + arr[k][j];
						
					}
				}
			}
		}
		
		for(int i =0; i <num; i++) {
			for(int j =0; j<num; j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
	}
}
