package Monster;

import java.io.*;
import java.lang.*;
import java.util.*;

public class 문제08B그래프의탐색2 {
	public static List<Integer> dfsList = new ArrayList<>();
	public static List<Integer> bfsList = new ArrayList<>();
	public static Adj adj;
	public static void main(String args[]) throws IOException{
		// o(M) // 시간 복잡도
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]); 
		int M = Integer.parseInt(input[1]); 
		
		adj = new Adj(N+1);
		
		boolean dfsvisit[] = new boolean[N+1];
		boolean bfsvisit[] = new boolean[N+1];
		
		for(int i = 0; i <M; i++){
			String str[] = br.readLine().split(" ");
			int u = Integer.parseInt(str[0]);
			int v = Integer.parseInt(str[1]);
			
			adj.addEdge(u,v); // 양방향 연결
			
		}
		dfs(1,dfsvisit);
		bfs(1,bfsvisit);
		for(int i = 0; i <dfsList.size(); i++){
				if(i == dfsList.size()-1){
					bw.write(dfsList.get(i)+"\n");
				}else{
					bw.write(dfsList.get(i)+"-");
				}
		}
		
		// dfs
		
		// bfs
		for(int i = 0; i <bfsList.size(); i++){
				if(i == bfsList.size()-1){
					bw.write(bfsList.get(i)+"\n");
				}else{
					bw.write(bfsList.get(i)+"-");
				}
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
	public static void dfs(int start,boolean visit[]){
		if(visit[start]) return;
		visit[start] = true;
		dfsList.add(start);
		
		List<Integer> list = adj.getList(start);
		Collections.sort(list);
		for(int target : list){
			if(!visit[target]){
				dfs(target,visit);
			}
		}
		
	}
	
	public static void bfs(int start,boolean visit[]){
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()){
			int curr = q.poll();
			if(visit[curr]) continue;
			visit[curr] = true;
			bfsList.add(curr);
			
			List<Integer> list = adj.getList(curr);
			for(int target : list){
				if(!visit[target]){
					q.add(target);
				}
			}
		}
	}
}
class Adj{
	ArrayList<ArrayList<Integer>> list;
	int n;
	
	public Adj(int n){
		this.list = new ArrayList<ArrayList<Integer>>();
		this.n = n;
		
		for(int i= 1; i <=n; i++){
			this.list.add(new ArrayList<Integer>());
		}
	}
	
	// 연결
	public void addEdge(int a, int b){
		this.list.get(a).add(b);
		this.list.get(b).add(a);
	}
	
	public ArrayList<Integer> getList(int a){
		return this.list.get(a);
	}
	
}