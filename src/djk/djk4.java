package djk;
// 다익스트라 예제
// 1. 한 지점과 모든 지점과의 최단 거리연결
// 2. 모든 지점과 다른 모든 지점과의 최단거리연결

// 구현 방법
// 1 2차원 배열
// 2 우선순위큐로 구현

public class djk4 {
	public static int arr[][];
	public static int INF;
	public static int num;
	public static int d[];
	public static boolean visited[];
	
	public static void main(String[] args) {
		INF = 987654321;
		num = 6;
		d = new int[num];
		visited = new boolean[num];
		
		arr = new int[][] { 
				{ 0, 2, 5, 1, INF, INF }, // 1(행) 노드에 대해 다른 노드들의 간선크기를 표시 한것
				{ 2, 0, 3, 2, INF, INF },
				{ 5, 3, 0, 3, 1, 5 },
				{ 1, 2, 3, 0, 1, INF },
				{ INF, INF, 1, 1, 0, 2 },
				{ INF, INF, 5, INF, 2, 0 },

		};
		
		djiktra(0);
		
		for(int i = 0 ; i < num; i++) {
			System.out.print(d[i]+ " ");
		}
		
	}
	private static void djiktra(int start) {
		for(int i = 0; i <num; i++) {
			d[i] = arr[start][i];
		// d[0] = arr[0][0]
		// d[1] = arr[0][1]
		// d[2] = arr[0][2]
			
		}
		visited[start] = true;
		for(int i =0; i < num-1; i++) {
			int curr = getsmall();
			visited[curr] = true;
			for(int j = 0; j <num; j++) {
				// i->curr + curr->j < i->j 
				// (출발지점-> 중간지점 + 중간지점 -> 도착지점) < (출발지점 -> 도착지점)
				if(!visited[j]) {
					if(d[curr]+ arr[curr][j] < d[j] ) {
						
						d[j] = d[curr] + arr[curr][j] ;
					}
				}
			}
		}
	}
	
	
	private static int getsmall() {
		int min = INF;
		int idx = 0;
		for(int i =0 ; i <num; i++) {
			if(d[i] < min && !visited[i]) {
				min = d[i];
				idx = i;
			}
		}
		return idx;
	}
}