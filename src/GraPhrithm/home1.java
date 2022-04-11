package GraPhrithm;
import java.util.*;
public class home1 {
	public static void main(String[] args) {
		Solutionhome1 m = new Solutionhome1();
		String path = "EEESEEEEEENNNN";
		m.solution(path); 
	}
}
class Solutionhome1{
	public String[] solution(String path) {
	
		List<Integer> list = new ArrayList<>();
		List<String> ans = new ArrayList<>();
		
		char navi[] = path.toCharArray();
		int cnt = 1;
		for(int i = 0; i <navi.length-1; i++) {
			if(navi[i] == navi[i+1]) {
				cnt++;
			}else {
				list.add(cnt);
				cnt = 1;
			}
			
		}
		list.add(cnt);
		// North : left
		// South : right
		
		int time = 1;
		String direction ="";
		for(int i = 0; i <list.size()-1; i++) {
			int idx = list.get(i)+time-1;
			if(navi[idx-1] == 'E' && navi[idx] == 'S'){
				direction  = "right";
			}
			else if(navi[idx-1] == 'S' && navi[idx] == 'E'){
				direction  = "left";
			}
			else if(navi[idx-1] == 'E' && navi[idx] == 'N'){
				direction  = "left";
			}else if(navi[idx-1] == 'S' && navi[idx] == 'W'){
				direction  = "right";
			}else if(navi[idx-1] == 'N' && navi[idx] == 'E'){
				direction  = "right";
			}else if(navi[idx-1] == 'N' && navi[idx] == 'S'){
				direction  = "left";
			}else if(navi[idx-1] == 'W' && navi[idx] == 'S'){
				direction  = "left";
			}else if(navi[idx-1] == 'W' && navi[idx] == 'N'){
				direction  = "right";
			}
			
			
			int num = list.get(i) *100;
			if(num >= 500) num = 500; 
			ans.add("Time "+(time-1)+": GO straight "+num+"m and turn "+ direction );
			time += list.get(i);
			
			
		}
		
//		time += cnt;
//		cnt = 0;
		String[] answer = new String[ans.size()];
		for(int i = 0; i <ans.size(); i++) {
			answer[i] = ans.get(i);
		}
		return answer;
	}
}