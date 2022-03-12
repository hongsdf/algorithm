package algorithm;


public class No24_1 {
	public static void main(String[] args) {
		int stu = 8;
		int in[] = {7,100,95,90,80,70,60,50};
//		System.out.println(in[0]);
		int total = 0;
		for(int i = 0; i < in.length; i++) {
			total += in[i];
		}
		
		System.out.print(total);
		
		double avg = total/stu;
		System.out.print(avg);
		
		int cnt = 0; // 평균이상 학생
		for(int i = 0; i < in.length; i++) {
			if(in[i] > avg) {
				System.out.println(in[i]+"학생은 평균이상");
				cnt++;
			}
		}
		System.out.println(cnt);
//		System.out.println(cnt/stu *100);
		System.out.println(cnt/(double)stu * 100);
	}
}
