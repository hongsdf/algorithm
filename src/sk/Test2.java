package sk;

import java.util.*;
public class Test2 {
	public static void main(String[] args) {
		Solution2 m = new Solution2();
//		2, 2, -1, 1, 5, -1, 5
//		2,2,-1,1,5,-1,5
		int[] p = {2, 2, -1, 1, 5, -1, 5}; 
		int[] b = {1, 5};
		int[] answer = m.solution(p, b);
		for(int a :answer) {
			System.out.println(a);
		}
	}
}

class Adj{
    ArrayList<ArrayList<Integer>> list;
    int n;
    // 생성자
    public Adj(int n){
        this.list = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i <n; i++){
            this.list.add(new ArrayList<Integer>());
        }
    }

    // 연결 (양방향 연결)
    public void addList(int a, int b){
        this.list.get(a).add(b);
        this.list.get(b).add(a);
    }

    // 하나의 연결된 지점 반환
    public ArrayList<Integer> getList(int i){
        return this.list.get(i);
    }

}

class Solution2 {
    boolean visit[];
    int arr[];
    public int[] solution(int[] p, int[] b) {
       
        List<int[]> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        // 트리구조
        // 누가 누구의 보스인지 파악함 
        // 최종보스를 포함하여 해당 조직원의 수를 찾기

        // p : 조직원들의 배열
        // b :조사하고자 하는 조직원

        arr = new int[p.length];
        for(int i = 0; i <p.length; i++) {
        	arr[i] = p[i];
        }
        
        visit = new boolean[p.length];
        Adj adj = new Adj(p.length);
        for(int i = 0; i <p.length; i++){
        	if(p[i] == -1) continue;
            adj.addList(i,p[i]);
        }

        // 로직처리
        // 같은 그래프인지
        for(int point : b){
            int cnt = dfs(point,adj);
            list2.add(cnt);
        }
        int[] answer = new int[list2.size()];
        for(int i = 0; i <answer.length; i++){
            answer[i] = list2.get(i);
        }

        return answer;
    }

    public int dfs(int point, Adj adj){
        int cnt = 0;
        if(arr[point] != -1) {
        	return cnt;
        }
        Stack<Integer> st = new Stack<>();
        st.push(point);
       
        
        while(!st.isEmpty()){
            int curr = st.pop();
            if(visit[curr]) continue;
            visit[curr] = true;
            cnt++;

            ArrayList<Integer> list = adj.getList(curr);
            for(int a : list){
                if(!visit[a]){
                    st.push(a);
                }
            }

           
        }
        return cnt;
    }
}

