package algorithm;

public class No13 {
	public static void main(String[] args) {
		int z = 0;
		for(int i = 1; i <5;i++) {
			for(int j = 1; j < 5; j++) {
				System.out.print(j+z + " ");
			}
			z +=4;
			System.out.println("");
		}
	}
}
