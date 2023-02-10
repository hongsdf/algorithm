package algorithm;

public class test1 {
	public static void main(String[] args) {
		Solution1111 m = new Solution1111();
		int[] numbers = {1,1,1,1};
		int answer = m.solution(numbers);
		System.out.println(answer);
		
	}
	
	
}
	class Solution1111 {
	    int answer = 0;
	    boolean visit[];
	    public int solution(int[] numbers) {
	        
	        int N = numbers.length;
	        visit = new boolean[N];
	        dfs(0,0,N,numbers);
	        dfs2(0,0,N,numbers);

	        return answer;
	    }

	    public void dfs(int depth,int sum, int N,int[] numbers){
	        if(depth == N){
	            if(sum == 0) answer++;
	            return;
	        }

	        for(int i = 0; i <numbers.length; i++){
	            if(!visit[i]){
	                visit[i] = true; // 부호 사용
	                sum += numbers[i];
	                dfs(depth+1, sum,N,numbers);	                
	                sum -= numbers[i];
	                dfs(depth+1, sum,N,numbers);
	                sum += numbers[i];
	                visit[i] = false;

	            }
	        }
	    }

	    public void dfs2(int depth,int sum, int N,int[] numbers){
	        if(depth == N){
	            if(sum == 0) answer++;
	            return;
	        }

	        for(int i = 0; i <numbers.length; i++){
	            if(!visit[i]){
	                visit[i] = true; // 부호 사용
	                sum -= numbers[i];
	                dfs(depth+1, sum,N,numbers);
	                sum += numbers[i];
	                visit[i] = false;
	            }
	        }
	    }
	}