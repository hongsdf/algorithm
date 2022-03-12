package TestALroigthm;

// 서로 같은 노드 있는지 확인 same
// 부모 찾기 getParent
// 같은 노드이면 작은 노드가 부모해서 노드 연결 unioin
// 용어 정리 : 
//노드 : 지점,거점,도시
//간선 : 선, 거리 ,길
public class unioin {
	static int dist[] = new int[8];
	
	
	public static void main(String[] args) {
		for(int i =0; i <dist.length; i++) {
			dist[i] = i+1;
		}
//		for(int i =0; i <dist.length; i++) {
//			System.out.println(dist[i]);
//		}
		uni(dist,1,2);
		uni(dist,3,4);
		uni(dist,5,4);
		uni(dist,6,7);
	
		same(dist,4,2);
	}


	private static void uni(int[] dist, int i, int j) {
		// TODO Auto-generated method stub
		i = getParent(dist,i);
		j = getParent(dist,j);
		if(i < j) dist[j] = i; // dist[j] --> i
		else dist[i] = j; // dist[i] -- >j
	}


	private static int getParent(int[] dist, int i) {
		
		
		
		
		if(dist[i] == i+1) return i;
		// 처음 세팅
		// 0 1 2 3 4 5 6 7
		// 1 2 3 4 5 6 7 8
		
//		여기서 0노드와 1번 노드를 연결

		// 0 1 
		// 1 0 
		
//		이런 형태 자식 노드의 값은 부모 노드 번호를 가르킴
		
		
		return dist[i] = getParent(dist, dist[i]);
		// dist[1]  = 
		
		
	}
	public static void same(int dist[], int a, int b) {
		a = getParent(dist, a);
		b = getParent(dist, b);
		if(a == b ) System.out.println("같은 부모");
		else System.out.println("두 노드는 다른 가지이다");
	}
	
}
