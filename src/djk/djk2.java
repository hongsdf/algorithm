package djk;

// 문제점 시간복잡도 o(n^2) 
// 그 이유: getSmallIndex() 함수에서 o(n)
// dijkstra() 안에 getSmallIndex()를 내장포함시켜놨기 때문에  o(n*n) == o(n^2)

public class djk2 {
	public static int num;
	public static int INF = 1000000000; // int 형은 양수형으로만 하였을때 21억까지가능
	public static boolean[] visited;
	public static int d[];
	public static int arr[][];
	public static void main(String[] args) {
		num = 6;
		arr = new int[][] {
		// 그래프 해석 방법
		// 특정 행(노드) 에 대해 연결과 (간선크기)를 적어놓은것
		
			{0,2,5,1,INF,INF}, //  1(행) 노드에 대해 다른 노드들의 간선크기를 표시 한것
			{2,0,3,2,INF,INF},
			{5,3,0,3,1,5},
			{1,2,3,0,1,INF},
			{INF,INF,1,1,0,2},
			{INF,INF,5,INF,2,0},
			
			
		};
		
		visited = new boolean[num]; //노드 방문여부 확인
		d = new int[num]; //최단 거리를 저장하기 위한 배열
		dijkstra(0);
		for(int i =0; i <d.length; i++) {
			System.out.print(d[i] + " ");
		}
		
	}
	private static int getSmallIndex() {
		int min = INF;
		int index = 0; // 가장 작은 값을 가지는 인덱스를 가져오기 위한 변수 생성
		for(int i=0 ; i <num; i++) {
			if(d[i] < min && !visited[i]) {
				min = d[i];
				index = i;
			}
		}
		return index; // 거리 배열중 가장 작은 간선을 가진 인덱스를 반환
		// 즉 가장 최소거리를 가지는 정점
		// 1노드에 대해 4번노드가 가장 가깝다
		// 그래서 4번 노드 리턴
	}
	public static void dijkstra(int start) {
		// d[i]를 채워야함
		for(int i =0; i<num; i++) {
			d[i] = arr[start][i]; // o o o o o o
		//  d[0] = arr[0][0];
		//  d[1] = arr[0][1];
		//  d[2] = arr[0][2];
			
		// 즉 start = 0 이라면
//			d[i]의 초기값은 0,2,5,1,INF,INF
		}
		visited[start] =true; // start 를 방문 체크
		for(int i =0; i<num -2; i++) { // 방문체크를 하게 되면 전체
			int current = getSmallIndex(); // d[i]중 가장 작은 간선을 가지는 [인덱스] : 0,2,5, [1] ,INF,INF 
			System.out.println("방문노드"+current);
			visited[current] = true;
			// 출발점에서 인접한 노드를 찾기 
			// ex) 4번노드는 1,2,3,5와 연결되어 있다 . 
			// 위에서 1번노드는 방문했기때문에 제외하고 
			// 나머지 2,3,5 인접노드를 살펴 볼것
			for(int j =0; j <6; j++) {
				if(!visited[j]) { // 방문하지 않는 노드이고
					 
				
				// 출발점에서 가는것보다 다른지점을 거처서 가는 것이 더 작다면
				if(d[current] + arr[current][j] < d[j]  ) {
				  // j : 1(즉 2번노드)
				  // 해석
				  // 1 +   {1,2,3,0,1,INF} 중 <  0,2,5,1,INF,INF 
				  // 처음 4번노드가 선정이되어  	
				  // 0,(2),5,[1],INF,INF  
				  // 1 +  4와 연결된 배열중 2번노드 : 2
				  // 1번노드에서 4번노드를 거쳐 2로 가면 1+2 : 3 크기 < 1번에서 바로 2번으로 가는 크기 : 2크기
				  // 즉 3 < 2 (갱신 x)
					
				    // 2번째
					// j : 2(즉 3번노드)
					// 1 +  4와 연결된 배열중 3번노드 : 
					// 1번노드에서 4번노드를 거쳐 3번노드로 가면 1+3 : 4 크기 < 1번에서 바로 3번노드으로 가는 크기 : 5 크기
					// 즉 4 < 5 (갱신 필요)
					
					// 3번째
					// j : 3(즉 4번노드) 자기자신
					
					// 4번째
					// j : 4(즉 5번노드)
					// 1번 노드에서 4번노드를 거쳐 5번노드로 가면 1 + 1 < 1번에서 5번으로 가는 크기 : INF
					// 2 < INF (갱신 필요)
					
					
					
				 
					d[j] = d[current] + arr[current][j];
				}
			}
		}
		
		}	
		
		
	}
}
