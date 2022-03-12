package algorithm;

public class Pratice {
	
	private static int MAX(int i, int j, int k, int l) {
		if(i >= j && i>=k && i>=l) return i;
		else if (j >= i && j>= k && j>=l) return j;
		else if (k >= i && k >= j && k >=l) return k;
		else return l;
		
	}
	
	public static void main(String[] args) {
		int answer= MAX(5,4,4,300);
		System.out.println(answer);
	}
}
