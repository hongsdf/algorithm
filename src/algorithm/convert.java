package algorithm;

public class convert {
	public static void main(String[] args) {
		int n = 4200;
		int OriginalTime = n;
		int hours = n/3600;
		n -= 3600 * hours;
	
		String hour = String.valueOf(hours);
		if(hour.length() == 1) {
			hour = "0"+hour;
		}
		
//		1시간 6분 40초
		int minutes = n/60;
		n -= 60 * minutes;
		int second = n;
		System.out.println(OriginalTime+" "+hour+"시간"+minutes+"분"+ second+"초");
	}
}
