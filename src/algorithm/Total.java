package algorithm;

public class Total {

	public static void main(String[] args) {

		int[][] array = {{95,80,100},{83,92,96},{78,83,93}};
		
		int sum=0;
		int total=0;
		double avg;
		
		for(int i =0; i < array.length; i++) {
			for(int j = 0; j <array[i].length ; j++) {
				System.out.print(array[i][j]+ " ");
			}
				System.out.println();
		}
		
		for(int i =0; i < array.length; i++) {
			for(int j = 0; j <array[i].length ; j++) {
				sum += array[i][j];
				System.out.print(array[i][j]+ " ");
			}
			System.out.print(i+"번 학생의 총점"+sum);
			total += sum;
			sum = 0;
			
			System.out.println();
		}
		avg = (double)total/array.length;
		System.out.println(avg);
		
		
		
	}
}
