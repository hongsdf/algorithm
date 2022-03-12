package Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class comparator_2D {
	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		
		// 정렬 전 출력
		for(int i=0; i<tickets.length; i++) {
//		방법1	 : 원소 출력 형식
//		List<String> res = Arrays.asList(tickets[i]);
//		for(String s:res) System.out.print(s +" ");
		
//		방법2 : return List형식
		System.out.println(Arrays.asList(tickets[i]));
		
		}
		
		Arrays.sort(tickets,new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				if(o1[0].toString().contentEquals(o2[0].toString())) {
					return o1[1].toString().compareTo(o2[1].toString());
				}else {
					return o1[0].toString().compareTo(o2[0].toString());
				}
				
			}
			
			
			
		});
		
		
		
		
		
		
		// 정렬 후 출력
		System.out.println("정렬 후 ");
		for(int i =0; i<tickets.length; i++) {
			System.out.println(Arrays.asList(tickets[i]) );
		}
	
	}
}
