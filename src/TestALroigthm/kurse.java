package TestALroigthm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Edge{
	int node[] = new int[2];
	int distance;
	Edge(int a, int b, int distance){
		this.node[0] = a;
		this.node[1] = b;
		this.distance = distance;
	}
	
	
}
class Comparedist implements Comparator<Edge>{

	@Override
	public int compare(Edge o1, Edge o2) {
		if(o1.distance > o2.distance) {
			return 1;
		}
		else return 0;
	}
	
}



// 최소 비용으로 최소 신장 트리 만들기 : 최단 연결
public class kurse {
	static int n = 7;
	static int parent[] = new int[8];
//	static int n = (int)(Math.random()* 10);
	public static void union(int parent[], int a, int b) {
		a = getParent(parent,a);
		b = getParent(parent,b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
		 
	}
	
	
	public static int getParent(int[] parent, int a) {
		if(parent[a] == a) return a;
		return parent[a] = getParent(parent,parent[a]);
	}


	public static void main(String[] args) {
//		n = 7;
		int m =11;
		
		for(int i= 0; i <parent.length; i++) {
//			int n = (int)(Math.random()*10);
			parent[i] = i;
//			parent[i] = i+101;
//			parent[i] = i;
		}
		for(int i = 0; i <parent.length; i++) {
			System.out.print(parent[i]+" ");
		}
		
		List<Edge> temp = new ArrayList<>();
//		int temp[Edge];  
//		
		temp.add(new Edge(1,7,12));
		temp.add(new Edge(1,4,28));
		temp.add(new Edge(1,2,67));
		temp.add(new Edge(1,5,17));
		temp.add(new Edge(2,4,24));
		temp.add(new Edge(2,5,62));
		temp.add(new Edge(3,5,20));
		temp.add(new Edge(3,6,37));
		temp.add(new Edge(4,7,13));
		temp.add(new Edge(5,6,45));
		temp.add(new Edge(5,7,73));
		
		Collections.sort(temp,new Comparedist());
		
		int sum = 0;
		for(int i =0; i<m; i++) {
			if(same(parent,temp.get(i).node[0]-1 , temp.get(i).node[1]-1 ) == 0) {
				sum += temp.get(i).distance;
				union(parent, temp.get(i).node[0] -1, temp.get(i).node[1] -1);
			}
		}
		
//		if (find(graph[i][0] - 1) != find(graph[i][1] - 1)) {
//			System.out.println("<선택된 간선>");
//			System.out.println(Arrays.toString(graph[i]));
//			union(graph[i][0] - 1, graph[i][1] - 1);
//			final_cost += graph[i][2];
//			System.out.println("<각 노드가 가리키고 있는 부모>");
//			System.out.println(Arrays.toString(parent) + "\n");
//			continue;
//		}
		
		
		
		System.out.println(sum);
	}


	public static int same(int[] parent2, int i, int j) {
		i = getParent(parent, i);
		j = getParent(parent, j);
		if(i == j) return 1;
		else return 0;
	}
	
	
}
