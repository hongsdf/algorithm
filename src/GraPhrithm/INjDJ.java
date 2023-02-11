package GraPhrithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 인접리스트
class Adj {
	ArrayList<ArrayList<Integer>> adj;
	int nodeCount;
	public Adj(int nodeCount) {
		this.adj = new ArrayList<ArrayList<Integer>>();
		this.nodeCount = nodeCount;
		
	for(int i = 1; i <=nodeCount; i++) {
		this.adj.add(new ArrayList<Integer>());
	}
}
	
	// 인접 리스트 연결
	public void addEdge(int n1, int n2) {
		this.adj.get(n1).add(n2);
		this.adj.get(n2).add(n1);
		
		
	}
	// 인접리스트 행 반환
	public ArrayList<Integer> getList(int i){
		return this.adj.get(i);
	}
	// 인접리스트 추가기능
	public void addList(int x) {
		
	}
	
	// 인접리스트 사이즈 반환
	public int sizeList() {
		return this.adj.size();
	}
	
	
}

public class INjDJ{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Adj adj = new Adj(n+1);
		for(int i = 0; i <n; i++) {
			String str[] = br.readLine().split(" ");
			int N1 = Integer.parseInt(str[0]);
			int N2 = Integer.parseInt(str[1]);
			adj.addEdge(N1, N2);
			
			
		}
		
		
	}
}
