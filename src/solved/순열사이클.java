package solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class Adj1{
	ArrayList<ArrayList<Integer>> list;
	int n;
	
	public Adj1(int n) {
		this.list = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i <n;i++) {
			this.list.add(new ArrayList<Integer>());
		}
	}
	// 단방향 연결
	public void addEdge(int a, int b) {
		this.list.get(a).add(b);
	}
	// 리스트 반환
	public ArrayList<Integer> getList(int i){
		return this.list.get(i);
	}
}
public class 순열사이클 {
	public static boolean visit[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
			int answer = 0;
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N+1];
			Adj1 adj1 = new Adj1(N+1);
			boolean visit[] = new boolean[N+1];
			String str[] = br.readLine().split(" ");
			for(int i = 1; i <=N; i++) {
				arr[i] = Integer.parseInt(str[i-1]);
				adj1.addEdge(i, arr[i]);
			}
			// 0,1,2,3,4,5,6,7,8
			//   3 2 1
			// 로직 구현
			for(int i = 1; i <=N; i++) {
				if(!visit[i]) {
					dfs(adj1,i,visit); // i와 연결된 사이클 순회
					answer++;			
				}
			}
			bw.write(answer + "\n");
			// System.out.println(answer);
		
			
		}
		bw.flush();
		br.close();
		bw.close();
	}

	private static void dfs(Adj1 adj1, int i,boolean visit[]) {
//		if(visit[i]) return true;
		visit[i] = true;
		
		ArrayList<Integer> list = adj1.getList(i); // i와 연결된 지점 체크
		for(int a : list) {
			if(!visit[a]) {
				dfs(adj1,a,visit );
			}
		}
		
		
		
	}
}
