package datastructure;

public class Test {
	public static void main(String[] args) {
		int n = 3;
		while(n>0) {
			if(n == 1) {
				System.out.println(n);
				continue;
			}
			if(n > 2) {
				System.out.println(n);
				n--;
				break;
			}
			System.out.println(n);
			n--;
		}
	}
}
