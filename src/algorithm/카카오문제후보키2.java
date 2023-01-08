package algorithm;

public class 카카오문제후보키2 {
	public static void main(String[] args) {
		int arr [] = {1,2,3,4,5,6};
		int answer = 0;
		boolean visit[] = new boolean[arr.length+1] ;
		
		for(int i = 1; i < arr.length ; i++) {
			int a = ~(i | ~(7));
			// 0001 = 001
			// 0111 = 000
			// 0110   001			
			for(int j = 0; j <arr.length; j++) {
				if(a == arr[j]) {
					if(!visit[i] && !visit[j]) {
						visit[i] = true;
						visit[j+1] = true;
						answer++;
					
					}
				}
			}
		}
		System.out.println(answer);
			
		
	}
}
