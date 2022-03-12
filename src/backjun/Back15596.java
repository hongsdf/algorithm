package backjun;

public class Back15596 {
//	Java: long sum(int[] a); (클래스 이름: Test)
//	a: 합을 구해야 하는 정수 n개가 저장되어 있는 배열 (0 ≤ a[i] ≤ 1,000,000, 1 ≤ n ≤ 3,000,000)
//	리턴값: a에 포함되어 있는 정수 n개의 합
	static int a[] = new int[1000];
	
	
	static long Test(int[] a) {
		 
		long tot = 0;
		for(int i = 0; i< a.length; i++) {
			tot += a[i];
		} 
		 return tot;
		
	}
	public static void main(String[] args) {
		int b[] = new int[5];
		b[0] = 1;
		b[1] = 2;
		b[2] = 3;
		b[3] = 4;
		b[4] = 5;
		long ans = 0;
		ans = Test(b);
		System.out.println(ans);
		
	}
	
}
