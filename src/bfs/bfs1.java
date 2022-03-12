package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class bfs1 {
	public static int board[][] = new int[10][10];
	public static boolean visited[] = new boolean[10];

	public static void main(String[] args) {
		int n = 7;
		int e = 8;

		board[1][2] = board[2][1] = 1;
		board[1][3] = board[3][1] = 1;

		board[2][4] = board[4][2] = 1;
		board[2][5] = board[5][2] = 1;

		board[3][6] = board[6][3] = 1;
		board[3][7] = board[7][3] = 1;

		bfs(1);
	}

	private static void bfs(int startnode) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(startnode);
//		visited[startnode] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();
			if (visited[curr])  continue; //체크 되어있는 노드는 뛰어 넘어라
			visited[curr] = true; // 노드 체크
			System.out.print(curr + " ");

			for (int i = 0; i < 8; i++) {
				if (!visited[i] && board[curr][i] != 0) {
					q.add(i);
				}
			}
			System.out.println("라운드");
		//  2 3 
		//    3 4 5
		//      4 5 6 7
	    //        4
		}
	}
}
