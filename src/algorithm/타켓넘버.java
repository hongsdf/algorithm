package algorithm;

public class 타켓넘버 {
	public static void main(String[] args) {
		SolutionK1011 m = new SolutionK1011();
		int[] numbers = {1,1,1,1};
		int target = 3;
		int answer = m.solution(numbers, target);
		System.out.println(answer);
		
	}

}
class SolutionK1011 {
     
    int value = 0;
    public int solution(int[] numbers, int target) {
    	
    	dfs(0,numbers,target,0);
        
        return value;
    }

	private void dfs(int depth, int[] numbers, int target, int sum) {
		if(depth == numbers.length){
			if(sum == target) value++;
			return;
		}
		
		// 1+1+1-1 유형
		sum += numbers[depth];
		dfs(depth+1,numbers,target,sum);
		sum -= numbers[depth];
		sum += (numbers[depth] * -1);
		dfs(depth+1,numbers,target,sum);
		
		
	}
    
    
}