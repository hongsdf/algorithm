package DFS;
//package DFS;
//
//import java.util.Scanner;
//
//public class DFS {
//	public static int size = 10;
//	public static int board[][] = new int[size][size];
//	public static int N,E;
//	public static boolean visited[] = new boolean[size]; // 왜 size?
//	
//	public static void DFS(int node) {
//		visited[node] = true;
//		System.out.print(node);
//		
//		for(int n = 0; n <N; n++) {
//			if(!visited[n] && board[node][n] !=0 ) {
//				DFS(n);
//			}
//		}
//	}
//	
//	
//	public static void main(Strings[] args) {
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt(); // 노드의 갯수
//		E = sc.nextInt(); // 간선의 수
//		for(int i =0; i<E; i++) {
//			int v = sc.nextInt();
//			int u = sc.nextInt();
//			board[v][u] = board[u][v] = 1;
//		}
//		DFS(0);
//		sc.close();
//	}
//}
