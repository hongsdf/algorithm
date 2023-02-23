package algorithm;

import java.io.*;
import java.util.*;

class Pointer1234{
	int index;
	int val;
	public Pointer1234(int index, int val){
		this.index = index;
		this.val = val;
	}
}

class Adjency{
	ArrayList<ArrayList<Integer>> list;
	int n;
	public Adjency(int n){
		this.list = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i <n; i++){
			this.list.add(new ArrayList<Integer>());
		}
	}
	
	public void addList(int a, int b){
		this.list.get(a).add(b);
		this.list.get(b).add(a);
	}
	
	public List<Integer> getList(int i){
			return this.list.get(i);
	}
}


public class 구름나라청소하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		Adjency adj = new Adjency(N+1); // 1베이스
		
		boolean visit[] = new boolean[N+1];
		for(int i = 0; i <N-1; i++){
				String str1[] = br.readLine().split(" ");
				int a = Integer.parseInt(str1[0]);
				int b = Integer.parseInt(str1[1]);
				adj.addList(a,b);
		}
		int arr[] = new int[N+1];
		String str2[] = br.readLine().split(" ");
		List<Pointer1234> nodeList = new ArrayList<>();
		for(int i = 1; i <=N; i++){
			 // arr[i] = Integer.parseInt(str2[i-1]); 
			int num = Integer.parseInt(str2[i-1]);
			nodeList.add(new Pointer1234(i,num));
		}
		Collections.sort(nodeList,new Comparator<Pointer1234>(){
			public int compare(Pointer1234 o1, Pointer1234 o2){
				return o2.val - o1.val;
			}
		});
		
		
		Queue<Integer> q = new LinkedList<>();
		// 구현층
		// 조건 : 인접한 도시로 이동
		// 이동하여 쓰레기 담기 k보다 넘으면 담지 못함
		q.add(1);
		visit[1] = true;
		int sum = 0;
		for(Pointer1234 node: nodeList){
			if(node.index == 1) sum += node.val;
		}
		while(!q.isEmpty()){
			int curr = q.poll(); // 연결되는 것을 다 담아
			for(Pointer1234 node: nodeList){
					if(!visit[node.index] && check(curr,node,adj)){
						if(K < sum+node.val){
							q.add(node.index);
							visit[node.index] = true;
							continue;
						}else{
							visit[node.index] = true;
							sum += node.val;
							q.add(node.index);
						}
					}
				}
			}
	

		System.out.println(sum);
	}
	public static boolean check(int check, Pointer1234 node,Adjency adj){
		
		 List<Integer> list1 = adj.getList(check);
		 for(int target :list1){
			 	if(target == node.index){
					return true;
				}
			 // 연결 됨
		 }
		return false; // 연결 안됨
	}
}