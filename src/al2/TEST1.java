package al2;

public class TEST1 {
	public static void main(String[] args) {
		double n = 3.141592;
		// 2번째 반올림
		n = n *1000;
		n = Math.round(n); // 3142
		n = n/1000; //3.14
		System.out.printf("%.2f",n);
		
	}
}
