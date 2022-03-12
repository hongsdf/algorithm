package recursive1;

public class Hinoi {
	// static 영역 메모리
	static int answer = 0;
	
	public static void main(String[] args) {
		// stack 영역 메모리
		int n = 3;
		System.out.println((int)(Math.pow(2, n) -1));
		hinoi(n,1,2,3);
//		System.out.println(answer);
		
	}

	public static void hinoi(int n, int start, int mid, int to) {
	
		// base-case
		if(n ==1) {
			System.out.println(start +"-->"+to);
//			return answer++;
			answer++;
			return; 
		}
	
		
		hinoi(n-1,start,to,mid); // 1 1 2 3 --> 2 1 2 3
		System.out.println(start +"-->"+to);
		hinoi(n-1,mid,start,to);
		answer++;
		
		
	}
	
}
